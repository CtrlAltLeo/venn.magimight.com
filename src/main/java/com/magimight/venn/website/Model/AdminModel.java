package com.magimight.venn.website.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Admin")
public class AdminModel {

    public enum AdminLevel {CREATE, CREATE_DELETE};

    @Id
    private String id;

    @LastModifiedDate
    private String lastModifiedDate;

    private String email;

    private AdminLevel adminLevel;

}
