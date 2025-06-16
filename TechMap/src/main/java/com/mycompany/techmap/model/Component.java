
package com.mycompany.techmap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Представляет компонент, используемый в технологических процессах.
 * Хранит название, тип, общее количество и информацию об использовании в изделиях.
 */
public class Component {
    private String name;
    private String type;
    private int quantity;
    @JsonIgnore
    private final List<UsageInfo> usages = new ArrayList<>();
    
    public Component() {}

    public Component(String name, String type, int quantity) {
        this.name = name;
        this.type = type;
        this.quantity = quantity;
    }
    
    /**
     * @return название компонента
     */
    public String getName() {
        return name;
    }
    /**
     * @param name новое название компонента
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return тип компонента
     */
    public String getType() {
        return type;
    }
    /**
     * @param type новый тип компонента
     */
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * @return общее количество компонента на складе
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * @param quantity новое общее количество компонента
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    /**
     * @return список использований компонента в разных изделиях
     */
    public List<UsageInfo> getUsages() {
        return usages;
    }
    
    /**
     * @return количество свободных (неиспользуемых) компонентов
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
     * Добавляет информацию об использовании компонента в конкретном изделии.
     *
     * @param product изделие
     * @param amount количество использованных компонентов
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
        if (!(obj instanceof Component)) return false;
        Component c = (Component) obj;
        return Objects.equals(name, c.name) && Objects.equals(type, c.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
    
    @Override
    public String toString() {
        return name + " [" + type + "]: " + getAvailableQuantity() + " шт.";
    }
}
