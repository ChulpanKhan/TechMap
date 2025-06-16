/**
 * Представляет требование к персоналу для этапа.
 */
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
    /**
     * @return тип персонала
     */
    public PersonnelType getType() {
        return type;
    }
    /**
     * @param type тип персонала
     */
    public void setType(PersonnelType type) {
        this.type = type;
    }
    /**
     * @return человеко-часы
     */
    public int getManHours() {
        return manHours;
    }
    /**
     * @param manHours количество человеко-часов
     */
    public void setManHours(int manHours) {
        this.manHours = manHours;
    }

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
        return type + " [" + manHours + "чел/час]";
    }
}
