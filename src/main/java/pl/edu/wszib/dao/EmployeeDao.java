package pl.edu.wszib.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.edu.wszib.domain.Employee;


import java.util.List;


@Repository
public interface EmployeeDao extends CrudRepository<Employee, Long> {



    @Override
    List<Employee> findAll();

    @Override
    List<Employee> findAllById(Iterable<Long> longs);


/*To przenoszę do EmployeeService*/
/*    List<Employee> getEmployees();
   void saveEmployee(Employee employee);
    void removeEmployee(Long id);
    Employee getById(Long id);*/
}
