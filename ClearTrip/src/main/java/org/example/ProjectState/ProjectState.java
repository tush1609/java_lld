package org.example.ProjectState;

import org.example.enums.States;

public class ProjectState {
    final IState created;
    final IState requested;
    final IState assigned;
    final IState progress;
    final IState cancelled;
    final IState delivered;
    IState currState;

    // notification manager can also be created from here
    // send notification to all the observers from here
    public ProjectState() {
        this.created = new Created();
        this.requested = new Requested();
        this.assigned = new Assigned();
        this.progress = new Progress();
        this.cancelled = new Cancelled();
        this.delivered = new Delivered();
        this.currState = this.created;
    }

    public void assignProject() {
        this.currState = this.currState.assigned(this);
    }

    public void requestProject() {
        this.currState = this.currState.requested(this);
    }

    public void startProject() {
        this.currState = this.currState.inProgress(this);
    }

    public void cancelProject() {
        this.currState = this.currState.cancelled(this);
    }

    public void deliverProject() {
        this.currState = this.currState.delivered(this);
    }



    public IState getProgress() {
        return progress;
    }

    public States getCurrState() {
        if (this.currState != null) {
            return this.currState.getState();
        }

        return null;
    }

    public IState getCreated() {
        return created;
    }

    public IState getRequested() {
        return requested;
    }


    public IState getAssigned() {
        return assigned;
    }

    public IState getCancelled() {
        return cancelled;
    }

    public IState getDelivered() {
        return delivered;
    }
}
