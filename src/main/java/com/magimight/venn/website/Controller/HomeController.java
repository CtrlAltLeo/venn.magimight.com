package com.magimight.venn.website.Controller;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/")
    public String index(Authentication authentication, Model model) {
        if  (authentication != null) {
            UserDetails user = (UserDetails) authentication.getPrincipal();
            model.addAttribute("activeUser", user.getUsername());
        }
        return "home";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/admin/new")
    public String admin() {
        return "admin/createNewAdmin";
    }

    @GetMapping("/error")
    public String error(Model model) {
        model.addAttribute("message", "You are not allowed to access this page");
        return "error";
    }


}
