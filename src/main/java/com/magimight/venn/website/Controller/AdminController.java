package com.magimight.venn.website.Controller;

import com.magimight.venn.website.Model.AdminModel;
import com.magimight.venn.website.Repository.AdminRepository;
import com.mongodb.internal.bulk.UpdateRequest;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@Log
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/get")
    public AdminModel getAdmin(@RequestParam String email) {
        System.out.print(email);
        return adminRepository.findByEmail(email);
    }

    @PostMapping("/create")
    public AdminModel createAdmin(@RequestBody AdminModel adminModel) {
        log.info(adminModel.toString());
        return adminRepository.save(adminModel);
    }

    @PutMapping("/{id}")
    public AdminModel updateAdmin(@PathVariable String id, @RequestBody AdminModel adminModel) {
        AdminModel updatedAdmin = adminRepository.findById(id).orElseThrow();

        if (adminModel.getEmail() != null) {
            updatedAdmin.setEmail(adminModel.getEmail());
        }

        if (adminModel.getAdminLevel() != null) {
            updatedAdmin.setAdminLevel(adminModel.getAdminLevel());
        }

        return adminRepository.save(updatedAdmin);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable String id) {
        adminRepository.deleteById(id);
    }

}
