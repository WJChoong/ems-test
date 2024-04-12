package cwj.employeemanagement.repository;

import cwj.employeemanagement.model.EmployeeProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Long> {
}
