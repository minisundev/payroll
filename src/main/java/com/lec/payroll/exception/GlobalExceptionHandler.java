package com.lec.payroll.exception;

import com.lec.payroll.dto.response.ApiResponse;
import com.lec.payroll.dto.response.ErrorResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Log4j2
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @ExceptionHandler(Exception.class)
    public ErrorResponse exception(GlobalException globalException) {
        ErrorCode errorCode = globalException.getErrorCode();
        log.error("Exception occurred at : {}", LocalDateTime.now().format(formatter));
        log.error("Exception occurred in class: {}", globalException.getClass().getName());
        log.error("Exception occurred in method: {}", globalException.getStackTrace()[0].getMethodName());
        return new ErrorResponse(errorCode);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<List<String>> handleMethodArgumentNotValidException(
            BindingResult bindingResult) {
        List<String> errors = bindingResult.getFieldErrors().stream()
                .map((FieldError fieldError) -> fieldError.getField() + " "
                        + fieldError.getDefaultMessage())
                .toList();
        return new ApiResponse<>(HttpStatus.BAD_REQUEST.value(), "wrong inputs", errors);
    }
}
