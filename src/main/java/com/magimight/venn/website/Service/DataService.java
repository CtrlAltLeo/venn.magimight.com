package com.magimight.venn.website.Service;

import com.magimight.venn.website.Model.AdminModel;
import com.magimight.venn.website.Model.VennModel;
import com.magimight.venn.website.Model.VennSet;
import com.magimight.venn.website.Repository.VennRepository;
import jakarta.validation.Valid;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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

        vennModel.setCreationDate(new Date());

        return vennRepository.save(vennModel);
    }

    public void createDummyVenn(){
       VennModel vennModel = new VennModel();
       vennModel.setName("My Dummy Venn");
       vennRepository.save(vennModel);

       System.out.println("Venn created");
    }

    public boolean doesVennExist(String id){
        return vennRepository.existsById(id);
    }

    public VennModel updateVenn(@Valid VennModel vennModel) {
        Optional<VennModel> venn = getVenn(vennModel.getId());
        if (venn.isPresent()){
            VennModel retrievedVenn = venn.get();
            retrievedVenn.setName(vennModel.getName());
            retrievedVenn.setSets(vennModel.getSets());
            return vennRepository.save(retrievedVenn);
        } else {
            return null;
        }
    }

    public List<VennModel> getAllVenns() {
        return vennRepository.findAll();
    }

    public void deleteVenn(String id) {
        Optional<VennModel> venn = getVenn(id);
        venn.ifPresent(vennModel -> vennRepository.delete(vennModel));
    }

    public List<VennModel> getHotness() {
        return vennRepository.findTop10ByOrderByRankDesc();
    }

    public List<VennModel> getFreshness() {
        return vennRepository.findTop10ByOrderByCreationDateDesc();
    }

    // Get top 10 venns

    // Get Recent venns

    // get venns by creator

   // --- List Services -- //

}
