package com.user.userMicro.exception;

import com.department.departmentMicro.dto.ResponseErrorDto;
import com.department.departmentMicro.exception.ResourceAlreadyExistException;
import com.department.departmentMicro.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handlehandleMethodArgumentNotValid(MethodArgumentNotValidException ex )
    {

        Map<String,String> map1 = new HashMap<String,String>();

        ex.getBindingResult().getAllErrors().forEach(
                (e) -> {
                    String msg = e.getDefaultMessage();
                    String error = ((FieldError)e).getField();
                    map1.put(error,msg);
                });

        return ResponseEntity .status(HttpStatus.BAD_REQUEST) .body(map1);
    }
    
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
