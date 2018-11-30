package com.sr.searchroom.base;

import com.sr.searchroom.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by 温小萌 on 2018/11/27
 */
public class LoginUserUtil {

    public static User login() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (null != principal && principal instanceof User) {
            return (User) principal;
        }
        return null;
    }

    public static Long getAdminId() {
        User user = login();
        if (user != null) {
            return user.getId();
        }

        return -1L;
    }
}
