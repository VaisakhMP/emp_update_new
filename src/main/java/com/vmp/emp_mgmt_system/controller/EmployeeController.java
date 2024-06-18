package com.vmp.emp_mgmt_system.controller;


import com.vmp.emp_mgmt_system.dto.EmployeeDto;
import com.vmp.emp_mgmt_system.entity.Employee;
import com.vmp.emp_mgmt_system.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private EmployeeService employeeService;


    //add employee
    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody  EmployeeDto employeeDto){
       EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //select employee By Id
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") int employeeId){
        EmployeeDto employeeDto= employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    //select all employeee
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
        List<EmployeeDto> employee =  employeeService.getAllEmployee();
        return ResponseEntity.ok(employee);
    }

    //update employee
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee( @PathVariable("id") int employeeId,@RequestBody EmployeeDto updateEmployee){
        EmployeeDto employeeDuto = employeeService.updateEmployee(employeeId,updateEmployee);

    return ResponseEntity.ok(employeeDuto);
    }

    //delete employee
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int employeeId){
        employeeService.deleteEmployee(employeeId);

        return ResponseEntity.ok("Employee delete Successfuly..");
    }




}
