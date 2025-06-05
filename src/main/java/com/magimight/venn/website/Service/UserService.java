package com.magimight.venn.website.Service;

import com.magimight.venn.website.Model.AdminModel;
import com.magimight.venn.website.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public UserDetails loadUserByUsername(String email){
        return  adminRepository.findByEmail(email);
    }

    public AdminModel createNewUser(AdminModel adminModel){
        adminModel.setPassword( new BCryptPasswordEncoder().encode(adminModel.getPassword()));
        adminRepository.save(adminModel);
        return adminModel;
    }

}
