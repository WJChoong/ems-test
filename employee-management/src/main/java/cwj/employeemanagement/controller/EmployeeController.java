package cwj.employeemanagement.controller;

import cwj.employeemanagement.model.Department;
import cwj.employeemanagement.model.Employee;
import cwj.employeemanagement.service.DepartmentService;
import cwj.employeemanagement.service.EmployeeService;
import cwj.employeemanagement.service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    @PostMapping("{id}")
    public ResponseEntity<Employee> saveProject(@PathVariable("id") long departmentId, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee, departmentId), HttpStatus.CREATED);
    }

    // get all projects
    @GetMapping
    public List<Employee> getAllProjects(){
        return employeeService.getAllEmployee();
    }

    // get project by id Rest API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getProjectById(@PathVariable("id") long employeeId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    // update project by id
    @PutMapping("{employeeId}/{departmentId}")
    public ResponseEntity<Employee> updateProject(@PathVariable("employeeId") long employeeId, @PathVariable("departmentId") long departmentId, @RequestBody Employee employee){
        return new ResponseEntity<Employee>( employeeService.updateEmployee(employee, employeeId, departmentId), HttpStatus.OK);
    }

    // Build delete project
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProject(@PathVariable("id") long employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity<String>( "Employee deleted successfully", HttpStatus.OK);
    }
}
