package com.magimight.venn.website.Repository;

import com.magimight.venn.website.Model.AdminModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<AdminModel,String> {

    AdminModel findByEmail(String email);
}
