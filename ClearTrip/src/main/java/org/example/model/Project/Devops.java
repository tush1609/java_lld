package org.example.model.Project;

import org.example.enums.ProjectTypes;
import org.example.model.Leader;

public class Devops extends Project {
    public Devops(String id, String detail, Leader leader) {
        super(id, detail, leader);
    }

    @Override
    public String getProjectMeta() {
        return "design devops app";
    }

    @Override
    ProjectTypes getProjectType() {
        return ProjectTypes.DEVOPS;
    }
}
