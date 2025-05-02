package com.magimight.venn.website.Controller;

import com.magimight.venn.website.Model.TestPersonModel;
import com.magimight.venn.website.Repository.TestPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class TestPersonController {

    @Autowired
    private TestPersonRepository testPersonRepository;

    @GetMapping("/count")
    public long getCount() {
        return testPersonRepository.count();
    }

    @GetMapping("/new")
    public TestPersonModel newPerson() {
        TestPersonModel testPersonModel = new TestPersonModel();
        testPersonModel.setFirstName("Loy");
        testPersonModel.setLastName("Clark");

        testPersonRepository.save(testPersonModel);
        return testPersonModel;
    }
}
