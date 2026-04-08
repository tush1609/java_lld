package org.example.model.Project;

import org.example.AllocationStrategy.AssignToFirstRequest;
import org.example.AllocationStrategy.IAllocationStrategy;
import org.example.ProjectState.ProjectState;
import org.example.enums.ProjectTypes;
import org.example.enums.States;
import org.example.model.Developer;
import org.example.model.Leader;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedDeque;

public abstract class Project {
    String id;
    String detail;
    Date time;
    ConcurrentLinkedDeque<Developer> requestedDevelopers;
    IAllocationStrategy allocationStrategy;
    Developer assignedDeveloper;
    Leader creator;
    ProjectState state;

    Project(String projId, String detail, Leader leader) {
        this.id = projId;
        this.detail = detail;
        this.creator = leader;
        this.time = new Date();
        this.requestedDevelopers = new ConcurrentLinkedDeque<>();
        this.allocationStrategy = new AssignToFirstRequest();
        this.assignedDeveloper = null;
        this.state = new ProjectState();
    }

    public void requestProject(Developer developer) {
        States state = this.state.getCurrState();
        if (state == null) {
            System.out.println("ERR: CAN'T REQUEST NOW");
            return;
        }

        if (state.equals(States.CREATED) || state.equals(States.REQUESTED)) {
            System.out.println("Project developer added");
            this.requestedDevelopers.add(developer);
            this.state.requestProject();

            return;
        }

        System.out.println("ERR: CAN'T REQ NOW");
    }

    public void assignProject() {
        States state = this.state.getCurrState();
        if (state == null) {
            System.out.println("ERR: CAN'T REQUEST NOW");
            return;
        }

        this.assignedDeveloper = this.allocationStrategy.assignDeveloper(this.requestedDevelopers);
        if (this.assignedDeveloper == null) {
            System.out.println("PROJECT ASSIGNMENT FAILED");
            return;
        }

        if (state.equals(States.REQUESTED)) {
            System.out.println("PROJ ASSIGNED TO DEVELOPER " + this.assignedDeveloper.getId());
            this.state.assignProject();

            return;
        }

        System.out.println("ERR: CAN'T ASSIGN NOW");
    }

    public void startProject() {
        States state = this.state.getCurrState();
        if (state == null) {
            System.out.println("ERR: CAN'T REQUEST NOW");
            return;
        }

        if (state.equals(States.ASSIGNED)) {
            this.state.startProject();
            return;
        }

        System.out.println("CAN'T START NOW");
    }

    public void cancelProject() {
        States state = this.state.getCurrState();
        if (state == null) {
            System.out.println("ERR: CAN'T CANCEL");
            return;
        }

        if (state.equals(States.CREATED) || state.equals(States.REQUESTED)) {
            this.state.cancelProject();
            return;
        }

        System.out.println("ERR: CAN'T CANCEL NOW");
    }

    public void deliverProject() {
        States state = this.state.getCurrState();
        if (state == null) {
            System.out.println("ERR: CAN'T CANCEL");
            return;
        }

        if (state.equals(States.IN_PROGRESS)) {
            this.state.deliverProject();
            return;
        }

        System.out.println("ERR: CAN'T DELIVER PROJ NOW");
    }

    public States getCurrentStateOfProject() {
        States state = this.state.getCurrState();
        if (state == null) {
            System.out.println("ERR: CAN'T CANCEL");
        }

        return state;
    }

    public Leader getCreator() {
        return creator;
    }

    public String getId() {
        return id;
    }

    public Date getCreationTime() {
        return this.time;
    }

    abstract String getProjectMeta();
    abstract ProjectTypes getProjectType();

    @Override
    public String toString() {
        States state = this.getCurrentStateOfProject();
        return "Project{" +
                "id='" + id + '\'' +
                ", detail='" + detail + '\'' +
                ", state=" + (state == null ? null : state.toString()) +
                '}';
    }
}
