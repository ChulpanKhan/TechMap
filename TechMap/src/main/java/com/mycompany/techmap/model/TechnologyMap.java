
package com.mycompany.techmap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Хранит технологические этапы изделия в виде карты (по ID).
 */
public class TechnologyMap {
    private Map<String, ProcessStep> steps = new HashMap<>();
    
    public TechnologyMap(){}
    
    /**
     * Добавляет новый этап в карту.
     * @param step этап
     */
    public void addStep(ProcessStep step) {
        steps.put(step.getId(), step);
    }
    /**
     * @param id этапа
     * @return этап
     */
    public ProcessStep getStep(String id) {
        return steps.get(id);
    }
    /**
     * Возвращает все этапы в виде списка.
     * @return список этапов
     */
    public Map<String, ProcessStep> getSteps() {
        return steps;
    }

    public void setSteps(Map<String, ProcessStep> steps) {
        this.steps = steps;
    }
    @JsonIgnore
    public List<ProcessStep> getAllSteps() {
        return new ArrayList<>(steps.values());
    }
    /**
     * Создает связь между этапами.
     * @param fromId ID исходного этапа
     * @param toId ID следующего этапа
     */
    public void connectSteps(String fromId, String toId) {
        ProcessStep from = steps.get(fromId);
        if (from != null) {
            if (from.getNextStepIds() == null) {
                from.setNextStepIds(new ArrayList<>());
            }
            if (!from.getNextStepIds().contains(toId)) {
                from.addNextStep(toId);
            }
        }
    }

    public boolean containsStep(String id) {
        return steps.containsKey(id);
    }
}
