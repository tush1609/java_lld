package org.example.ProjectState;

import org.example.enums.States;

public class Progress implements IState {
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
        return projState.getDelivered();
    }

    @Override
    public States getState() {
        return States.IN_PROGRESS;
    }
}
