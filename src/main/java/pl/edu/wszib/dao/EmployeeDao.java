package pl.edu.wszib.dao;
import pl.edu.wszib.domain.Employee;
import java.util.List;

public interface EmployeeDao {
    List<Employee> getEmployees();
    void saveEmployee(Employee employee);
    void removeEmployee(Long id);
    Employee getById(Long id);
}
