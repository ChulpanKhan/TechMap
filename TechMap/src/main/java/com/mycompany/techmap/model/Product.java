
package com.mycompany.techmap.model;

import java.util.Objects;
/**
 * Представляет изделие, имеющее стратегическое направление и технологическую карту.
 */
public class Product {
    private String name;
    private String strategicDirection;
    private TechnologyMap technologyMap;
    
    public Product(){
        this.technologyMap = new TechnologyMap();
    }
        
    public Product(String name, String strategicDirection){
        this.name = name;
        this.strategicDirection = strategicDirection;
        this.technologyMap = new TechnologyMap();
    }
    
    /**
     * @return имя изделия
     */
    public String getName(){
        return name;
    }
    /**
     * @param name имя изделия
     */
    public void setName(String name){
        this.name = name;
    }
    
    /**
     * @return стратегическое направление изделия
     */
    public String getStrategicDirection(){
        return strategicDirection;
    }    
    /**
     * @param strategicDirection новое стратегическое направление
     */
    public void setStrategicDirection(String strategicDirection){
        this.strategicDirection = strategicDirection;
    }
    
    /**
     * @return технологическая карта изделия
     */
    public TechnologyMap getTechnologyMap(){
        return technologyMap;
    }   
    /**
     * @param technologyMap новая технологическая карта
     */
    public void setTechnologyMap(TechnologyMap technologyMap){
        this.technologyMap = technologyMap;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Product)) return false;
        Product product = (Product) obj;
        return Objects.equals(name, product.name) && Objects.equals(strategicDirection, product.strategicDirection);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, strategicDirection);
    }
    
    @Override
    public String toString() {
        return name + " (" + strategicDirection + ")";
    }
}
