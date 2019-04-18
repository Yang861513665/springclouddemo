package cn.xyj.eurekaprovider.controller;

import cn.yxj.eurekaapi.entity.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    RestTemplate restTemplate;
    @Value("${authencation_url}")
    String authencation_url;
    @RequestMapping("getUsers")
    private List<User> getUser(){
        List<User> users = new ArrayList<>();
        users.add(new User("yangxj01","123",21));
        users.add(new User("yangxj02","123",21));
        users.add(new User("yangxj03","123",21));
        return users;
    }
    @RequestMapping("/addUser")
    public User addUser(@RequestBody User user,HttpServletRequest request){
        System.out.println("content-type-->"+request.getHeader("content-type"));
        System.out.println("----接受到参数----》["+user+"]");
        return user;
    }
    @RequestMapping("/sendMessage")
    public String message(String message,HttpServletRequest request){
        System.out.println("content-type-->"+request.getHeader("content-type"));
//        int i = 10/0;
        System.out.println("----接受到消息----》["+message+"]");
        return "成功发送消息：["+message+"]";
    }
    @RequestMapping("/common")
    public String common(HttpServletRequest req,@RequestParam(value = "user") String userStr){
        String header = req.getHeader("authorization");
        System.out.println(header);
        User user = JSONObject.parseObject(userStr, User.class);
        System.out.println("name--->"+user.getUsername()+"   password--->"+user.getPassword());
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println("headerName: "+ headerName+"  headerValue: "+req.getHeader(headerName));
        }
//        System.out.println(authorization);
        return "这是可见的，不需要认证的";
    }
    @RequestMapping("/common2")
    public String common2(HttpServletRequest req){
        HttpHeaders headers = new HttpHeaders();
        System.out.println(req.getHeader("authorization"));
        headers.set("Authorization",req.getHeader("authorization"));
        MultiValueMap<Object,Object> param = new LinkedMultiValueMap<>();//参数放入一个map中，restTemplate不能用hashMap
        User user = new User();
        user.setUsername("yangxj");
        user.setPassword("123");
        param.add("user",JSONObject.toJSONString(user));
        HttpEntity<Object> request = new HttpEntity<>(param,headers);
        return restTemplate.postForObject("http://localhost:8761/user/update",request,String.class);
    }
    @RequestMapping("/login")
    public JSONObject login(String username,String password){
        try{
            JSONObject result = restTemplate.postForObject(authencation_url+"/oauth/token?username=" + username + "&password=" + password + "&grant_type=password&scope=all&client_id=web&client_secret=web", "", JSONObject.class);
            return result;
        }catch (Exception e){
            throw  new RuntimeException("用户名或密码错误！");
        }
    }
    @PreAuthorize("hasAuthority('select')")
    @RequestMapping("/select")
    public String select(){
        return "这是需要select权限的";
    }
    @RequestMapping("/update")
    public String update(User user,HttpServletRequest req){
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String headerName = headerNames.nextElement();
            System.out.println("headerName: "+ headerName+"  headerValue: "+req.getHeader(headerName));
        }
        return "这是需要update权限的";
    }
}
