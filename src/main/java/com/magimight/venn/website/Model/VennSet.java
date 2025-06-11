package com.magimight.venn.website.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class VennSet {
    List<Character> sets;
    int size;
}