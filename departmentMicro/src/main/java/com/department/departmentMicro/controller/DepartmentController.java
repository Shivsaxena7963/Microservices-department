package com.department.departmentMicro.controller;

import com.department.departmentMicro.constant.Constant;
import com.department.departmentMicro.dto.DepartmentDto;
import com.department.departmentMicro.dto.ResponseDto;
import com.department.departmentMicro.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class DepartmentController {

    @Autowired
    IDepartmentService departmentService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createDepartment(@RequestBody DepartmentDto departmentDto)
    {
        departmentService.createDepartment(departmentDto);

        return ResponseEntity .status(HttpStatus.CREATED) .body(new ResponseDto(Constant.MESSAGE_201,Constant.STATUS_201));

    }


    @GetMapping("/fetchDepartment")
    public ResponseEntity<DepartmentDto> fetchDepartment(@RequestParam String mblNo)
    {
        DepartmentDto departmentDto = departmentService.fetchDepartment(mblNo);

        return ResponseEntity .status(HttpStatus.FOUND) .body(departmentDto);

    }

    @GetMapping("/fetchAllDepartments")
    public ResponseEntity<List<DepartmentDto>> fetchAllDepartments()
    {
        List<DepartmentDto> listDepartmentDto = departmentService.fetchAllDepartment();

        return ResponseEntity .status(HttpStatus.FOUND) .body(listDepartmentDto);

    }



}
