package com.yangxu.security.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;


/**
 * 写着玩的
 */
@Slf4j
@Configuration
public class BeanConfig {

//    @Bean(value = "BCryptEncoder", name = "BCryptEncoder")
//    PasswordEncoder getBCEncoder() {
//        log.info("初始化bcrypt加密器");
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean(value = "SCryptEncoder", name = "SCryptEncoder")
//    PasswordEncoder getSCEncoder() {
//        log.info("初始化scrypt加密器");
//        return new SCryptPasswordEncoder();
//    }
}
