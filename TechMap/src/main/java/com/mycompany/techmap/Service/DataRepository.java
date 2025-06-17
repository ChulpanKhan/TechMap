
package com.mycompany.techmap.Service;

import com.mycompany.techmap.model.*;

import java.util.ArrayList;
import java.util.List;
/**
 * Центральное хранилище всех данных приложения: компонентов, оборудования, организаций, персонала и изделий.
 * Реализован как Singleton.
 */
public class DataRepository {
    
    private List<Component> components;
    private List<Equipment> equipmentList;
    private List<PersonnelType> personnelTypes;
    private List<Organization> organizations;
    private List<Product> products;
    
    private static final DataRepository instance = new DataRepository();
    
    private DataRepository() {
        components = new ArrayList<>();
        equipmentList = new ArrayList<>();
        organizations = new ArrayList<>();
        personnelTypes = new ArrayList<>();
        products = new ArrayList<>();
    }
    
    public static DataRepository getInstance() {
        return instance;
    }
    
    /**
     * Регистрирует ресурсы этапа (добавляет их в хранилище).
     * @param product изделие, к которому относится этап
     * @param step этап
     */
    public void registerStepResources(Product product, ProcessStep step) {
        registerComponents(product, step.getComponents());
        registerEquipment(product, step.getEquipment());
        registerOrganization(step.getOrganization());
        registerPersonnelTypes(step.getPersonnel());
    }
    
    /**
     * Регистрирует список компонентов, связанных с изделием. Если компонент уже
     * существует, увеличивает его количество и добавляет использование. Если
     * компонент новый — добавляет в хранилище.
     *
     * @param product изделие, в рамках которого используются компоненты
     * @param componentsToAdd список компонентов, подлежащих регистрации
     */
    private void registerComponents(Product product, List<Component> componentsToAdd) {
        for (Component c : componentsToAdd) {
            Component existing = findComponent(c.getName(), c.getType());
            if (existing != null) {
                existing.setQuantity(existing.getQuantity() + c.getQuantity());
                existing.addUsage(product, c.getQuantity());
            } else {
                Component newComp = new Component(c.getName(), c.getType(), c.getQuantity());
                newComp.addUsage(product, c.getQuantity());
                components.add(newComp);
            }
        }
    }
    
    /**
     * Регистрирует список оборудования, связанного с изделием. При наличии уже
     * существующего оборудования увеличивает его количество и usage. Новое
     * оборудование добавляется в хранилище.
     *
     * @param product изделие, в рамках которого используется оборудование
     * @param equipmentToAdd список оборудования для регистрации
     */
    private void registerEquipment(Product product, List<Equipment> equipmentToAdd) {
        for (Equipment e : equipmentToAdd) {
            Equipment existing = findEquipment(e.getName(), e.getModel());
            if (existing != null) {
                existing.setQuantity(existing.getQuantity() + e.getQuantity());
                existing.addUsage(product, e.getQuantity());
            } else {
                Equipment newEq = new Equipment(e.getName(), e.getModel(), e.getQuantity());
                newEq.addUsage(product, e.getQuantity());
                equipmentList.add(newEq);
            }
        }
    }
    
    /**
     * Регистрирует организацию в хранилище, если она ещё не была добавлена.
     *
     * @param org организация, участвующая в производственном процессе
     */
    private void registerOrganization(Organization org) {
        addOrganization(org);
    }
    
    /**
     * Регистрирует все типы персонала, используемые в переданном списке
     * требований. При наличии новых типов — добавляет их в хранилище.
     *
     * @param personnel список требований к персоналу, содержащих используемые
     * типы
     */
    private void registerPersonnelTypes(List<PersonnelRequirement> personnel) {
        for (PersonnelRequirement p : personnel) {
            addPersonnelType(p.getType());
        }
    }
    /**
     * Проверяет, есть ли доступные (неиспользованные) компоненты и оборудование.
     * @return true если что-то доступно
     */
    public boolean hasAvailableResources() {
        boolean foundComponent = false;
        for (Component component : components) {
            if (component.getAvailableQuantity() > 0) {
                foundComponent = true;
                break;
            }
        }
        if (!foundComponent) {
            return false;
        }
        for (Equipment equipment : equipmentList) {
            if (equipment.getAvailableQuantity() > 0) {
                return true; // Нашли и компоненты, и оборудование
            }
        }       
        return false;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public List<Component> getComponents() {
        return components;
    }

    public List<Equipment> getEquipment() {
        return equipmentList;
    }

    public List<PersonnelType> getPersonnelTypes() {
        return personnelTypes;
    }

    public void addProduct(Product product) {
        if (!products.contains(product)) {
            products.add(product);
        }
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    //компоненты
    public void addComponent(Component component) {
        Component existing = findComponent(component.getName(), component.getType());
        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + component.getQuantity());
        } else {
            components.add(component);
        }
    }

    
    public Component findComponent(String name, String type) {
        for (Component c : components) {
            if (c.getName().equalsIgnoreCase(name) && c.getType().equalsIgnoreCase(type)) {
                return c;
            }
        }
        return null;
    }

    //оборудование
    public void addEquipment(Equipment equipment) {   
        Equipment existing = findEquipment(equipment.getName(), equipment.getModel());
        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + equipment.getQuantity());
        } else {
            equipmentList.add(equipment);
        }
    }

    public Equipment findEquipment(String name, String model) {
        for (Equipment e : equipmentList) {
            if (e.getName().equalsIgnoreCase(name) && e.getModel().equalsIgnoreCase(model)) {
                return e;
            }
        }
        return null;
    }

    //организации
    public void addOrganization(Organization org) {
        if (!organizations.contains(org)) {
            organizations.add(org);
        }
    }

    public Organization findOrganizationByName(String name) {
        for (Organization o : organizations) {
            if (o.getName().equalsIgnoreCase(name)) {
                return o;
            }
        }
        return null;
    }

    //типы персонала
    public void addPersonnelType(PersonnelType type) {
        if (!personnelTypes.contains(type)) {
            personnelTypes.add(type);
        }
    }

    public PersonnelType findPersonnelTypeByRole(String role) {
        for (PersonnelType pt : personnelTypes) {
            if (pt.getRole().equalsIgnoreCase(role)) {
                return pt;
            }
        }
        return null;
    }
}
