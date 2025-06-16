/**
 * Представляет оборудование, которое используется в процессах.
 * Хранит название, модель и количество, а также информацию об использовании.
 */
package com.mycompany.techmap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipment {
    private String name;
    private String model;
    private int quantity;
    @JsonIgnore
    private List<UsageInfo> usages = new ArrayList<>();
    
    public Equipment() {}

    public Equipment(String name, String model, int quantity) {
        this.name = name;
        this.model = model;
        this.quantity = quantity;
    }
    
    /**
     * @return название оборудования
     */
    public String getName() {
        return name;
    }
    /**
     * @param name новое название оборудования
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return модель оборудования
     */
    public String getModel() {
        return model;
    }
    /**
     * @param model новый модель оборудования
     */
    public void setModel(String model) {
        this.model = model;
    }
    /**
     * @return общее количество оборудования на складе
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * @param quantity новое общее количество оборудования
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    /**
     * @return список использований оборудования в разных изделиях
     */
    public List<UsageInfo> getUsages() {
        return usages;
    }    
    
    /**
     * @return количество свободного (неиспользуемых) оборудования
     */
    @JsonIgnore
    public int getAvailableQuantity() {
        int usedTotal = 0;
        for (UsageInfo usage : usages) {
            usedTotal += usage.getAmount();
        }
        return quantity - usedTotal;
    }
    /**
     * Добавляет информацию об использовании оборудования в конкретном изделии.
     *
     * @param product изделие
     * @param amount количество использованного оборудования
     */
    public void addUsage(Product product, int amount) {
        for (UsageInfo usage : usages) {
            if (usage.getProduct().equals(product)) {
                usage.addAmount(amount);
                return;
            }
        }
        usages.add(new UsageInfo(product, amount));
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Equipment)) return false;
        Equipment eq = (Equipment) obj;
        return Objects.equals(name, eq.name) && Objects.equals(model, eq.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, model);
    }
    
    @Override
    public String toString() {
        return name + " [" + model + "]: " + getAvailableQuantity() + " шт.";
    }
}
