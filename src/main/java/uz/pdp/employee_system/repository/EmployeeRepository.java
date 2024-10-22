package uz.pdp.employee_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.employee_system.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}