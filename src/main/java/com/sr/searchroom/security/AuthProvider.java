package com.sr.searchroom.security;

import com.sr.searchroom.entity.User;
import com.sr.searchroom.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by 温小萌 on 2018/11/9
 */
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private IUserService userService;

    private final Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String inputUsername = authentication.getName();
        String inputPassword = (String) authentication.getCredentials();

        User user = userService.getUserByName(inputUsername);
        if (null == user) {
            throw new AuthenticationCredentialsNotFoundException("authenERROR");
        }

        if (this.md5PasswordEncoder.isPasswordValid(user.getPassword(), inputPassword, user.getId())) {
            System.out.println("-----------------" + user);
            return  new UsernamePasswordAuthenticationToken(user,null,  user.getAuthorityList());
        }

        throw new AuthenticationCredentialsNotFoundException("authenERROR");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
