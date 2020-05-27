package pl.edu.wszib.service;


import pl.edu.wszib.domain.Employee;
import pl.edu.wszib.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> listEmployeeDTO();
    EmployeeDTO getEmployeeDTO(Long id);
    void removeEmployeeDTO(Long id);
    void saveEmployeeDTO(Employee employee);
    EmployeeDTO createEmployee(EmployeeDTO employee);
    EmployeeDTO updateEmployee(EmployeeDTO employee);

    List<Employee> getEmployees();
    void saveEmployee(Employee employee);
    void removeEmployee(Long id);
    Employee getById(Long id);
}
