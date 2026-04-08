package org.example.model.Project;

import org.example.enums.ProjectTypes;
import org.example.model.Leader;

public class Backend extends Project {
    public Backend(String id, String detail, Leader leader) {
        super(id, detail, leader);
    }

    @Override
    public String getProjectMeta() {
        return "design be app";
    }

    @Override
    ProjectTypes getProjectType() {
        return ProjectTypes.BACKEND;
    }
}
