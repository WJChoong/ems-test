package cwj.employeemanagement.service;

import cwj.employeemanagement.model.Project;

import java.util.List;

public interface ProjectService {
    Project saveProject(Project project);
    List<Project> getAllProjects();
    Project getProjectyById(long id);
    Project updateProject(Project project, long id);
    void deleteProject(Long id);

}
