package com.yangxu.security.impl;

import com.yangxu.security.service.MyUserDetailsService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserDetailsService的实现类 ,进行配置用户名和密码
 */
@Service("UserDetailsService")
public class MyUserDetailsServiceImpl implements MyUserDetailsService {
    /**
     *
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("role");
        return new User("ljb",new BCryptPasswordEncoder().encode("123456"),authorities);
    }
}
