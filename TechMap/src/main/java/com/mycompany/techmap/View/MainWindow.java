
package com.mycompany.techmap.View;

import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainWindow extends javax.swing.JFrame {

    private ProductPanel productPanel;
    private ComponentsPanel componentsPanel;
    private EquipmentPanel equipmentPanel;
    private PersonnelPanel personnelPanel;
    private OrganizationPanel organizationPanel;
    
    public MainWindow() {
        initComponents();
        productPanel = new ProductPanel();
        componentsPanel = new ComponentsPanel();
        equipmentPanel = new EquipmentPanel();
        personnelPanel = new PersonnelPanel();
        organizationPanel = new OrganizationPanel();
        fillTabs();
    }
    private void fillTabs() {
        addTabWithLabel("Изделия", productPanel);
        addTabWithLabel("Компоненты", componentsPanel);
        addTabWithLabel("Оборудование", equipmentPanel);
        addTabWithLabel("Персонал", personnelPanel);
        addTabWithLabel("Организации", organizationPanel);
    }

    private void addTabWithLabel(String title, JPanel panel) {
        tabbedPane.addTab(null, panel);
        JLabel label = new JLabel("  " + title + "  ");
        label.setPreferredSize(new Dimension(120, 25));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, label);
    }
    
    public void refreshAllPanels() {
        productPanel.updateProductList("Всё");
        componentsPanel.updateComponentsTable();
        equipmentPanel.updateEquipmentTable();
        personnelPanel.updatePersonnelList();
        organizationPanel.updateOrganizationList();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Система управления технологическими картами ");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tabbedPane.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 793, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
}
