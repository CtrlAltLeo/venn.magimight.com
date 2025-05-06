package com.magimight.venn.website.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document("Admin")
@Getter
@Setter
public class AdminModel {

    public enum AdminLevel {CREATE, CREATE_DELETE};

    @Id
    private String id;

    @CreatedDate
    @Field("created_date")
    private Date createdDate;

    @LastModifiedDate
    @Field("last_modified_date")
    private Date lastModifiedDate;

    private String email;

    //This will need to be hashed
    //private String password;

    @Field("admin_level")
    private AdminLevel adminLevel;

    @Override
    public String toString() {
        return String.format("ID: %s Email: %s Admin Level: %d", id,  email, adminLevel.ordinal());
    }
}
