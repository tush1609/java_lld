package org.example.model.Project;

import org.example.enums.ProjectTypes;
import org.example.model.Leader;

public class Frontend extends Project {
    public Frontend(String id, String detail, Leader leader) {
        super(id, detail, leader);
    }

    @Override
    public String getProjectMeta() {
        return "design fe app";
    }

    @Override
    ProjectTypes getProjectType() {
        return ProjectTypes.FRONTEND;
    }
}
