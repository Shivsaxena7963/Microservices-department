package com.user.userMicro.service.impl;


import com.department.departmentMicro.dto.DepartmentDto;
import com.department.departmentMicro.dto.ResponseDto;
import com.department.departmentMicro.entity.Department;
import com.department.departmentMicro.exception.ResourceAlreadyExistException;
import com.department.departmentMicro.exception.ResourceNotFoundException;
import com.department.departmentMicro.mapper.DepartmentMapper;
import com.department.departmentMicro.repo.DepartmentRepo;
import com.department.departmentMicro.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    DepartmentRepo departmentRepo;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department1 = DepartmentMapper.dtoToDepartment(departmentDto);
        Optional<Department> department = departmentRepo.findByDepartmentContactNo(departmentDto.getDepartmentContactNo());

        if (department.isPresent())
        {
            throw new ResourceAlreadyExistException("Resource already exist with mbl no "+departmentDto.getDepartmentContactNo());
        }


            Department savedDepartment = departmentRepo.save(department1);



          DepartmentDto departmentDto1 = DepartmentMapper.departmentToDto(savedDepartment);

        return departmentDto1;

    }

    @Override
    public DepartmentDto fetchDepartment(String departmentContact) {
        Department department = departmentRepo.findByDepartmentContactNo(departmentContact).orElseThrow(

                ()-> new ResourceNotFoundException("Resource not found with contact no "+departmentContact)

        );
        DepartmentDto departmentDto = DepartmentMapper.departmentToDto(department);
        return departmentDto;
    }

    @Override
    public List<DepartmentDto> fetchAllDepartment() {

        List<Department> departmentList = departmentRepo.findAll();
        List<DepartmentDto> departmentDtoList = new ArrayList<>();
        departmentList.forEach((dep) -> departmentDtoList.add(DepartmentMapper.departmentToDto(dep))
        );

        return departmentDtoList;
    }

    @Override
    public ResponseDto updateDepartment(String departmentContact) {
        return null;
    }
}
