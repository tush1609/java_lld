package org.example.ProjectState;


import org.example.enums.States;

public class Requested implements IState  {
    @Override
    public IState created(ProjectState projState) {
        return null;
    }

    @Override
    public IState requested(ProjectState projState) {
        return null;
    }

    @Override
    public IState assigned(ProjectState projState) {
        return projState.getAssigned();
    }

    @Override
    public IState cancelled(ProjectState projState) {
        return projState.getCancelled();
    }

    @Override
    public IState inProgress(ProjectState projState) {
        return null;
    }

    @Override
    public IState delivered(ProjectState projState) {
        return null;
    }

    @Override
    public States getState() {
        return States.REQUESTED;
    }
}
