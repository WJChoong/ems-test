package cwj.employeemanagement.controller;

import cwj.employeemanagement.model.EmployeeProject;
import cwj.employeemanagement.service.EmployeeProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/employeeProjects")
public class EmployeeProjectControlller {
    private EmployeeProjectService employeeProjectService;

    @PostMapping("{employeeId}/{projectId}")
    public ResponseEntity<EmployeeProject> saveEmployeeProject(@PathVariable("employeeId") long employeeId,
                                                               @PathVariable("projectId") long projectId,
                                                               @RequestBody EmployeeProject employeeProject){
        return new ResponseEntity<EmployeeProject>( employeeProjectService.saveEmployeeProject(employeeProject, employeeId, projectId), HttpStatus.CREATED);
    }

    // get all projects
    @GetMapping
    public List<EmployeeProject> getAllEmployeeProject(){
        return employeeProjectService.getAllEmployeeProject();
    }

    // get project by id Rest API
    @GetMapping("{id}")
    public ResponseEntity<EmployeeProject> getEmployeeProjectById(@PathVariable("id") long employeeProjectId) {
        return new ResponseEntity<EmployeeProject>(employeeProjectService.getEmployeeProjectById(employeeProjectId), HttpStatus.OK);
    }

    // Build delete project
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployeeProject(@PathVariable("id") long employeeProjectId){
        employeeProjectService.deleteEmployeeProject(employeeProjectId);
        return new ResponseEntity<String>( "Employee Project deleted successfully", HttpStatus.OK);
    }
}
