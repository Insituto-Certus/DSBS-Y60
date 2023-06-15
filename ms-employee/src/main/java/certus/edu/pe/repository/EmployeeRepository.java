package certus.edu.pe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import certus.edu.pe.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
