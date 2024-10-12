package com.user.userMicro.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsersDto {


    private Long departmentId;

    @NotEmpty(message = "Department name should not be empty")
    private String departmentName;

    @NotEmpty(message = "Department contact no should not be empty")
    @Size(min = 10,max = 10,message = "Contact no must be of 10 digit")
    private String departmentContactNo;

    @NotEmpty(message = "email id can not be empty")
    @Email(message = "pls enter valid email id")
    private String departmentEmail;
}
