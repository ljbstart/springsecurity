package com.yangxu.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


/**
 *  * 第三种配置用户名和密码的方式：继承WebSecurityConfigurerAdapter进行，并注入UserDetail的实现类，实现SpringSecurity用户名和密码配置
 */
@Configuration
@Slf4j
public class SecurityConfigByUserDetail extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;




    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(getBCEncoder());

    }

    @Bean(value = "BCryptEncoder", name = "BCryptEncoder")
    PasswordEncoder getBCEncoder() {
        log.info("初始化bcrypt加密器");
        return new BCryptPasswordEncoder();
    }


}
