
package com.mycompany.techmap.View;

import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import com.mycompany.techmap.model.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TechMapGraphPanel extends JPanel {
    
    private TechnologyMap techMap;
    private mxGraphComponent graphComponent;

    public TechMapGraphPanel(TechnologyMap techMap) {
        this.techMap = techMap;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        buildGraph();
    }
    
    public void refresh() {
        removeAll();
        buildGraph();
        revalidate();
        repaint();
    }
    
    private void buildGraph(){
        mxGraph graph = new mxGraph();
        Object parent = graph.getDefaultParent();
        Map<String, Object> vertexMap = new HashMap<>();
        
        graph.getModel().beginUpdate();
        
        try{
            List<ProcessStep> steps = new ArrayList<>(techMap.getAllSteps());
            steps.sort(Comparator.comparing(ProcessStep::getId)); //сортировка, чтобы этапы шли по порядку
            //узлы - этапы
            for (ProcessStep step : steps) {
                Object v = graph.insertVertex(parent, step.getId(), step.getName(), 0, 0, 160, 50);
                vertexMap.put(step.getId(), v);
            }
            //свящи между этапами
            for (ProcessStep step : steps) {
                Object from = vertexMap.get(step.getId());
                for (String nextId : step.getNextStepIds()) {
                    Object to = vertexMap.get(nextId);
                    if (to != null) {
                        graph.insertEdge(parent, null, "", from, to);
                    }
                }
            }
            mxCompactTreeLayout layout = new mxCompactTreeLayout(graph, false);
            layout.setLevelDistance(80);
            layout.setNodeDistance(30);
            layout.execute(parent);           
        } finally {
            graph.getModel().endUpdate();
        }
        
        
        graphComponent = new mxGraphComponent(graph);
        graphComponent.setConnectable(false);
        graph.setCellsEditable(false);
        graph.setCellsMovable(false);
        graph.setCellsResizable(false);
        graph.setAllowDanglingEdges(false);
        
        //клик по узлу
        graphComponent.getGraphControl().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                Object cell = graphComponent.getCellAt(e.getX(), e.getY());
                if (cell != null && graph.getModel().isVertex(cell)) {
                    String stepName = graph.getLabel(cell);
                    ProcessStep clickedStep = techMap.getAllSteps().stream()
                            .filter(s -> s.getName().equals(stepName))
                            .findFirst()
                            .orElse(null);
                    if (clickedStep != null) {
                        showStepDetails(clickedStep);
                    }
                }
            }
        });
        
        add(graphComponent);
    }
        
    private void showStepDetails(ProcessStep step) {
        StringBuilder info = new StringBuilder();
        info.append("Название: ").append(step.getName()).append("\n");
        info.append("Организация: ").append(step.getOrganization().getName()).append("\n\n");

        info.append("Оборудование:\n");
        for (Equipment eq : step.getEquipment()) {
            info.append("- ").append(eq).append("\n");
        }

        info.append("\nКомпоненты:\n");
        for (Component c : step.getComponents()) {
            info.append("- ").append(c.getName()).append(" [").append(c.getType()).append("]\n");
        }

        info.append("\nПерсонал:\n");
        for (PersonnelRequirement p : step.getPersonnel()) {
            info.append("- ").append(p.getType().getRole()).append(": ")
                    .append(p.getManHours()).append(" ч.\n");
        }

        JOptionPane.showMessageDialog(this, info.toString(), "Информация об этапе", JOptionPane.INFORMATION_MESSAGE);
    }
}
