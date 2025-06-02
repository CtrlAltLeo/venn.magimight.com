package com.magimight.venn.website.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document("Venn_Data_Objects")
@Setter
@Getter
public class VennModel extends RootData {
    @Field("sets")
    //VennSet set; This worked
    List<VennSet> sets;

    @Override
    public String toString() {
        return String.format("Name: %s", this.getName());
    }
}

