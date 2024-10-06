package com.department.departmentMicro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ResponseErrorDto {

    private String apiPath;

    private HttpStatus errorCode;

    private String errorMsg;
}
