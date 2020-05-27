package pl.edu.wszib.dao.impl;

import org.springframework.stereotype.Repository;
import pl.edu.wszib.dao.EmployeeDao;
import pl.edu.wszib.domain.Employee;

import java.util.*;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private Map<Long, Employee> employeeMap;
    private static Long id = 1L;

    public EmployeeDaoImpl() {
        this.employeeMap = new HashMap<>();
        prepareEmployeeList();
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
    public void removeEmployee(Long id) {
        employeeMap.remove(id);
    }

    @Override
    public Employee getById(Long id) {
        return employeeMap.get(id);
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
    public <S extends Employee> S save(S s) {
        return null;
    }

    @Override
    public <S extends Employee> Iterable<S> saveAll(Iterable<S> iterable) { return null;}

    @Override
    public Optional<Employee> findById(Long aLong) {return Optional.empty();}

    @Override
    public boolean existsById(Long aLong) {return false;}

    @Override
    public List<Employee> findAll() {return null; }

    @Override
    public List<Employee> findAllById(Iterable<Long> longs) {return null;}

    @Override
    public long count() { return 0;}

    @Override
    public void deleteById(Long aLong) {}

    @Override
    public void delete(Employee employee) {}

    @Override
    public void deleteAll(Iterable<? extends Employee> iterable) { }

    @Override
    public void deleteAll() { }

    @Override
    public List<Employee> getEmployees() {
        return new ArrayList<>(employeeMap.values());
    }
}


