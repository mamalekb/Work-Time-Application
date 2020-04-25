package pl.edu.wszib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.edu.wszib.dao.EmployeeDao;
import pl.edu.wszib.domain.Employee;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping
    public String login() {
        return "welcome";
    }

    @GetMapping("employees")
    public String employees(Model model) {
        model.addAttribute("employees", employeeDao.getEmployees());
        return "employees";
    }

    @GetMapping("employees/remove/{id}")
    public String removeEmployee(@PathVariable Long id) {
        employeeDao.removeEmployee(id);
        return "redirect:/employees";
    }

    @GetMapping("employees/new")
    public String newEmployee(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee";
    }

    @PostMapping("employees/save")
    public String saveEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("employees/edit/{id}")
    public String editEmployee(@PathVariable Long id, Model model) {
        Employee employee = employeeDao.getById(id);
        model.addAttribute("employee", employee);
        return "employee";
    }

}
