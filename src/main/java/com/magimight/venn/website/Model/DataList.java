package com.magimight.venn.website.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("DataList")
@Setter
@Getter
public class DataList extends RootData {
    ArrayList<String> data;
    Boolean orderedList;
}
