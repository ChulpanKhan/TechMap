
package com.mycompany.techmap.View;

import com.mycompany.techmap.Service.DataRepository;
import com.mycompany.techmap.Service.JsonService;
import com.mycompany.techmap.model.*;
import java.awt.Frame;
import java.io.File;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProductPanel extends javax.swing.JPanel {

    public ProductPanel() {
        initComponents();
        updateProductList("Всё");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exportButton = new javax.swing.JButton();
        addProductButton = new javax.swing.JButton();
        importButton = new javax.swing.JButton();
        directionFilter = new javax.swing.JComboBox<>();
        showGraphButton = new javax.swing.JButton();
        filterButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        productList = new javax.swing.JList<>();
        exportAllButton = new javax.swing.JButton();

        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(681, 525));

        exportButton.setText("Экспортировать");
        exportButton.setToolTipText("экспорт выбранного изделия");
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        addProductButton.setText("Добавить изделие");
        addProductButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductButtonActionPerformed(evt);
            }
        });

        importButton.setText("Импортировать");
        importButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importButtonActionPerformed(evt);
            }
        });

        directionFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Всё", "СВЧ электроника", "Микроэлектроника", "Электротехника", "Оптика и фотоника", "Радиофотоника", "Пассивная ЭКБ", "Радиационностойкая ЭКБ" }));

        showGraphButton.setText("Показать граф");
        showGraphButton.setToolTipText("граф выбранного изделия");
        showGraphButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGraphButtonActionPerformed(evt);
            }
        });

        filterButton.setText("Обновить");
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        productListModel = new DefaultListModel<>();
        productList.setModel(productListModel);
        productList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(productList);

        exportAllButton.setText("Экспортировать все");
        exportAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportAllButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(directionFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(exportButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(importButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(showGraphButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addProductButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(exportAllButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(62, 62, 62))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(directionFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(showGraphButton)
                        .addGap(26, 26, 26)
                        .addComponent(addProductButton)
                        .addGap(29, 29, 29)
                        .addComponent(importButton)
                        .addGap(31, 31, 31)
                        .addComponent(exportButton)
                        .addGap(33, 33, 33)
                        .addComponent(exportAllButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        Product selected = productList.getSelectedValue();
        if (selected != null) {
            JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
            chooser.setFileFilter(new FileNameExtensionFilter("JSON файлы", "json"));
            int res = chooser.showSaveDialog(this);
            if (res == JFileChooser.APPROVE_OPTION) {
                try {
                    File selectedFile = chooser.getSelectedFile();

                    String filePath = selectedFile.getAbsolutePath();
                    if (!filePath.toLowerCase().endsWith(".json")) {
                        selectedFile = new File(filePath + ".json");
                    }

                    JsonService.saveProductToFile(selected, selectedFile);
                    JOptionPane.showMessageDialog(this,
                            "Данные успешно экспортированы в:\n" + selectedFile.getAbsolutePath(),
                            "Экспорт завершен",
                            JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this,
                            "Ошибка при экспорте: " + ex.getMessage(),
                            "Ошибка экспорта",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_exportButtonActionPerformed

    private void importButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importButtonActionPerformed
        JFileChooser chooser = new JFileChooser(new File(System.getProperty("user.dir")));
        chooser.setFileFilter(new FileNameExtensionFilter("JSON файлы", "json"));
        int res = chooser.showOpenDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            try {
                Product p = JsonService.loadProductFromFile(chooser.getSelectedFile());

                DataRepository repo = DataRepository.getInstance();
                repo.addProduct(p);
                for (ProcessStep step : p.getTechnologyMap().getAllSteps()) {
                    repo.registerStepResources(p, step);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Ошибка импорта", "Ошибка", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        MainWindow mainWindow = (MainWindow) SwingUtilities.getWindowAncestor(this);
        mainWindow.refreshAllPanels();
    }//GEN-LAST:event_importButtonActionPerformed

    private void exportAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportAllButtonActionPerformed
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = chooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File directory = chooser.getSelectedFile();
            List<Product> allProducts = DataRepository.getInstance().getAllProducts();

            int count = 0;
            for (Product product : allProducts) {
                try {
                    String baseName = product.getName().replaceAll("[^a-zA-Z0-9А-Яа-я\\-_]", "_");

                    File outFile = new File(directory, baseName + ".json");
                    int index = 1;

                    while (outFile.exists()) {
                        outFile = new File(directory, baseName + "_(" + index + ").json");
                        index++;
                    }

                    JsonService.saveProductToFile(product, outFile);
                    count++;

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this,
                            "Ошибка при сохранении: " + product.getName(),
                            "Ошибка экспорта", JOptionPane.ERROR_MESSAGE);
                }
            }

            JOptionPane.showMessageDialog(this,
                    "Экспортировано изделий: " + count,
                    "Успешно", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_exportAllButtonActionPerformed

    private void addProductButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductButtonActionPerformed
        ProductForm dialog = new ProductForm((Frame)SwingUtilities.getWindowAncestor(this), true);
        dialog.setVisible(true);

        if (dialog.isConfirmed()) {
            Product newProduct = dialog.getProduct();

            DataRepository.getInstance().addProduct(newProduct);

            updateProductList((String) directionFilter.getSelectedItem());

            TechMapGraphEditorDialog editor = new TechMapGraphEditorDialog(newProduct);
            editor.setVisible(true);
                        
            MainWindow mainWindow = (MainWindow) SwingUtilities.getWindowAncestor(this);
            mainWindow.refreshAllPanels();
        }
    }//GEN-LAST:event_addProductButtonActionPerformed

    private void showGraphButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGraphButtonActionPerformed
        Product selected = productList.getSelectedValue();
        if (selected != null) {
            TechMapGraphEditorDialog editor = new TechMapGraphEditorDialog(selected);
            editor.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Пожалуйста, выберите изделие из списка.");
        }
    }//GEN-LAST:event_showGraphButtonActionPerformed

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        String selectedDirection = (String) directionFilter.getSelectedItem();
        updateProductList(selectedDirection);
    }//GEN-LAST:event_filterButtonActionPerformed

    void updateProductList(String direction) {
        productListModel.clear();
        productListModel.clear();
        List<Product> allProducts = DataRepository.getInstance().getAllProducts();
        allProducts.sort(Comparator.comparing(Product::getName));
        for (Product p : allProducts) {
            if ("Всё".equals(direction) || p.getStrategicDirection().equalsIgnoreCase(direction)) {
                productListModel.addElement(p);
            }
        }
    }
    private DefaultListModel<Product> productListModel; 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProductButton;
    private javax.swing.JComboBox<String> directionFilter;
    private javax.swing.JButton exportAllButton;
    private javax.swing.JButton exportButton;
    private javax.swing.JButton filterButton;
    private javax.swing.JButton importButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<Product> productList;
    private javax.swing.JButton showGraphButton;
    // End of variables declaration//GEN-END:variables
}
