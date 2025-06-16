
package com.mycompany.techmap.View;

import com.mycompany.techmap.Service.DataRepository;
import com.mycompany.techmap.model.Equipment;
import java.awt.Frame;
import java.util.Comparator;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class EquipmentPanel extends javax.swing.JPanel {

    public EquipmentPanel() {
        initComponents();
        initTableModel();
        updateEquipmentTable();
    }

    private void initTableModel() {
        tableModel = new DefaultTableModel(
            new Object[]{"Название", "Модель", "Используется", "Свободно"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        equipmentTable.setModel(tableModel);
    }

    void updateEquipmentTable() {
        tableModel.setRowCount(0);
        List<Equipment> all = DataRepository.getInstance().getEquipment();
        all.sort(Comparator.comparing(Equipment::getName));
        
        for (Equipment eq : all) {

            tableModel.addRow(new Object[]{
                eq.getName(),
                eq.getModel(),
                eq.getQuantity() - eq.getAvailableQuantity(),
                eq.getAvailableQuantity()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        equipmentLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        equipmentTable = new javax.swing.JTable();

        setPreferredSize(new java.awt.Dimension(681, 525));

        equipmentLabel.setText("Оборудование");

        addButton.setText("Добавить оборудование");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        equipmentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equipmentTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(equipmentTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(equipmentLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(equipmentLabel)
                    .addComponent(addButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        EquipmentForm dialog = new EquipmentForm((Frame) SwingUtilities.getWindowAncestor(this), true);
        dialog.setVisible(true);

        if (dialog.isConfirmed()) {
            Equipment eq = dialog.getCreatedEquipment();
            DataRepository.getInstance().addEquipment(eq);
            updateEquipmentTable();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    private void equipmentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equipmentTableMouseClicked
        if (evt.getClickCount() == 2) {
            showUsageDetails();
        }
    }//GEN-LAST:event_equipmentTableMouseClicked
 
    private void showUsageDetails() {
        int selectedRow = equipmentTable.getSelectedRow();
        if (selectedRow >= 0) {
            String name = (String) tableModel.getValueAt(selectedRow, 0);
            String model = (String) tableModel.getValueAt(selectedRow, 1);

            Equipment equipment = DataRepository.getInstance().findEquipment(name, model);
            if (equipment != null && !equipment.getUsages().isEmpty()) {
                UsageDialog dialog = new UsageDialog(
                        (Frame) SwingUtilities.getWindowAncestor(this),
                        true,
                        name + " (" + model + ")",
                        equipment.getUsages()
                );
                dialog.setVisible(true);
            }
        }
    }
    
    private DefaultTableModel tableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel equipmentLabel;
    private javax.swing.JTable equipmentTable;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
