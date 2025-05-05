package com.magimight.venn.website.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("Venn_Data_Objects")
@Setter
@Getter
public class VennModel extends RootData {
    ArrayList<Set> Sets;
}

class Set {
    char[] sets;
    int size;
}
