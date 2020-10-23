package com.shilin.gulimall.product.exception;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.shilin.common.exception.CodeEnum;
import com.shilin.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shilin
 * @email g1335026358@gmail.com
 * @date 2020-10-15 16:45:55
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.shilin.gulimall.product.controller")
public class GulimallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        log.error("数据校验出现问题{}，异常类型：{}",e.getMessage(),e.getClass());
        BindingResult result = e.getBindingResult();
        Map<String ,String > errorMap = new HashMap<>();
        result.getFieldErrors().forEach(fieldError -> {
            errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return R.error(CodeEnum.VALID_EXCEPTION.getCode(), CodeEnum.VALID_EXCEPTION.getMsg()).put("data", errorMap);
    }
    @ExceptionHandler(value = Throwable.class)
    public R handleOtherValidException(Throwable throwable){
//        Map<String ,String > errorMap = new HashMap<>();
//        errorMap.put("message", throwable.getMessage());
        log.error(throwable.getMessage(),throwable.getClass());
        return R.error(CodeEnum.VALID_EXCEPTION.getCode(),CodeEnum.VALID_EXCEPTION.getMsg());
    }
}
