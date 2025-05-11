package com.magimight.venn.website.Controller;

import com.magimight.venn.website.Model.VennModel;
import com.magimight.venn.website.Service.DataService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admindata")
public class AdminDataController {

    @Autowired
    private DataService dataService;

    @PostMapping("/create/venn")
    void createNewVenn(@Valid @RequestBody VennModel vennModel) {
        dataService.saveVenn(vennModel);
    }
}
