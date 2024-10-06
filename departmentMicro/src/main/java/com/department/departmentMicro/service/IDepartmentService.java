package com.department.departmentMicro.service;

import com.department.departmentMicro.dto.DepartmentDto;
import com.department.departmentMicro.dto.ResponseDto;

import java.util.List;

public interface IDepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto fetchDepartment(String departmentContact);

    List<DepartmentDto> fetchAllDepartment();

    ResponseDto updateDepartment(String departmentContact);


}
