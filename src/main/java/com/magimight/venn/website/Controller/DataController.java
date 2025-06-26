package com.magimight.venn.website.Controller;

import com.magimight.venn.website.Model.VennModel;
import com.magimight.venn.website.Repository.VennRepository;
import com.magimight.venn.website.Service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @GetMapping("/venn")
    Optional<VennModel> getVenn(@RequestParam String id) {
        return dataService.getVenn(id);
    }

    @GetMapping("/dummy")
    void createDummy(){
        dataService.createDummyVenn();
    }

    @GetMapping("/hotness")
    List<VennModel> getHotness(){
        return dataService.getHotness();
    }

    @GetMapping("/freshness")
    List<VennModel> getFreshness(){
        return dataService.getFreshness();
    }

}
