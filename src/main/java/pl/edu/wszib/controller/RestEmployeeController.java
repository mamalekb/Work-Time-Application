package pl.edu.wszib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.dao.EmployeeDao;
import pl.edu.wszib.domain.Employee;

import java.util.List;

@RestController
@RequestMapping("api")
@CrossOrigin
public class RestEmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("employees")
    public List<Employee> employees() {
        return employeeDao.getEmployees();
    }

    @DeleteMapping("employees/remove/{id}")
    public void removeEmployee(@PathVariable Long id) {
        employeeDao.removeEmployee(id);
    }

    @PostMapping("employees/save")
    public void saveEmployee(@RequestBody Employee employee) {
        employeeDao.saveEmployee(employee);
    }

    @GetMapping("employees/single/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeDao.getById(id);
    }

}
