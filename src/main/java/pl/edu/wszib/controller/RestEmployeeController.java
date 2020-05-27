package pl.edu.wszib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.dao.EmployeeDao;
import pl.edu.wszib.domain.Employee;
import pl.edu.wszib.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin
public class RestEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employees")
    public List<Employee> employees() {
        return employeeService.getEmployees();
    }

    @DeleteMapping("employees/remove/{id}")
    public void removeEmployee(@PathVariable Long id) {
        employeeService.removeEmployee(id);
    }

    @PostMapping("employees/save")
    public void saveEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
    }

    @GetMapping("employees/single/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getById(id);
    }

}
