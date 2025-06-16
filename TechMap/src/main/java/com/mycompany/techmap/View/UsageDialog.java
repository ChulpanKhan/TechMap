
package com.mycompany.techmap.View;

import com.mycompany.techmap.model.UsageInfo;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class UsageDialog extends javax.swing.JDialog {


    public UsageDialog(java.awt.Frame parent, boolean modal, String componentName, List<UsageInfo> usages) {
        super(parent, modal);
        initComponents();
        initTableModel();
        setTitle("Использование компонента: " + componentName);
        fillUsageTable(usages);
    }
    
    private void initTableModel() {
        usageTableModel = new DefaultTableModel(
            new Object[]{"Изделие", "Количество"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        usageTabel.setModel(usageTableModel);
    }
    
    private void fillUsageTable(List<UsageInfo> usages) {
        usageTableModel.setRowCount(0); // Очищаем таблицу

        for (UsageInfo usage : usages) {
            usageTableModel.addRow(new Object[]{
                usage.getProduct().getName(),
                usage.getAmount()
            });
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        usagePanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usageTabel = new javax.swing.JTable();
        closeBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(usageTabel);

        closeBtn.setText("Закрыть");
        closeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout usagePanelLayout = new javax.swing.GroupLayout(usagePanel);
        usagePanel.setLayout(usagePanelLayout);
        usagePanelLayout.setHorizontalGroup(
            usagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usagePanelLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(usagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        usagePanelLayout.setVerticalGroup(
            usagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(usagePanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(closeBtn)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(usagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(usagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeBtnActionPerformed
        dispose();
    }//GEN-LAST:event_closeBtnActionPerformed

    
    private DefaultTableModel usageTableModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel usagePanel;
    private javax.swing.JTable usageTabel;
    // End of variables declaration//GEN-END:variables
}
