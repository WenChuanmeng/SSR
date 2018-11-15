package com.sr.searchroom.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 根据用户角色选择登录入口
 * Created by 温小萌 on 2018/11/14
 */
public class LoginUrlEntryPoint extends LoginUrlAuthenticationEntryPoint {

    private PathMatcher pathMatcher = new AntPathMatcher();

    private final Map<String, String> authenticationEntryPoint = new HashMap<>();

    public LoginUrlEntryPoint(String loginFormUrl) {
        super(loginFormUrl);
        //用户登录入口
        authenticationEntryPoint.put("/user/**", "/user/login");
        //管理员登录入口
        authenticationEntryPoint.put("/admin/**", "/admin/login");
    }

    /**
     * 根据请求跳转到指定的登录界面，父类是默认使用loginFromUrl
     * @param request
     * @param response
     * @param exception
     * @return
     */
    @Override
    protected String determineUrlToUseForThisRequest(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {

        String uri = request.getRequestURI().replace(request.getContextPath(), "");

        for (Map.Entry<String, String> entry : this.authenticationEntryPoint.entrySet()) {

            if (this.pathMatcher.match(entry.getKey(), uri)) {
                return entry.getValue();
            }

        }
        return super.determineUrlToUseForThisRequest(request, response, exception);
    }
}
