package cwj.employeemanagement.controller;

import cwj.employeemanagement.model.Project;
import cwj.employeemanagement.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/projects")
public class ProjectController {
    private ProjectService projectService;

    @PostMapping
    public ResponseEntity<Project> saveProject(@RequestBody Project project){
        return new ResponseEntity<Project>( projectService.saveProject(project), HttpStatus.CREATED);
    }

    // get all projects
    @GetMapping
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    // get project by id Rest API
    @GetMapping("{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable("id") long projectId){
        return new ResponseEntity<Project>(projectService.getProjectyById(projectId), HttpStatus.OK);
    }

    // update project by id
    @PutMapping("{id}")
    public ResponseEntity<Project> updateProject(@PathVariable("id") long projectId, @RequestBody Project project){
        return new ResponseEntity<Project>( projectService.updateProject(project, projectId), HttpStatus.OK);
    }

    // Build delete project
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProject(@PathVariable("id") long projectId){
        projectService.deleteProject(projectId);
        return new ResponseEntity<String>( "Project deleted successfully", HttpStatus.OK);
    }


}
