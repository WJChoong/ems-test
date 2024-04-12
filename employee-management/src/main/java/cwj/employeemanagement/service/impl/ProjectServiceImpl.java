package cwj.employeemanagement.service.impl;

import cwj.employeemanagement.exception.ResourceNotFoundException;
import cwj.employeemanagement.model.Project;
import cwj.employeemanagement.repository.ProjectRepository;
import cwj.employeemanagement.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private ProjectRepository projectRepository;

    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectyById(long id) {
//        Optional<Project> project = projectRepository.findById(id);
//        if (project.isPresent()){
//            return project.get();
//        }else{
//            throw new ResourceNotFoundException("Project", "Id", id);
//        }

        return projectRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Project", "Id", id));
    }

    @Override
    public Project updateProject(Project project, long id) {
        Project existingProject = projectRepository.findById(id)
                                    .orElseThrow(() -> new ResourceNotFoundException("Project", "Id", id));
        existingProject.setName(project.getName());

        return projectRepository.save(existingProject);
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "Id", id));
        projectRepository.deleteById(id);
    }
}
