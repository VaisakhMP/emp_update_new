package com.vmp.emp_mgmt_system.repository;

import com.vmp.emp_mgmt_system.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository  extends JpaRepository<Department, Integer> {

}
