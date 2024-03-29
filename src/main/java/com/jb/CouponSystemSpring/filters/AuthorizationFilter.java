package com.jb.CouponSystemSpring.filters;


import com.jb.CouponSystemSpring.exceptions.ErrMsg;
import com.jb.CouponSystemSpring.models.ClientType;
import com.jb.CouponSystemSpring.security.TokenService;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class AuthorizationFilter implements Filter {

    @Autowired
    private TokenService tokenService;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String uri = httpServletRequest.getRequestURI();

        if (uri.contains("auth")) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        UUID token = UUID.fromString(httpServletRequest.getHeader("Authorization"));

        if (uri.contains("admin") && tokenService.validate(token, ClientType.ADMIN)) {
            filterChain.doFilter(httpServletRequest, httpServletResponse);
            return;
        }

        if (uri.contains("company") && tokenService.validate(token, ClientType.COMPANY)) {
            int id = tokenService.getUserInfo(token).getId();
            String forwardUrl = concatIdToUri(uri, "company", id);
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher(forwardUrl);
            requestDispatcher.forward(servletRequest, servletResponse);
            return;
        }

        if (uri.contains("customer") && tokenService.validate(token, ClientType.CUSTOMER)) {
            int id = tokenService.getUserInfo(token).getId();
            String forwardUrl = concatIdToUri(uri, "customer", id);
            RequestDispatcher requestDispatcher = servletRequest.getRequestDispatcher(forwardUrl);
            requestDispatcher.forward(servletRequest, servletResponse);
            return;
        }

        httpServletResponse.sendError(401, ErrMsg.UNAUTHORIZED.getMessage());

    }

    private String concatIdToUri(String baseUri, String userTypeUri, int id) {
        String replacement = String.format("%s/%d", userTypeUri, id);
        return baseUri.replace(userTypeUri, replacement);

    }
}
