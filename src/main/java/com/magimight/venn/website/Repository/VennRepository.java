package com.magimight.venn.website.Repository;

import com.magimight.venn.website.Model.VennModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VennRepository extends MongoRepository<VennModel,Integer> {
}
