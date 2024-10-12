package com.user.userMicro.mapper;

import com.department.departmentMicro.dto.DepartmentDto;
import com.department.departmentMicro.entity.Department;

public class DepartmentMapper {

    public static Department dtoToDepartment(DepartmentDto departmentDto)
    {
        Department department = new Department();

        department.setDepartmentId(departmentDto.getDepartmentId());

        department.setDepartmentEmail(departmentDto.getDepartmentEmail());

        department.setDepartmentName(departmentDto.getDepartmentName());

        department.setDepartmentContactNo(departmentDto.getDepartmentContactNo());

        return  department;

    }

    public static DepartmentDto departmentToDto(Department department)
    {
        DepartmentDto departmentDto = new DepartmentDto();

        departmentDto.setDepartmentContactNo(department.getDepartmentContactNo());

        departmentDto.setDepartmentEmail(department.getDepartmentEmail());

        departmentDto.setDepartmentName(department.getDepartmentName());

        departmentDto.setDepartmentId(department.getDepartmentId());

        return departmentDto;

    }
}
