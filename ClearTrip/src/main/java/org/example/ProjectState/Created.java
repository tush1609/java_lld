package org.example.ProjectState;

import org.example.enums.States;

public class Created implements IState {
    @Override
    public IState created(ProjectState projState) {
        return projState.getCreated();
    }

    @Override
    public IState requested(ProjectState projState) {
        return projState.getRequested();
    }

    @Override
    public IState assigned(ProjectState projState) {
        return null;
    }

    @Override
    public IState cancelled(ProjectState projState) {
        return null;
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
        return States.CREATED;
    }
}
