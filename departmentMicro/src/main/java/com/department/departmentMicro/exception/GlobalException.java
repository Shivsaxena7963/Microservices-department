package com.department.departmentMicro.exception;

import com.department.departmentMicro.dto.ResponseErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalException {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseErrorDto> handleResourceNotFoundException(ResourceNotFoundException ex, WebRequest webRequest)
    {
        ResponseErrorDto responseErrorDto = new ResponseErrorDto(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                ex.getMessage()
        );
        return ResponseEntity .status(HttpStatus.NOT_FOUND) .body(responseErrorDto);

    }

    @ExceptionHandler(ResourceAlreadyExistException.class)
    public ResponseEntity<ResponseErrorDto> handleRResourceAlreadyExistException(ResourceAlreadyExistException ex, WebRequest webRequest)
    {
        ResponseErrorDto responseErrorDto = new ResponseErrorDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                ex.getMessage()
        );
        return ResponseEntity .status(HttpStatus.BAD_REQUEST) .body(responseErrorDto);

    }
    
    
}
