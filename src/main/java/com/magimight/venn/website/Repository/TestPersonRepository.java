package com.magimight.venn.website.Repository;

import com.magimight.venn.website.Model.TestPersonModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TestPersonRepository extends MongoRepository<TestPersonModel, String> {

    public long count();

}
