package com.vmp.emp_mgmt_system.controller;


import com.vmp.emp_mgmt_system.dto.DepartmentDto;
import com.vmp.emp_mgmt_system.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    private DepartmentService departmentService;


    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto department =departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("id") int departmentId){
        DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDto);
    }


    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        List<DepartmentDto> departments = departmentService.getAllDepartments();
        return  ResponseEntity.ok(departments);
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentDto>  updateDepartment(@PathVariable("id") int departmentId,
                                                           @RequestBody DepartmentDto updatedDepartment){
        DepartmentDto deparmentdto = departmentService.updateDepartment(departmentId,updatedDepartment);
        return ResponseEntity.ok(deparmentdto);
    }
}
