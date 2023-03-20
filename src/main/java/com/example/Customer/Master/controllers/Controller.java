package com.example.Customer.Master.controllers;

import com.example.Customer.Master.model.Model;
import com.example.Customer.Master.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    Service service;


    @GetMapping("/get")
    public ResponseEntity<?> get(){
        return new ResponseEntity<>(service.get(),HttpStatus.OK);
    }


    @PutMapping("/add")
    public ResponseEntity<?> add(@RequestBody Model model){
        return new ResponseEntity<>(service.add(model),HttpStatus.OK);
    }
}
