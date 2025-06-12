package com.magimight.venn.website.Controller;

import com.magimight.venn.website.Service.DataService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HomeController {

    private final DataService dataService;

    public HomeController(DataService dataService) {
        this.dataService = dataService;
    }

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
    @ExceptionHandler(Exception.class)
    public String error(Model model, Exception ex) {
        model.addAttribute("message", ex.getMessage());
        return "error";
    }

    @GetMapping("/venn")
    public String venn(@RequestParam String id, Model model) throws Exception {

        //sanitise this input
        if (dataService.doesVennExist(id)){
            model.addAttribute("vennid", id);
            return "data/display_venn";
        } else {
            throw new Exception("MY BROTHER THIS VENN DOES NOT EXIST");
        }

    }

    @GetMapping("/admindata/create")
    public String createNewVenn(){
        return "/admindata/createNewVenn";
    }

}
