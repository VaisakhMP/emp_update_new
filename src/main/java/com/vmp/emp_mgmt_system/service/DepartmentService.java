package com.vmp.emp_mgmt_system.service;

import com.vmp.emp_mgmt_system.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(int departmentId);

    List<DepartmentDto> getAllDepartments();

    DepartmentDto updateDepartment(int departmentId, DepartmentDto updateDepartment);
}
