package com.example.genshinstart_backend.configuration.spring.exception;

import com.example.genshinstart_backend.base.RestResponse;
import com.example.genshinstart_backend.base.SystemCode;
import com.example.genshinstart_backend.utility.ErrorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;

/**
 * @version 1.0.0
 * @description: The type Exception handle.
 * @author feixia0g
 * @date 2024/7/10 9:30
 */
@ControllerAdvice
public class ExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * Handler rest response.
     *
     * @param e the e
     * @return the rest response
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RestResponse handler(Exception e) {
        logger.error(e.getMessage(), e);
        return new RestResponse<>(SystemCode.InnerError.getCode(), SystemCode.InnerError.getMessage());
    }

    /**
     * Handler rest response.
     *
     * @param e the e
     * @return the rest response
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public RestResponse handler(MethodArgumentNotValidException e) {
        String errorMsg = e.getBindingResult().getAllErrors().stream().map(file -> {
            FieldError fieldError = (FieldError) file;
            return ErrorUtil.parameterErrorFormat(fieldError.getField(), fieldError.getDefaultMessage());
        }).collect(Collectors.joining());
        return new RestResponse<>(SystemCode.ParameterValidError.getCode(), errorMsg);
    }

    /**
     * Handler rest response.
     *
     * @param e the e
     * @return the rest response
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public RestResponse handler(BindException e) {
        String errorMsg = e.getBindingResult().getAllErrors().stream().map(file -> {
            FieldError fieldError = (FieldError) file;
            return ErrorUtil.parameterErrorFormat(fieldError.getField(), fieldError.getDefaultMessage());
        }).collect(Collectors.joining());
        return new RestResponse<>(SystemCode.ParameterValidError.getCode(), errorMsg);
    }


}
