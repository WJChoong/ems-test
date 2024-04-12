package cwj.employeemanagement.service.impl;

import cwj.employeemanagement.exception.ResourceNotFoundException;
import cwj.employeemanagement.model.Employee;
import cwj.employeemanagement.model.EmployeeProject;
import cwj.employeemanagement.model.Project;
import cwj.employeemanagement.repository.EmployeeProjectRepository;
import cwj.employeemanagement.repository.EmployeeRepository;
import cwj.employeemanagement.repository.ProjectRepository;
import cwj.employeemanagement.service.EmployeeProjectService;
import cwj.employeemanagement.service.EmployeeService;
import cwj.employeemanagement.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeProjectServiceImpl implements EmployeeProjectService {
    private EmployeeProjectRepository employeeProjectRepository;
    private EmployeeService employeeService;
    private ProjectService projectService;

    @Override
    public EmployeeProject saveEmployeeProject(EmployeeProject employeeProject, long employeeId, long projectId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        Project project = projectService.getProjectyById(projectId);
        employeeProject.setEmployee(employee);
        employeeProject.setProject(project);
        return employeeProjectRepository.save(employeeProject);
    }

    @Override
    public List<EmployeeProject> getAllEmployeeProject() {
        return employeeProjectRepository.findAll();
    }

    @Override
    public EmployeeProject getEmployeeProjectById(long id){
        return employeeProjectRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee Project", "Id", id));
    }

    @Override
    public void deleteEmployeeProject(Long id) {
        employeeProjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "Id", id));
        employeeProjectRepository.deleteById(id);
    }
}
