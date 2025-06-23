package com.magimight.venn.website.Controller;

import com.magimight.venn.website.Model.VennModel;
import com.magimight.venn.website.Service.DataService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admindata")
public class AdminDataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/list/venn")
    List<VennModel> getAllVenns(){
        return dataService.getAllVenns();
    }

    @PostMapping("/create/venn")
    VennModel createNewVenn(@Valid @RequestBody VennModel vennModel) {
        return dataService.saveVenn(vennModel);
    }

    @PostMapping("/update/venn")
    VennModel updateVenn(@Valid @RequestBody VennModel vennModel) {
        return dataService.updateVenn(vennModel);
    }

    @DeleteMapping("/venn")
    void deleteVenn(@RequestParam String id) {
        dataService.deleteVenn(id);
    }
}
