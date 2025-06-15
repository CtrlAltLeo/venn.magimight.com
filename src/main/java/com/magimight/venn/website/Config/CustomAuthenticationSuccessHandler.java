package com.magimight.venn.website.Config;

import com.magimight.venn.website.Model.AdminModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        AdminModel adminModel = (AdminModel) authentication.getPrincipal();
        //List<GrantedAuthority> authorities = (List<GrantedAuthority>) authentication.getAuthorities().stream().toList();

        request.getSession().setAttribute("email", adminModel.getEmail());
        //request.getSession().setAttribute("authority", authorities.getFirst());

        response.sendRedirect("/");
    }
}
