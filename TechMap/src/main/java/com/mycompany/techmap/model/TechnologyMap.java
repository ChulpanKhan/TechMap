
package com.mycompany.techmap.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TechnologyMap {
    private Map<String, ProcessStep> steps = new HashMap<>();
    
    public TechnologyMap(){}
    
    public void addStep(ProcessStep step) {
        steps.put(step.getId(), step);
    }

    public ProcessStep getStep(String id) {
        return steps.get(id);
    }
    
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
    
    public void removeStep(String id) {
        steps.remove(id);
        for (ProcessStep step : steps.values()) {
            step.getNextStepIds().remove(id); //удаление ссылок у след степа на него
        }
    }
    
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
