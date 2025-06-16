
package com.mycompany.techmap.model;

import java.util.Objects;

public class Organization {
    private String name;
    private String address;
    
    public Organization() {}

    public Organization(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

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
        return name + " — " + address;
    }
}
