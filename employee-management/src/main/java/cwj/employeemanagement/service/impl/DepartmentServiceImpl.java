package cwj.employeemanagement.service.impl;

import cwj.employeemanagement.exception.ResourceNotFoundException;
import cwj.employeemanagement.model.Department;
import cwj.employeemanagement.model.Project;
import cwj.employeemanagement.repository.DepartmentRepository;
import cwj.employeemanagement.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentyById(long id) {
        return departmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Department", "Id", id));
    }

    @Override
    public Department updateDepartment(Department department, long id) {
        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "Id", id));
        existingDepartment.setName(department.getName());

        return departmentRepository.save(existingDepartment);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "Id", id));
        departmentRepository.deleteById(id);
    }
}
