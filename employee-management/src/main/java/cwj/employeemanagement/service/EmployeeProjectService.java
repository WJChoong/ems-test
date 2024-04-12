package cwj.employeemanagement.service;

import cwj.employeemanagement.model.EmployeeProject;
import cwj.employeemanagement.model.Project;

import java.util.List;

public interface EmployeeProjectService {
    EmployeeProject saveEmployeeProject(EmployeeProject employeeProject, long employeeId, long projectId);
    List<EmployeeProject> getAllEmployeeProject();
    EmployeeProject getEmployeeProjectById(long id);
    void deleteEmployeeProject(Long id);
}
