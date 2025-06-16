
package com.mycompany.techmap.model;

import java.util.Objects;

public class PersonnelType {
    private String role;
    
    public PersonnelType() {}

    public PersonnelType(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PersonnelType)) return false;
        PersonnelType type = (PersonnelType) obj;
        return Objects.equals(role, type.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(role);
    }
    
    @Override
    public String toString() {
        return role;
    }
}
