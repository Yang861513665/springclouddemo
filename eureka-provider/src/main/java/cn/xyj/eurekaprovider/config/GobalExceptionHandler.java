package cn.xyj.eurekaprovider.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GobalExceptionHandler {
    @ExceptionHandler(AuthenticationException.class )
    public String authenticationExceptionHandler(Exception e){
        return "权限不足！";
    }
    @ExceptionHandler(RuntimeException.class )
    public String runtimeExceptionHandler(Exception e){
        return e.getMessage();
     }
}
