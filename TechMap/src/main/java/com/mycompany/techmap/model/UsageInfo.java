
package com.mycompany.techmap.model;
/**
 * Хранит информацию об использовании ресурса в конкретном изделии.
 */
public class UsageInfo {
    private final Product product;
    private int amount;
    
    public UsageInfo(Product product, int amount) {
        this.product = product;
        this.amount = amount;
    }
    
    /**
     * @return изделие
     */
    public Product getProduct() {
        return product;
    }
    /**
     * @return количество использования
     */
    public int getAmount() {
        return amount;
    }
    /**
     * Увеличивает количество использования.
     * @param delta прирост
     */
    public void addAmount(int delta) {
        this.amount += delta;
    }

    @Override
    public String toString() {
        return product.getName() + ": " + amount;
    }
}
