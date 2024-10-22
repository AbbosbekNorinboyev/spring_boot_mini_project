package uz.pdp.employee_system.service;

import org.springframework.lang.NonNull;
import uz.pdp.employee_system.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(@NonNull Employee employee);
    List<Employee> getAllEmployee();
    Employee getEmployeeById(@NonNull Integer id);
    void deleteEmployee(@NonNull Integer id);
}
