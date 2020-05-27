package pl.edu.wszib.controller;

import javassist.NotFoundException;
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

    /*    @GetMapping("employees")
        public String showEmployee (, Model model) {
            Employee employee = employeeDao.getById(id);
            model.addAttribute("employee", employee);
            return "details";
        }*/

    //details view
    @GetMapping("details")
    public String details() {return "details";    }

    @GetMapping("details/{id}")
    public String employees(@PathVariable Long id, Model model) {
        model.addAttribute("employees", employeeDao.getEmployees());
        return "details";
    }


    //vacations view
    @GetMapping("vacations")
    public String vacations() {
        return "vacations";
    }


    /*public void validate(Pacjent pacjent, BindingResult bindingResult) {
        if(pacjent.getImie()==null|| pacjent.getImie().isEmpty()) {
            bindingResult.addError(new ObjectError("imie", "Musisz podać imię"));
        }
        if(pacjent.getNazwisko()==null|| pacjent.getNazwisko().isEmpty()) {
            bindingResult.addError(new ObjectError("nazwisko", "Musisz podać nazwisko"));
        }
        if(pacjent.getWiek()<0) {
            bindingResult.addError(new ObjectError("wiek", "Wiek nie może być ujemny"));
        }
            *//*if(pacjent.getTermin()==null|| pacjent.getTermin().()) {
                bindingResult.addError(new ObjectError("termin", "Musisz wskazać termin"));
            }*//*


    }


    }*/



}