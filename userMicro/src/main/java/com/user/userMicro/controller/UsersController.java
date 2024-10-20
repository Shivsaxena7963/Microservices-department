package com.user.userMicro.controller;


import com.user.userMicro.constant.Constant;
import com.user.userMicro.dto.ResponseDto;
import com.user.userMicro.dto.UsersDto;
import com.user.userMicro.service.IUserstService;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class UsersController {

    @Autowired
    IUserstService iUserstService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createUsers(@RequestBody UsersDto usersDto)
    {
        iUserstService.createUser(usersDto);

        return ResponseEntity .status(HttpStatus.CREATED) .body(new ResponseDto(Constant.MESSAGE_201,Constant.STATUS_201));

    }


    @GetMapping("/fetchUser")
    public ResponseEntity<UsersDto> fetchDepartment(@NotEmpty(message = "Department contact no should not be empty") @Size(min = 10,max = 10,message = "Contact no must be of 10 digit") @RequestParam String mblNo)
    {
        UsersDto usersDto = iUserstService.fetchUser(mblNo);

        return ResponseEntity .status(HttpStatus.FOUND) .body(usersDto);

    }

    @GetMapping("/fetchAllUsers")
    public ResponseEntity<List<UsersDto>> fetchAllDepartments()
    {
        List<UsersDto> usersDtoList = iUserstService.fetchAllUsers();

        return ResponseEntity .status(HttpStatus.FOUND) .body(usersDtoList);

    }



}
