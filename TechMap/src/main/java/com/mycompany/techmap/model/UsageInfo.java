
package com.mycompany.techmap.model;

public class UsageInfo {
    private final Product product;
    private int amount;
    
    public UsageInfo(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public void addAmount(int delta) {
        this.amount += delta;
    }

    @Override
    public String toString() {
        return product.getName() + ": " + amount;
    }
}
