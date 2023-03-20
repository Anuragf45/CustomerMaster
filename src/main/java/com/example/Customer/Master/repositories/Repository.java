package com.example.Customer.Master.repositories;

import com.example.Customer.Master.model.Model;
import org.springframework.data.mongodb.repository.MongoRepository;

@org.springframework.stereotype.Repository
public interface Repository extends MongoRepository<Model,String> {

}
