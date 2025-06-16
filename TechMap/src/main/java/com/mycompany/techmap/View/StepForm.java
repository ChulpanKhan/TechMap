
package com.mycompany.techmap.View;

import com.mycompany.techmap.Service.DataRepository;
import com.mycompany.techmap.model.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class StepForm extends javax.swing.JDialog {

    private boolean confirmed = false;
    private ProcessStep createdStep;
    private final Product currentProduct;

    public StepForm(java.awt.Frame parent, boolean modal, Product product) {
        super(parent, modal);
        this.currentProduct = product;
        initComponents();
        refreshComboBoxes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formPanel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        idLabel = new javax.swing.JLabel();
        organizationLabel = new javax.swing.JLabel();
        organizationBox = new javax.swing.JComboBox<>(DataRepository.getInstance()
            .getOrganizations().toArray(new Organization[0]));
        jScrollPane1 = new javax.swing.JScrollPane();
        componentList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        idField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        equipmentList = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        personnelModel = new DefaultListModel<>();
        personnelList = new javax.swing.JList<>(personnelModel);
        addPersonnel = new javax.swing.JButton();
        personnelTypeBox = new javax.swing.JComboBox<>(DataRepository.getInstance()
            .getPersonnelTypes().toArray(new PersonnelType[0]));
        manHoursField = new javax.swing.JTextField();
        hoursLabel = new javax.swing.JLabel();
        personnelTypeLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cancelButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        nameCompLabel = new javax.swing.JLabel();
        compBox = new javax.swing.JComboBox<>(new DefaultComboBoxModel<>(
            DataRepository.getInstance().getComponents().toArray(new Component[0])));
    quantityCompField = new javax.swing.JTextField();
    quantityCompLabel = new javax.swing.JLabel();
    addComp = new javax.swing.JButton();
    equipmentNameLabel = new javax.swing.JLabel();
    quantityEquipLabel = new javax.swing.JLabel();
    equipmentBox = new javax.swing.JComboBox<>(new DefaultComboBoxModel<>(
        DataRepository.getInstance().getEquipment().toArray(new Equipment[0])));
quantityEquipField = new javax.swing.JTextField();
addEquip = new javax.swing.JButton();

setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

nameLabel.setText("Название этапа:");

idLabel.setText("ID этапа:");

organizationLabel.setText("Организация:");

componentList.setModel(componentListModel);
componentList.setToolTipText("Выберите компоненты (Ctrl+Click для множественного выбора)");
jScrollPane1.setViewportView(componentList);

jLabel1.setText("Компоненты:");

jLabel2.setText("Оборудование:");

equipmentList.setModel(equipmentListModel);
equipmentList.setToolTipText("Выберите оборудование (Ctrl+Click для множественного выбора)");
jScrollPane2.setViewportView(equipmentList);

jLabel3.setText("Персонал:");

jScrollPane3.setViewportView(personnelList);

addPersonnel.setText("Добавить персонал");
addPersonnel.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        addPersonnelActionPerformed(evt);
    }
    });

    hoursLabel.setText("Часы:");

    personnelTypeLabel.setText("Тип:");

    jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

    cancelButton.setText("Отмена");
    cancelButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            cancelButtonActionPerformed(evt);
        }
    });

    nextButton.setText("Далее");
    nextButton.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            nextButtonActionPerformed(evt);
        }
    });

    nameCompLabel.setText("Название:");

    quantityCompLabel.setText("Количество:");

    addComp.setText("Добавить компоненту");
    addComp.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addCompActionPerformed(evt);
        }
    });

    equipmentNameLabel.setText("Название:");

    quantityEquipLabel.setText("Количество:");

    addEquip.setText("Добавить оборудование");
    addEquip.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            addEquipActionPerformed(evt);
        }
    });

    javax.swing.GroupLayout formPanelLayout = new javax.swing.GroupLayout(formPanel);
    formPanel.setLayout(formPanelLayout);
    formPanelLayout.setHorizontalGroup(
        formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(formPanelLayout.createSequentialGroup()
            .addGap(11, 11, 11)
            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nameField)
                    .addComponent(idLabel)
                    .addComponent(nameLabel)
                    .addComponent(organizationLabel)
                    .addComponent(jLabel3)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addComponent(personnelTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(personnelTypeBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(organizationBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idField)
                    .addGroup(formPanelLayout.createSequentialGroup()
                        .addComponent(hoursLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addPersonnel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(manHoursField))))
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(formPanelLayout.createSequentialGroup()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(formPanelLayout.createSequentialGroup()
                    .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(formPanelLayout.createSequentialGroup()
                                    .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(nameCompLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(quantityCompLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(compBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(quantityCompField)
                                        .addComponent(addComp, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))))
                        .addGroup(formPanelLayout.createSequentialGroup()
                            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(quantityEquipLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(equipmentNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addEquip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(equipmentBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(quantityEquipField))))
                    .addGap(0, 29, Short.MAX_VALUE))))
        .addGroup(formPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jSeparator3)
            .addContainerGap())
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, formPanelLayout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(26, 26, 26))
    );
    formPanelLayout.setVerticalGroup(
        formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(formPanelLayout.createSequentialGroup()
            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(formPanelLayout.createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(idLabel)
                        .addComponent(jLabel1))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(formPanelLayout.createSequentialGroup()
                            .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(nameLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(organizationLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(organizationBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(formPanelLayout.createSequentialGroup()
                            .addGap(5, 5, 5)
                            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(nameCompLabel)
                                .addComponent(compBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(17, 17, 17)
                            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(quantityCompField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(quantityCompLabel))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(addComp)
                            .addGap(11, 11, 11)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(formPanelLayout.createSequentialGroup()
                            .addGap(34, 34, 34)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(equipmentBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(equipmentNameLabel))
                            .addGap(18, 18, 18)
                            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(quantityEquipLabel)
                                .addComponent(quantityEquipField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(16, 16, 16)
                            .addComponent(addEquip)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(formPanelLayout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(personnelTypeLabel)
                                .addComponent(personnelTypeBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(hoursLabel)
                                .addComponent(manHoursField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(addPersonnel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE))
                .addGroup(formPanelLayout.createSequentialGroup()
                    .addComponent(jSeparator1)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(formPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cancelButton)
                .addComponent(nextButton))
            .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(formPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(formPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        Organization org = (Organization) organizationBox.getSelectedItem();

        if (id.isEmpty() || name.isEmpty() || org == null || usedComponents.isEmpty() || usedEquipment.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Заполните все поля и добавьте ресурсы.");
            return;
        }

        ProcessStep step = new ProcessStep(id, name, org);
        step.setComponents(new ArrayList<>(usedComponents));
        step.setEquipment(new ArrayList<>(usedEquipment));

        step.setPersonnel(new ArrayList<>());
        for (int i = 0; i < personnelModel.size(); i++) {
            step.getPersonnel().add(personnelModel.get(i));
        }

        step.setNextStepIds(new ArrayList<>());

        createdStep = step;
        confirmed = true;
        dispose();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void addPersonnelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPersonnelActionPerformed
        try {
            PersonnelType type = (PersonnelType) personnelTypeBox.getSelectedItem();
            int hours = Integer.parseInt(manHoursField.getText());
            personnelModel.addElement(new PersonnelRequirement(type, hours));
            manHoursField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Введите корректное количество часов.");
        }
    }//GEN-LAST:event_addPersonnelActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void addCompActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCompActionPerformed
        Component selected = (Component) compBox.getSelectedItem();
        String qtyText = quantityCompField.getText().trim();

        if (selected == null || qtyText.isEmpty()) {
            return;
        }

        try {
            int qty = Integer.parseInt(qtyText);
            if (qty <= 0) {
                throw new NumberFormatException();
            }

            if (selected.getAvailableQuantity() < qty) {
                JOptionPane.showMessageDialog(this, "Недостаточно неиспользованных компонент.");
                return;
            }

            selected.addUsage(currentProduct, qty);
            
            Component added = new Component(selected.getName(), selected.getType(), qty);

            usedComponents.add(added);
            componentListModel.addElement(added);
            componentList.setModel(componentListModel);
            quantityCompField.setText("");
            refreshComboBoxes();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Введите корректное целое положительное число.");
        }
    }//GEN-LAST:event_addCompActionPerformed

    private void addEquipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEquipActionPerformed
        Equipment selected = (Equipment) equipmentBox.getSelectedItem();
        String qtyText = quantityEquipField.getText().trim();

        if (selected == null || qtyText.isEmpty()) {
            return;
        }

        try {
            int qty = Integer.parseInt(qtyText);
            if (qty <= 0) {
                throw new NumberFormatException();
            }

            if (selected.getAvailableQuantity() < qty) {
                JOptionPane.showMessageDialog(this, "Недостаточно оборудования.");
                return;
            }

            selected.addUsage(currentProduct, qty);
            Equipment added = new Equipment(selected.getName(), selected.getModel(), qty);
            usedEquipment.add(added);
            equipmentListModel.addElement(added);
            quantityEquipField.setText("");
            refreshComboBoxes();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Введите корректное целое положительное число.");
        }
    }//GEN-LAST:event_addEquipActionPerformed


    public boolean isConfirmed() {
        return confirmed;
    }

    public ProcessStep getCreatedStep() {
        return createdStep;
    }
    
    private void refreshComboBoxes() {
        // Обновляем комбобокс компонентов
        DefaultComboBoxModel<Component> componentModel = new DefaultComboBoxModel<>(
                DataRepository.getInstance().getComponents().toArray(new Component[0]));
        compBox.setModel(componentModel);

        // Обновляем комбобокс оборудования
        DefaultComboBoxModel<Equipment> equipmentModel = new DefaultComboBoxModel<>(
                DataRepository.getInstance().getEquipment().toArray(new Equipment[0]));
        equipmentBox.setModel(equipmentModel);
    }
    
    private DefaultListModel<PersonnelRequirement> personnelModel;
    private final List<Component> usedComponents = new ArrayList<>();
    private final DefaultListModel<Component> componentListModel = new DefaultListModel<>();
    private final List<Equipment> usedEquipment = new ArrayList<>();
    private final DefaultListModel<Equipment> equipmentListModel = new DefaultListModel<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addComp;
    private javax.swing.JButton addEquip;
    private javax.swing.JButton addPersonnel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<Component> compBox;
    private javax.swing.JList<Component> componentList;
    private javax.swing.JComboBox<Equipment> equipmentBox;
    private javax.swing.JList<Equipment> equipmentList;
    private javax.swing.JLabel equipmentNameLabel;
    private javax.swing.JPanel formPanel;
    private javax.swing.JLabel hoursLabel;
    private javax.swing.JTextField idField;
    private javax.swing.JLabel idLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField manHoursField;
    private javax.swing.JLabel nameCompLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton nextButton;
    private javax.swing.JComboBox<Organization> organizationBox;
    private javax.swing.JLabel organizationLabel;
    private javax.swing.JList<PersonnelRequirement> personnelList;
    private javax.swing.JComboBox<PersonnelType> personnelTypeBox;
    private javax.swing.JLabel personnelTypeLabel;
    private javax.swing.JTextField quantityCompField;
    private javax.swing.JLabel quantityCompLabel;
    private javax.swing.JTextField quantityEquipField;
    private javax.swing.JLabel quantityEquipLabel;
    // End of variables declaration//GEN-END:variables
}
