
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

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
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
        return name + " [" + model + "] — свободно: " + getAvailableQuantity();
    }
}
