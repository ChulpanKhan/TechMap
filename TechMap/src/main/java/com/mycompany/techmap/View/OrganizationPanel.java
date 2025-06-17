
package com.mycompany.techmap.View;

import com.mycompany.techmap.Service.DataRepository;
import com.mycompany.techmap.model.Organization;
import java.awt.Frame;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public class OrganizationPanel extends javax.swing.JPanel {

    public OrganizationPanel() {
        initComponents();
        updateOrganizationList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        organizationList = new javax.swing.JList<>();
        addButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(681, 525));

        jLabel1.setText("Организации");

        organizationListModel = new DefaultListModel<>();
        organizationList.setModel(organizationListModel);
        organizationList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(organizationList);

        addButton.setText("Добавить организацию");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(161, 161, 161)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(184, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(addButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        OrganizationForm dialog = new OrganizationForm((Frame)SwingUtilities.getWindowAncestor(this), true);
        dialog.setVisible(true);

        if (dialog.isConfirmed()) {
            Organization org = dialog.getCreatedOrganization();
            DataRepository.getInstance().addOrganization(org);
            updateOrganizationList();
        }
    }//GEN-LAST:event_addButtonActionPerformed

    void updateOrganizationList() {
        organizationListModel.clear();
        List<Organization> all = DataRepository.getInstance().getOrganizations();
        all.sort(Comparator.comparing(Organization::getName));
        for (Organization org : all) {
            organizationListModel.addElement(org);
        }
    }

    private DefaultListModel<Organization> organizationListModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<Organization> organizationList;
    // End of variables declaration//GEN-END:variables
}
