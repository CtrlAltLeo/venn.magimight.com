package com.magimight.venn.website.Repository;

import com.magimight.venn.website.Model.VennModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VennRepository extends MongoRepository<VennModel,String> {

    List<VennModel> findTop10ByOrderByCreationDateDesc();

    List<VennModel> findTop10ByOrderByRankDesc();
}
