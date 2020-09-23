package com.iza.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;

/**
 * projectName:  bankSystem2
 *
 * @author: xuwei
 * ime:  2020/9/10 20:18
 * description:
 */
@ControllerAdvice
@ResponseBody
public class CommonException {
    @ExceptionHandler(ConstraintViolationException.class)
    public JsonResult constraintViolationException(ConstraintViolationException ex){
        Iterator<ConstraintViolation<?>> iterator = ex.getConstraintViolations().iterator();
        String message = null;
        if (iterator.hasNext()) {
            message = iterator.next().getMessage();
            System.out.println("message = " + message);
        }
        return new JsonResult(0,message);
    }
    @ExceptionHandler
    public JsonResult commonException(Exception ex){
        return new JsonResult(0,ex.getMessage());
    }
}
