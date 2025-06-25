package com.magimight.venn.website.Model;

import com.mongodb.lang.Nullable;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VennSet {
    List<String> sets;
    int size;
    @Nullable
    String label;
}