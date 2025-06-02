package com.magimight.venn.website.Service;

import com.magimight.venn.website.Model.AdminModel;
import com.magimight.venn.website.Model.VennModel;
import com.magimight.venn.website.Model.VennSet;
import com.magimight.venn.website.Repository.VennRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class DataService {

    @Autowired
    private VennRepository vennRepository;

    @Autowired private AdminService adminService;

   // --- Venn Services -- //

    public Optional<VennModel> getVenn(String id){
        return vennRepository.findById(id);
    }

    public VennModel saveVenn(VennModel vennModel){
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

    // Get top 10 venns

    // Get Recent venns

    // get venns by creator

   // --- List Services -- //

}
