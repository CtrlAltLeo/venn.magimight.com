package com.magimight.venn.website.Model;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class RootData {

    @Id
    protected int id;
    protected String name;
    protected AdminModel creator;
    protected Date creationDate;
    protected int rank;

}
