
package com.mycompany.techmap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public List<UsageInfo> getUsages() {
        return usages;
    }
    
     @JsonIgnore
    public int getAvailableQuantity() {
        int usedTotal = 0;
        for (UsageInfo usage : usages) {
            usedTotal += usage.getAmount();
        }
        return quantity - usedTotal;
    }
    
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
        // Для компонентов из репозитория (весь список) пусть останется старый стиль
        if (this.usages == null || this.usages.isEmpty()) {
            return name + " [" + type + "]: " + getAvailableQuantity();
        }

        // А для компонентов, которые добавлены как использованные
        return name + " [" + type + "] — используется: " + quantity;
    }
}
