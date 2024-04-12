package cwj.employeemanagement.service.impl;

import cwj.employeemanagement.exception.ResourceNotFoundException;
import cwj.employeemanagement.model.Department;
import cwj.employeemanagement.model.Employee;
import cwj.employeemanagement.model.Project;
import cwj.employeemanagement.repository.EmployeeRepository;
import cwj.employeemanagement.service.DepartmentService;
import cwj.employeemanagement.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private DepartmentService departmentService;

    @Override
    public Employee saveEmployee(Employee employee, long departmentId) {
        Department department = departmentService.getDepartmentyById(departmentId);
        employee.setDepartment(department);
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id, long departmentId) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        Department department = departmentService.getDepartmentyById(departmentId);
        existingEmployee.setDepartment(department);
        existingEmployee.setName(employee.getName());
        existingEmployee.setPosition(employee.getPosition());

        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        employeeRepository.deleteById(id);
    }
}
