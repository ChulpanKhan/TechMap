
package com.mycompany.techmap.View;

import com.mycompany.techmap.Service.DataRepository;
import com.mycompany.techmap.model.PersonnelType;
import java.awt.Frame;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;

public class PersonnelPanel extends javax.swing.JPanel {

    public PersonnelPanel() {
        initComponents();
        updatePersonnelList();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        personnelList = new javax.swing.JList<>();
        addButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(681, 525));

        jLabel1.setText("Типы персонала");

        personnelListModel = new DefaultListModel<>();
        personnelList.setModel(personnelListModel);
        personnelList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(personnelList);

        addButton.setText("Добавить тип пероснала");
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
                .addGap(144, 144, 144)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(addButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
            PersonnelForm dialog = new PersonnelForm((Frame)SwingUtilities.getWindowAncestor(this), true);
            dialog.setVisible(true);

            if (dialog.isConfirmed()) {
                PersonnelType pt = dialog.getCreatedPersonnel();
                DataRepository.getInstance().addPersonnelType(pt);
                updatePersonnelList();
            }
    }//GEN-LAST:event_addButtonActionPerformed
    void updatePersonnelList() {
        personnelListModel.clear();
        List<PersonnelType> all = DataRepository.getInstance().getPersonnelTypes();
        all.sort(Comparator.comparing(PersonnelType::getRole));
        for (PersonnelType pt : all) {
            personnelListModel.addElement(pt);
        }
    }
    
    private DefaultListModel<PersonnelType> personnelListModel;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<PersonnelType> personnelList;
    // End of variables declaration//GEN-END:variables
}
