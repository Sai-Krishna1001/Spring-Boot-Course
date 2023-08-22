package com.krishna.ems.mapper;

import com.krishna.ems.dto.EmployeeDto;
import com.krishna.ems.entity.Employee;

public class EmployeeMapper {

    // maps entity to dto
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    // maps dto to entity
    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
