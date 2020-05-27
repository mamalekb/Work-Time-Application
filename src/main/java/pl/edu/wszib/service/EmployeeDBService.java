package pl.edu.wszib.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.edu.wszib.controller.TestController;
import pl.edu.wszib.dao.EmployeeDao;
import pl.edu.wszib.domain.Employee;
import pl.edu.wszib.dto.EmployeeDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Primary
@Service
public class EmployeeDBService implements EmployeeService{

    private Map<Long, Employee> employeeMap;
    private static Long id = 1L;

    public void EmployeeDaoImpl() {
        this.employeeMap = new HashMap<>();
        prepareEmployeeList();
    }

    EmployeeDao dao;
    EmployeeMapper mapper;

    public EmployeeDBService(EmployeeDao dao,
                             EmployeeMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public List<EmployeeDTO> listEmployeeDTO() {
        return mapper.toDTO(dao.findAll());
    }


    private void prepareEmployeeList() {
        Employee employee = new Employee();
        employee.setName("Jan");
        employee.setSurname("Kowalski");
        /*employee.setDateOfBirth("1988-05-22");*/


        employee.setSex("Mężczyzna");
        employee.setLogin("jkowalski");
        employee.setEmail("jkowalski@gmail.com");
        employee.setDepartment("Oddział Logistyki");
        employee.setPosition("stażysta");
        employee.setAdress("Kraków, ul. Królewny Sniezki 15");
        employee.setTelephone("506-332-882");
/*        employee.setFirstWorkday(2019);
        employee.setLastWorkday();
        employee.setPicture();*/
        employee.setWorking(true);
        saveEmployee(employee);
    }

    @Override
    public EmployeeDTO getEmployeeDTO(Long id) {
        return dao.findById(id)
                .map(skierowanieDoLekarza -> mapper.toDTO(skierowanieDoLekarza))
                .orElseThrow(() -> new TestController.NotFoundException());
    }

    @Override
    public Employee getById(Long id) {
        return employeeMap.get(id);
    }

    @Override
    public void removeEmployeeDTO(Long id) {
    dao.deleteById(getEmployeeDTO(id).getId());
    }

    @Override
    public void removeEmployee(Long id) {
        employeeMap.remove(id);
    }

    @Override
    public void saveEmployeeDTO(Employee employee) {

    }

    @Override
    public void saveEmployee(Employee employee) {
        if (employee.getId() < 1) {
            employee.setId(id);
            id++;
        }
        employeeMap.put(employee.getId(), employee);
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employee) {
        return mapper.toDTO(
                dao.save(
                        mapper.toDB(employee)));
    }



    @Override
    public EmployeeDTO updateEmployee(EmployeeDTO employeer) {
        Employee employee = dao.findById(employeer.getId()).get();
        employee.setName(employee.getName());
        employee.setSurname(employee.getSurname());
        employee.setDateOfBirth(employee.getDateOfBirth());
        employee.setSex(employee.getSex());
        employee.setLogin(employee.getLogin());
        employee.setEmail(employee.getEmail());
        employee.setDepartment(employee.getDepartment());
        employee.setPosition(employee.getPosition());
        employee.setAdress(employee.getAdress());
        employee.setTelephone(employee.getTelephone());
        employee.setFirstWorkday(employee.getFirstWorkday());
        employee.setLastWorkday(employee.getLastWorkday());
        /*employee.setPicture(employee.getPicture());*/
        employee.setWorking(employee.isWorking());
        return mapper.toDTO(dao.save(employee));
    }

    @Override
    public List<Employee> getEmployees() {
        return null;
    }


}
