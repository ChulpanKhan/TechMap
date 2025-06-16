
package com.mycompany.techmap.model;

import java.util.List;
import java.util.Objects;

public class ProcessStep {
    private String id;
    private String name;
    private Organization organization;
    private List<Component> components;
    private List<Equipment> equipment;
    private List<PersonnelRequirement> personnel;
    private List<String> nextStepIds; // id следующих этапов
    
    public ProcessStep() {}

    public ProcessStep(String id, String name, Organization organization) {
        this.id = id;
        this.name = name;
        this.organization = organization;
    }
    
    //id
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    
    //name
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    //organization
    public Organization getOrganization() {
        return organization;
    }
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
    //components
    public List<Component> getComponents() {
        return components;
    }
    public void setComponents(List<Component> components) {
        this.components = components;
    }
    //equipment
    public List<Equipment> getEquipment() {
        return equipment;
    }
    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }
    //personnel
    public List<PersonnelRequirement> getPersonnel() {
        return personnel;
    }
    public void setPersonnel(List<PersonnelRequirement> personnel) {
        this.personnel = personnel;
    }
    //nextStepIds
    public List<String> getNextStepIds() {
        return nextStepIds;
    }
    public void setNextStepIds(List<String> nextStepIds) {
        this.nextStepIds = nextStepIds;
    }
    
    public void addNextStep(String stepId) {
        nextStepIds.add(stepId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ProcessStep)) return false;
        ProcessStep step = (ProcessStep) obj;
        return Objects.equals(id, step.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
