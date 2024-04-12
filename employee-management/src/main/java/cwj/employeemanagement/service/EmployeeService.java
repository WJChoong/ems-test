package cwj.employeemanagement.service;

import cwj.employeemanagement.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee, long departmentId);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id, long departmentId);
    void deleteEmployee(Long id);
}
