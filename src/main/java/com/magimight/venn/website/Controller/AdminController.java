package com.magimight.venn.website.Controller;

import com.magimight.venn.website.Model.AdminModel;
import com.magimight.venn.website.Repository.AdminRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Log
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/get/{id}")
    public AdminModel getAdmin(@PathVariable String id) {
        return adminRepository.findById(id).orElseThrow();
    }

    @PostMapping("/create")
    public AdminModel createAdmin(@RequestBody AdminModel adminModel) {
        log.info(adminModel.toString());
        return adminRepository.save(adminModel);
    }

    @PutMapping("/{id}")
    public AdminModel updateAdmin(@PathVariable String id, @RequestBody AdminModel adminModel) {
        AdminModel updatedAdmin = adminRepository.findById(id).orElseThrow();
        updatedAdmin = adminModel;
        return adminRepository.save(updatedAdmin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable String id) {
        adminRepository.deleteById(id);
    }

}
