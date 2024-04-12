package cwj.employeemanagement.controller;

import cwj.employeemanagement.model.Department;
import cwj.employeemanagement.model.Project;
import cwj.employeemanagement.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/departments")
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        return new ResponseEntity<Department>(departmentService.saveDepartment(department), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Department> getAllDepartment(){
        return departmentService.getAllDepartment();
    }

    @GetMapping("{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") long departmentId){
        return new ResponseEntity<Department>(departmentService.getDepartmentyById(departmentId), HttpStatus.OK);
    }

    // update project by id
    @PutMapping("{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable("id") long departmentId, @RequestBody Department department){
        return new ResponseEntity<Department>( departmentService.updateDepartment(department, departmentId), HttpStatus.OK);
    }

    // Build delete project
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") long departmentId){
        departmentService.deleteDepartment(departmentId);
        return new ResponseEntity<String>( "Department deleted successfully", HttpStatus.OK);
    }

}
