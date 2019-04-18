package com.yxj.eurekaoauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;


@Configuration
@EnableResourceServer
public class AuthorizationResourceConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
                http
                .authorizeRequests()
//                .antMatchers("/select/**").hasAuthority("select")  // 这里使用注解替代
                .antMatchers("/update/**").hasAuthority("update")
                .antMatchers("/common/**","/loginFail/**","/logoutSuccess/**").permitAll()
                .anyRequest().authenticated()
                .and()
                // 开启自动登录,登录成功请求的地址
//                .formLogin().successForwardUrl("/loginSuccess").failureForwardUrl("/loginFail").and()
                // 注销登录请求的地址
                .logout().logoutSuccessUrl("/logoutSuccess")
                .and()
                .csrf().disable()
                .httpBasic();
    }
}
