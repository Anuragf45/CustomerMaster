package com.example.Customer.Master.services;
import com.example.Customer.Master.model.*;
import com.example.Customer.Master.repositories.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {
    Logger logger = LoggerFactory.getLogger(SecurityException.class);
    @Autowired
    Repository repo;



    public ResponseEntity<?> get() {
        logger.info("sent document as response successfully");
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }



    public ResponseEntity<?> add(Model model) {
        Optional<Model> optional = repo.findById(model.getApiField());
        if (optional.isPresent()) {

             if (optional.get().getDropdownValues().containsAll(model.getDropdownValues()) == true) {
                logger.info("Dropdowns already exists");
                return new ResponseEntity<>("These pairs already exists", HttpStatus.BAD_REQUEST);
            } else
            {
                for (Model.DropdownValue dropdownValue : model.getDropdownValues()) {
                    for(Model.DropdownValue dbDropdown : optional.get().getDropdownValues()){
                        if(dropdownValue.getValue().equals( dbDropdown.getValue())==true){
                            logger.info("Updating names of existing dropdowns");
                            dbDropdown.setName(dropdownValue.getName());

                            repo.save(optional.get());
                        }
                    }
                    if(optional.get().getDropdownValues().contains(dropdownValue)){

                    }else{
                        logger.info("Adding dropdowns");
                        optional.get().getDropdownValues().add(dropdownValue);
                        repo.save(optional.get());
                    }
                }
                return new ResponseEntity<>(optional.get(), HttpStatus.OK);
            }
        } else {
            logger.info("No such doc found in database.Creating one");
            repo.save(model);
            return new ResponseEntity<>(model, HttpStatus.OK);
        }
        }
    }


// if (optional.get().getDropdownValues() == null) {
//                optional.get().setDropdownValues(model.getDropdownValues());
//                repo.save(optional.get());
//                logger.info("No dropdown values found,added the new dropdowns.");
//                return new ResponseEntity<>(optional.get(), HttpStatus.OK);