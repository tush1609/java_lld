package org.example;

import org.example.enums.ProjectTypes;
import org.example.manager.DeveloperManager;
import org.example.manager.LeaderManager;
import org.example.manager.ProjectManager;
import org.example.model.Developer;
import org.example.model.Leader;

public class ProjOrchestrator {
    DeveloperManager developerManager;
    LeaderManager leaderManager;
    ProjectManager projManager;

    public ProjOrchestrator() {
        this.developerManager = new DeveloperManager();
        this.leaderManager = new LeaderManager();
        this.projManager = new ProjectManager();
    }

    public void createLeader(String id, String name, String mobNo) {
        this.leaderManager.addLeader(id, name, mobNo);
    }

    public void createDeveloper(String id, String name, String mobNo) {
        this.developerManager.addDeveloper(id, name, mobNo);
    }

    public void createProject(String id, String detail, ProjectTypes type, String leaderId) {
        Leader leader = this.leaderManager.getLeader(leaderId);
        if (leader == null) {
            System.out.println("ERR: LEADER NOT FOUND");
            return;
        }

        this.projManager.addProject(id, detail, type, leader);
    }

    public void requestDeveloper(String projId, String developerId) {
        Developer developer = this.developerManager.getDeveloper(developerId);
        if (developer != null) {
            this.projManager.requestProj(projId, developer);
        }
    }

    public void approveProject(String projId, String leaderId) {
        Leader leader = this.leaderManager.getLeader(leaderId);
        if (leader == null) {
            System.out.println("ERR: LEADER NOT FOUND");
            return;
        }

        this.projManager.assignProject(projId, leader);
    }

    public void cancelProject(String projId) {
        this.projManager.cancelProj(projId);
    }

    public void startProject(String projId) {
        this.projManager.startProject(projId);
    }

    public void deliverProject(String projId) {
        this.projManager.deliverProject(projId);
    }

    public void getDeveloperDetails(String developerId) {
        this.developerManager.getDeveloperDetails(developerId);
    }

    public void getAvailableProjects() {
        this.projManager.getAvailableProjects();
    }

    public void printAllProjects() {
        this.projManager.printAllProjects();
    }
}
