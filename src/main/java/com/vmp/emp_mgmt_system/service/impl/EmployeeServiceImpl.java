package com.vmp.emp_mgmt_system.service.impl;

import com.vmp.emp_mgmt_system.dto.EmployeeDto;
import com.vmp.emp_mgmt_system.entity.Employee;
import com.vmp.emp_mgmt_system.exp.ResourceNotFoundException;
import com.vmp.emp_mgmt_system.mapper.EmployeeMapper;
import com.vmp.emp_mgmt_system.repository.EmployeeRepository;
import com.vmp.emp_mgmt_system.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employeee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employeee);

        return EmployeeMapper.mapTOEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(int employeeID) {
        Employee employee = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new ResourceNotFoundException("Employee is Not Found In this ID: "+employeeID));
        return EmployeeMapper.mapTOEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employees =  employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapTOEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(int employeeid, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeid).orElseThrow(
                () ->  new ResourceNotFoundException("Employee Not Found In The Given ID : "+employeeid)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setPhone(updatedEmployee.getPhone());

        Employee updatedEmnloyeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapTOEmployeeDto(updatedEmnloyeeObj);
    }

    @Override
    public void deleteEmployee(int employeeid) {
        Employee employee = employeeRepository.findById(employeeid).orElseThrow(
                () ->  new ResourceNotFoundException("Employee Not Found In The Given ID : "+employeeid)
        );

        employeeRepository.deleteById(employeeid);
    }
}
