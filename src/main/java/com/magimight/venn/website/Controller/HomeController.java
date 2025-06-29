package com.magimight.venn.website.Controller;

import com.magimight.venn.website.Model.VennModel;
import com.magimight.venn.website.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    DataService dataService;

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
        Optional<VennModel> venn = dataService.getVenn(id);
        if (venn.isPresent()){
            model.addAttribute("vennid", id);
            model.addAttribute("vennName", venn.get().getName());
            model.addAttribute("creatorEmail", venn.get().getCreatorEmail());
            model.addAttribute("creationDate", venn.get().getCreationDate());
            model.addAttribute("updoots", venn.get().getRank());
            return "data/display_venn";
        } else {
            throw new Exception("MY BROTHER THIS VENN DOES NOT EXIST");
        }
    }

    @GetMapping("/admindata/create")
    public String createNewVenn(@RequestParam Optional<String> id, Model model) throws Exception {
        if (id.isPresent()){
            model.addAttribute("vennDiagramId", id.get());
        } else {
            model.addAttribute("vennDiagramId", "EMPTY");
        }
        return "admindata/createNewVenn";
    }

    @GetMapping("/data/list")
    public String listVenn(Model model) {
        model.addAttribute("vennList", dataService.getAllVenns());
        return "data/listAllVenns";
    }

}
