package org.example.manager;

import org.example.model.Developer;

import java.util.concurrent.ConcurrentHashMap;

public class DeveloperManager {
    ConcurrentHashMap<String, Developer> registeredDevelopers;

    public DeveloperManager() {
        this.registeredDevelopers = new ConcurrentHashMap<>();
    }

    public void addDeveloper(String id, String name, String mobNo) {
        Developer developer = new Developer(id, name, mobNo);
        System.out.println("DEVELOPER CREATED " + id);
        this.registeredDevelopers.put(id, developer);
    }

    public Developer getDeveloper(String id) {
        return this.registeredDevelopers.get(id);
    }

    public void getDeveloperDetails(String developerId) {
        Developer developer = this.getDeveloper(developerId);
        if (developer != null) {
            System.out.println(developer);
        }
    }

    public ConcurrentHashMap<String, Developer> getRegisteredDevelopers() {
        return registeredDevelopers;
    }

    public void setRegisteredDevelopers(ConcurrentHashMap<String, Developer> registeredDevelopers) {
        this.registeredDevelopers = registeredDevelopers;
    }
}
