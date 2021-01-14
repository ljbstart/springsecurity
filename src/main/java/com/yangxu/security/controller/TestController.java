package com.yangxu.security.controller;

import com.yangxu.security.pojo.vo.rest.ResultObject;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/test")
@Validated
public class TestController {

    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * 入门测试接口
     * @param id
     * @return
     */
    @GetMapping("/testSecurity")
    public ResultObject testSecurity (@NotEmpty @RequestParam("id") String id){
//        return new ResultObject(0,Md5Crypt.apr1Crypt(id.getBytes(),id));
        return new ResultObject(0,passwordEncoder.encode(id));

    }




}
