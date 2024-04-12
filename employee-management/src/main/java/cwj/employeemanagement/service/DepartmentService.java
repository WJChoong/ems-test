package cwj.employeemanagement.service;

import cwj.employeemanagement.model.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> getAllDepartment();
    Department getDepartmentyById(long id);
    Department updateDepartment(Department department, long id);
    void deleteDepartment(Long id);
}
