package com.sr.searchroom.service.user;

import com.sr.searchroom.entity.Role;
import com.sr.searchroom.entity.User;
import com.sr.searchroom.repository.RoleRepository;
import com.sr.searchroom.repository.UserRepository;
import com.sr.searchroom.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 温小萌 on 2018/11/9
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User getUserByName(String name) {

        User user = userRepository.getByName(name);

        if (null == user) {
            return null;
        }

        List<Role> roles = roleRepository.getByUserId(user.getId());

        if (null == roles) {
            throw new DisabledException("权限非法");
        }

        List<GrantedAuthority> authorityList = new ArrayList<>();

        roles.forEach(role -> authorityList.add(new SimpleGrantedAuthority("ROLE_" + role.getName())));

        user.setAuthorityList(authorityList);

        return user;
    }
}
