package com.mycompany.techmap.model;

import java.util.List;
import java.util.Objects;
/**
 * Представляет один этап технологического процесса.
 */
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
    
    /**
     * @return уникальный идентификатор этапа
     */
    public String getId(){
        return id;
    }
    /**
     * @param id новый идентификатор
     */
    public void setId(String id){
        this.id = id;
    }
    
    /**
     * @return название этапа
     */
    public String getName(){
        return name;
    }
    /**
     * @param name новое название
     */
    public void setName(String name){
        this.name = name;
    }
    /**
     * @return организация
     */
    public Organization getOrganization() {
        return organization;
    }
    /**
     * @param organization новая организация
     */
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
    /**
     * @return список компонентов
     */
    public List<Component> getComponents() {
        return components;
    }
    /**
     * @param components новые компоненты
     */
    public void setComponents(List<Component> components) {
        this.components = components;
    }
    /**
     * @return список оборудования
     */
    public List<Equipment> getEquipment() {
        return equipment;
    }
    /**
     * @param equipment новые оборудования
     */    
    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }
    /**
     * @return требования к персоналу
     */
    public List<PersonnelRequirement> getPersonnel() {
        return personnel;
    }
    /**
     * @param personnel новые требования к персоналу
     */    
    public void setPersonnel(List<PersonnelRequirement> personnel) {
        this.personnel = personnel;
    }

    /**
     * @return список ID следующих этапов
     */
    public List<String> getNextStepIds() {
        return nextStepIds;
    }
    /**
     * @param nextStepIds новые ID следующих этапов
     */
    public void setNextStepIds(List<String> nextStepIds) {
        this.nextStepIds = nextStepIds;
    }
    /**
     * Добавляет ID следующего этапа.
     * @param stepId идентификатор следующего этапа
     */
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
