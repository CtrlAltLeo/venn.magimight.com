package com.magimight.venn.website.Service;

import com.magimight.venn.website.Model.AdminModel;
import com.magimight.venn.website.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    Optional<AdminModel> getAdminByEmail(String email){

        return Optional.ofNullable(adminRepository.findByEmail(email));

    }

}
