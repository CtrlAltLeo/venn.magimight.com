package com.magimight.venn.website.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Document("Admin")
@Getter
@Setter
public class AdminModel implements UserDetails {

    public enum AdminLevel {CREATE, CREATE_DELETE};

    @Id
    private String id;

    @CreatedDate
    @Field("created_date")
    private Date createdDate;

    @LastModifiedDate
    @Field("last_modified_date")
    private Date lastModifiedDate;

    @Indexed(unique = true)
    private String email;

    private String password;

    @Field("admin_level")
    private AdminLevel adminLevel;

    @Override
    public String toString() {
        return String.format("ID: %s Email: %s Admin Level: %d", id,  email, adminLevel.ordinal());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<SimpleGrantedAuthority>(List.of(new SimpleGrantedAuthority(adminLevel.name())));
    }

    @Override
    public String getUsername() {
        return email;
    }
}
