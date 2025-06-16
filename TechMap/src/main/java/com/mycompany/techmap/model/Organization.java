
package com.mycompany.techmap.model;

import java.util.Objects;
/**
 * Представляет организацию, выполняющую производственные этапы.
 */
public class Organization {
    private String name;
    private String address;
    
    public Organization() {}

    public Organization(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    /**
     * @return название организации
     */
    public String getName() {
        return name;
    }
    /**
     * @param name новое название
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return адрес организации
     */
    public String getAddress() {
        return address;
    }
    /**
     * @param address новый адрес
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Organization)) return false;
        Organization org = (Organization) obj;
        return Objects.equals(name, org.name) && Objects.equals(address, org.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }
    
    @Override
    public String toString() {
        return name + " [" + address + "]";
    }
}
