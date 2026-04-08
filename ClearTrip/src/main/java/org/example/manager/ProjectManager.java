package org.example.manager;

import org.example.enums.ProjectTypes;
import org.example.enums.States;
import org.example.model.Developer;
import org.example.model.Leader;
import org.example.model.Project.Project;
import org.example.model.Project.ProjectFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ProjectManager {
    ConcurrentHashMap<String, Object> lock;
    ConcurrentHashMap<String, Project> projects;
    ProjectFactory factory;

    public ProjectManager() {
        this.projects = new ConcurrentHashMap<>();
        this.lock = new ConcurrentHashMap<>();
        this.factory = new ProjectFactory();

        Thread th = new Thread(this::cleanup);
        th.start();
    }

    void cleanup() {
        List<Project> expiryProject = new ArrayList<>();
        this.projects.values().forEach(p -> {
            long creationTime = p.getCreationTime().getTime();
            long currTime = new Date().getTime();
            if (currTime - creationTime > 100000) {
                expiryProject.add(p);
            }
        });

        expiryProject.forEach(p -> {
            Object idLock = this.lock.computeIfAbsent((p.getId()), k -> new Object());
            synchronized (idLock) {
                if (States.REQUESTED.equals(p.getCurrentStateOfProject()) || States.ASSIGNED.equals(p.getCurrentStateOfProject())) {
                    p.cancelProject();
                }
            }
        });
    }

    public void addProject(String id, String detail, ProjectTypes type, Leader leader) {
        Project proj = this.factory.createProject(id, detail, type, leader);
        if (proj == null) {
            System.out.println("INVALID_PROJ_TYPE");
            return;
        }

        System.out.println("PROJECT_CREATED " + id);
        this.projects.put(id, proj);
    }

    public void assignProject(String projId, Leader leader) {
        Project proj = this.projects.get(projId);
        if (proj == null) {
            System.out.println("ERR: INVALID_PROJ");
            return;
        }

        if (!leader.getId().equals(proj.getCreator().getId())) {
            System.out.println("ERR: this Leader can't approve project");
            return;
        }

        Object idLock = this.lock.computeIfAbsent((proj.getId()), k -> new Object());
        synchronized (idLock) {
            proj.assignProject();
        }
    }

    public void requestProj(String projId, Developer developer) {
        Project proj = this.projects.get(projId);
        if (proj == null) {
            System.out.println("ERR: INVALID_PROJ");
            return;
        }

        Object idLock = this.lock.computeIfAbsent((proj.getId()), k -> new Object());
        synchronized (idLock) {
            proj.requestProject(developer);
        }
    }

    public void startProject(String projId) {
        Project proj = this.projects.get(projId);
        if (proj == null) {
            System.out.println("ERR: INVALID_PROJ");
            return;
        }

        Object idLock = this.lock.computeIfAbsent((proj.getId()), k -> new Object());
        synchronized (idLock) {
            proj.startProject();
        }
    }

    public void cancelProj(String projId) {
        Project proj = this.projects.get(projId);
        if (proj == null) {
            System.out.println("ERR: INVALID_PROJ");
            return;
        }

        Object idLock = this.lock.computeIfAbsent((proj.getId()), k -> new Object());
        synchronized (idLock) {
            proj.cancelProject();
        }
    }

    public void deliverProject(String projId) {
        Project proj = this.projects.get(projId);
        if (proj == null) {
            System.out.println("ERR: INVALID_PROJ");
            return;
        }

        Object idLock = this.lock.computeIfAbsent((proj.getId()), k -> new Object());
        synchronized (idLock) {
            proj.deliverProject();
        }
    }

    public void getAvailableProjects() {
        this.projects.values().forEach(p -> {
            if (p != null) {
                States currState = p.getCurrentStateOfProject();
                if (currState != null && currState.equals(States.CREATED)) {
                    System.out.println(p);
                }
            }
        });
    }

    public void printAllProjects() {
        this.projects.values().forEach(p -> {
            if (p != null) {
                System.out.println(p);
            }
        });
    }
}
