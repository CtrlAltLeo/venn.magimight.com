package com.magimight.venn.website.Service;

import com.magimight.venn.website.Model.AdminModel;
import com.magimight.venn.website.Model.VennModel;
import com.magimight.venn.website.Model.VennSet;
import com.magimight.venn.website.Repository.VennRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Log
public class DataService {

    @Autowired
    private VennRepository vennRepository;

    @Autowired private AdminService adminService;

   // --- Venn Services -- //

    public Optional<VennModel> getVenn(String id){
        return vennRepository.findById(id);
    }

    public VennModel saveVenn(VennModel vennModel){
        log.info(vennModel.toString());
        return vennRepository.save(vennModel);
    }

    public void createDummyVenn(){
       VennModel vennModel = new VennModel();
       vennModel.setName("My Dummy Venn");
       vennRepository.save(vennModel);

        Optional<AdminModel> adminModel = adminService.getAdminByEmail("leodevick@gmail.com");

        System.out.println(adminModel);

        if (adminModel.isPresent()) {
            vennModel.setCreator(adminModel.get());
        }

       System.out.println("Venn created");
    }

    public boolean doesVennExist(String id){
        return vennRepository.existsById(id);
    }

    // Get top 10 venns

    // Get Recent venns

    // get venns by creator

   // --- List Services -- //

}
