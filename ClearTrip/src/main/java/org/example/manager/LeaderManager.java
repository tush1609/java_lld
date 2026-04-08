package org.example.manager;

import org.example.model.Developer;
import org.example.model.Leader;

import java.util.concurrent.ConcurrentHashMap;

public class LeaderManager {
    ConcurrentHashMap<String, Leader> registeredLeaders;

    public LeaderManager() {
        this.registeredLeaders = new ConcurrentHashMap<>();
    }

    public void addLeader(String id, String name, String mobNo) {
        Leader leader = new Leader(id, name, mobNo);

        System.out.println("LEADER CREATED " + id);
        this.registeredLeaders.put(id, leader);
    }

    public Leader getLeader(String id) {
        return this.registeredLeaders.get(id);
    }

    public ConcurrentHashMap<String, Leader> getRegisteredLeaders() {
        return registeredLeaders;
    }

    public void setRegisteredLeaders(ConcurrentHashMap<String, Leader> registeredLeaders) {
        this.registeredLeaders = registeredLeaders;
    }
}
