package com.vmp.emp_mgmt_system.service.impl;

import com.vmp.emp_mgmt_system.dto.DepartmentDto;
import com.vmp.emp_mgmt_system.entity.Department;
import com.vmp.emp_mgmt_system.exp.ResourceNotFoundException;
import com.vmp.emp_mgmt_system.mapper.DepartmentMapper;
import com.vmp.emp_mgmt_system.repository.DepartmentRepository;
import com.vmp.emp_mgmt_system.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class DepartmentServiceImpl  implements DepartmentService {

   private DepartmentRepository departmentRepository;


    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = DepartmentMapper.maptoDepartment(departmentDto);
        Department saveDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(saveDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(int departmentId)
    {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                ()-> new ResourceNotFoundException("Department not found in given ID : "+departmentId)
        );

        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department) -> DepartmentMapper.mapToDepartmentDto(department))
                .collect(Collectors.toList());
    }

    @Override
    public DepartmentDto updateDepartment(int departmentId, DepartmentDto updateDepartment) {


          Department department  =  departmentRepository.findById(departmentId).orElseThrow(
            ()-> new ResourceNotFoundException("Department Not Found In The Given ID : "+departmentId)
            );
          department.setDepartmentName(updateDepartment.getDeparmentName());
          department.setDepartmentDiscription(updateDepartment.getDepartmentDiscription());
          Department savedDepartment = departmentRepository.save(department);


        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }
}
