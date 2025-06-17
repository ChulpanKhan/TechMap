
package com.mycompany.techmap.View;

import com.mycompany.techmap.Service.DataRepository;
import com.mycompany.techmap.model.Component;
import java.awt.Frame;
import java.util.Comparator;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class ComponentsPanel extends javax.swing.JPanel {

    public ComponentsPanel() {
        initComponents();
        initTables();
        updateComponentsTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        compomentsLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        componentTable = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(681, 525));

        compomentsLabel.setText("Компоненты");

        addButton.setText("Добавить компонент");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        componentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                componentTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(componentTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(compomentsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compomentsLabel)
                    .addComponent(addButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        ComponentForm dialog = new ComponentForm((Frame) SwingUtilities.getWindowAncestor(this), true);
        dialog.setVisible(true);

        if (dialog.isConfirmed()) {
            Component newComponent = dialog.getCreatedComponent();
            DataRepository.getInstance().addComponent(newComponent);
            updateComponentsTable();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void componentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_componentTableMouseClicked
        if (evt.getClickCount() == 2) {
            showUsageDetails();
        }
    }//GEN-LAST:event_componentTableMouseClicked
    
    private void showUsageDetails() {
        int selectedRow = componentTable.getSelectedRow();
        if (selectedRow >= 0) {
            String componentName = (String) componentsTableModel.getValueAt(selectedRow, 0);
            String componentType = (String) componentsTableModel.getValueAt(selectedRow, 1);

            Component component = DataRepository.getInstance().findComponent(componentName, componentType);
            if (component != null) {
                showUsageDialog(component);
            }
        }
    }
    
    private void showUsageDialog(Component component) {
        UsageDialog dialog = new UsageDialog(
                (Frame) SwingUtilities.getWindowAncestor(this),
                true,
                component.getName(),
                component.getUsages()
        );
        dialog.setVisible(true);
    }

    
    void updateComponentsTable() {
        componentsTableModel.setRowCount(0);
        List<Component> components = DataRepository.getInstance().getComponents();
        
        components.sort(Comparator.comparing(Component::getName));
        
        for (Component c : components) {
            componentsTableModel.addRow(new Object[]{
                c.getName(),
                c.getType(),
                c.getQuantity() - c.getAvailableQuantity(),
                c.getAvailableQuantity()
            });
        }
    }
    
    private void initTables() {
        // Модель для основной таблицы компонентов
        componentsTableModel = new DefaultTableModel(
            new Object[]{"Название", "Тип", "Используется", "Свободно"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        componentTable.setModel(componentsTableModel);
    }
    
    private DefaultTableModel componentsTableModel;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel compomentsLabel;
    private javax.swing.JTable componentTable;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
