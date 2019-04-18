package com.yxj.eurekaoauth2.config;

import com.yxj.eurekaoauth2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


public class DomainUserDetailService implements UserDetailsService {
    @Autowired
    UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("根据用户名："+ username +"查找用户");
        cn.yxj.eurekaapi.entity.User realUser = userMapper.loadUserByUsername(username);
        System.out.println("用户为-->"+realUser);
        if (null == realUser) {
           throw  new UsernameNotFoundException("用户不存在");}
        Set<GrantedAuthority> userAuthotities = new HashSet<>();
        Arrays.asList(Optional.ofNullable(realUser.getAuthorities()).orElse("").split(":")).forEach(authotitie->userAuthotities.add(new SimpleGrantedAuthority(authotitie)));
        return new User(realUser.getUsername(),realUser.getPassword(),userAuthotities);
    }
}
