package pl.edu.wszib.service;

import pl.edu.wszib.domain.Employee;
import pl.edu.wszib.dto.EmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeDTO toDTO(Employee employee);
    Employee toDB(EmployeeDTO employeeDTO);
    List<EmployeeDTO> toDTO(List<Employee> employeeList);
}


