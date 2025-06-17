
package com.mycompany.techmap.View;

import com.mycompany.techmap.Service.DataRepository;
import com.mycompany.techmap.model.ProcessStep;
import com.mycompany.techmap.model.Product;
import com.mycompany.techmap.model.TechnologyMap;
import java.awt.BorderLayout;
import java.awt.Frame;
import javax.swing.JOptionPane;

public class TechMapGraphEditorDialog extends javax.swing.JDialog {
    
    private Product product;

    public TechMapGraphEditorDialog(Product product) {
        super((Frame) null, "Редактор технологической карты: " + product.getName(), true);
        this.product = product; 
        initComponents();
        initTechMapPanel(); 
        setLocationRelativeTo(null);
    }

    private void initTechMapPanel() {
        graphPanel.setLayout(new BorderLayout());

        techMapPanel = new TechMapGraphPanel(product.getTechnologyMap());
        graphPanel.add(techMapPanel, BorderLayout.CENTER);

        graphPanel.revalidate();
        graphPanel.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graphPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();
        addStepButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Теxнологическая карта");

        graphPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        graphPanel.setToolTipText("Нажмите на этап, чтобы увидеть его характеристики");

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 495, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        closeButton.setText("Закрыть");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        addStepButton.setText("Добавить этап");
        addStepButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStepButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addStepButton)
                .addGap(18, 18, 18)
                .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(closeButton)
                    .addComponent(addStepButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    private void addStepButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStepButtonActionPerformed
        if (!DataRepository.getInstance().hasAvailableResources()) {
            JOptionPane.showMessageDialog((Frame)getOwner(),
                    "Нет доступных компонентов и оборудования для создания этапа",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        StepForm form = new StepForm((Frame)getOwner(), true, product);
        form.setVisible(true);

        if (form.isConfirmed()) {
            ProcessStep newStep = form.getCreatedStep();
            TechnologyMap map = product.getTechnologyMap();
            map.addStep(newStep);

            if (map.getAllSteps().size() > 1) {
                StepConnectionDialog connectionDialog = new StepConnectionDialog((Frame) getOwner(), true, map, newStep);
                connectionDialog.setVisible(true);
            }

            techMapPanel.refresh();
        }      
    }//GEN-LAST:event_addStepButtonActionPerformed

    
    private TechMapGraphPanel techMapPanel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStepButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
