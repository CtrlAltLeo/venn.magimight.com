package com.magimight.venn.website.Controller;

import com.magimight.venn.website.Model.AdminModel;
import com.magimight.venn.website.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/get/{id}")
    public AdminModel getAdmin(@PathVariable int id) {
        return adminRepository.findById(id).orElseThrow();
    }

    @PostMapping("/create")
    public AdminModel createAdmin(@RequestBody AdminModel adminModel) {
        return adminRepository.save(adminModel);
    }

    @PutMapping("/{id}")
    public AdminModel updateAdmin(@PathVariable int AdminID, @RequestBody AdminModel adminModel) {
        AdminModel updatedAdmin = adminRepository.findById(AdminID).orElseThrow();
        updatedAdmin = adminModel;
        return adminRepository.save(updatedAdmin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable int AdminID) {
        adminRepository.deleteById(AdminID);
    }

}
