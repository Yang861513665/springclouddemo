package cn.yxj.eurekaconsumer.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
/**
 *  定义一个全局异常处理器
 *
 * */
@RestControllerAdvice
public class ExceptionHandlerConfig {
    @ExceptionHandler(ArithmeticException.class)
    public Map<String,Object> arthmeticExceptionHandler(Exception e){
        HashMap<String, Object> map = new HashMap<>();
        map.put("message","---程序出现了算数异常--");
        map.put("exception",e.getMessage());
        return map;
    }
}
