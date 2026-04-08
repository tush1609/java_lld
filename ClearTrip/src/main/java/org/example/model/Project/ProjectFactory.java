package org.example.model.Project;

import org.example.enums.ProjectTypes;
import org.example.model.Leader;

public class ProjectFactory {
    public Project createProject(String id, String detail, ProjectTypes type, Leader leader) {
        switch (type) {
            case BACKEND -> {
                return new Backend(id, detail, leader);
            }
            case FRONTEND -> {
                return new Frontend(id, detail, leader);
            }
            case DEVOPS -> {
                return new Devops(id, detail, leader);
            }
        }

        return null;
    }
}
