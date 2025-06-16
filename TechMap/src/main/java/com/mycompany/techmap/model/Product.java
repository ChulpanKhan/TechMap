
package com.mycompany.techmap.model;

import java.util.Objects;

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
    
    //name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    //strategicDirection
    public String getStrategicDirection(){
        return strategicDirection;
    }    
    public void setStrategicDirection(String strategicDirection){
        this.strategicDirection = strategicDirection;
    }
    
    //technologyMap
    public TechnologyMap getTechnologyMap(){
        return technologyMap;
    }    
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
