package com.magimight.venn.website.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("TestPerson")
@Getter @Setter
public class TestPersonModel {

    @Id
    private String id;

    private String firstName;
    private String lastName;

}
