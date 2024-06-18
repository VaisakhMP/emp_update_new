package com.vmp.emp_mgmt_system.service;

import com.vmp.emp_mgmt_system.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(int employeeID);

    List<EmployeeDto> getAllEmployee();

    EmployeeDto updateEmployee(int employeeid,EmployeeDto updatedEmployee );

    void deleteEmployee(int employeeid);
}
