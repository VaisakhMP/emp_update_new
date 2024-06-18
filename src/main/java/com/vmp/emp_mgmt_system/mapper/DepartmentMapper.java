package com.vmp.emp_mgmt_system.mapper;

import com.vmp.emp_mgmt_system.dto.DepartmentDto;
import com.vmp.emp_mgmt_system.entity.Department;

public class DepartmentMapper {
//convert department jpa into department DTO
    public static DepartmentDto mapToDepartmentDto(Department department){
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDiscription()
        );
    }

public static Department maptoDepartment(DepartmentDto departmentDto){

        return new Department(
                departmentDto.getId(),
                departmentDto.getDeparmentName(),
                departmentDto.getDepartmentDiscription()
        );
}

}
