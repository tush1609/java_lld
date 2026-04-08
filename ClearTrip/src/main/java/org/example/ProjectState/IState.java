package org.example.ProjectState;

import org.example.enums.States;

public interface IState {
    IState created(ProjectState projState);
    IState requested(ProjectState projState);
    IState assigned(ProjectState projState);
    IState cancelled(ProjectState projState);
    IState inProgress(ProjectState projState);
    IState delivered(ProjectState projState);
    States getState();
}
