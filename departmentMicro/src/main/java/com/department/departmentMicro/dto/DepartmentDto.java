package com.department.departmentMicro.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentDto {


    private Long departmentId;

    private String departmentName;

    private String departmentContactNo;

    private String departmentEmail;
}
