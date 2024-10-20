package com.user.userMicro.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class Department {

    
    private Long departmentId;

    private String departmentName;

    private String departmentContactNo;

    private String departmentEmail;

}
