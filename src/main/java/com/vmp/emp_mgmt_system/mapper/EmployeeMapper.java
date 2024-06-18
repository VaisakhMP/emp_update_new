package com.vmp.emp_mgmt_system.mapper;


import com.vmp.emp_mgmt_system.dto.EmployeeDto;
import com.vmp.emp_mgmt_system.entity.Employee;

public class EmployeeMapper {


    public static EmployeeDto mapTOEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPhone()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getPhone()
        );
    }



}
