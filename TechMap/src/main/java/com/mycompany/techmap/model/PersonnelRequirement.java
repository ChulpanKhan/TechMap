
package com.mycompany.techmap.model;

import java.util.Objects;

public class PersonnelRequirement {
    private PersonnelType type;
    private int manHours;
    
    public PersonnelRequirement() {}

    public PersonnelRequirement(PersonnelType type, int manHours) {
        this.type = type;
        this.manHours = manHours;
    }

    public PersonnelType getType() { return type; }
    public void setType(PersonnelType type) { this.type = type; }

    public int getManHours() { return manHours; }
    public void setManHours(int manHours) { this.manHours = manHours; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PersonnelRequirement)) return false;
        PersonnelRequirement requirement = (PersonnelRequirement) obj;
        return manHours == requirement.manHours && Objects.equals(type, requirement.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, manHours);
    }
    
        
    @Override
    public String toString() {
        return type + " [" + manHours + "]";
    }
}
