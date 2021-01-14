package com.yangxu.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * 第二种配置用户名和密码的方式：继承WebSecurityConfigurerAdapter进行SpringSecurity进行配置
 */
//@Configuration
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 该方法实现了在配置类中配置security的用户以及密码
     *
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 密码加密器
        BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
        String encode = bcryptEncoder.encode("123456");
        log.info("加密后的密码{}", encode);
        // 进行设置security的用户，密码，以及角色
        auth.inMemoryAuthentication().withUser("ljb")
                .password(encode).roles("admin");

    }

    @Bean(value = "BCryptEncoder", name = "BCryptEncoder")
    PasswordEncoder getBCEncoder() {
        log.info("初始化bcrypt加密器");
        return new BCryptPasswordEncoder();
    }


//    @Bean(value = "SCryptEncoder", name = "SCryptEncoder")
//    PasswordEncoder getSCEncoder() {
//        log.info("初始化scrypt加密器");
//        return new SCryptPasswordEncoder();
//    }


}
