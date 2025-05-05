package com.magimight.venn.website.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;

@Setter
@Getter
public class RootData {

    @Id
    protected int id;
    protected String name;
    @DBRef
    protected AdminModel creator;
    protected Date creationDate;
    protected int rank;

}
