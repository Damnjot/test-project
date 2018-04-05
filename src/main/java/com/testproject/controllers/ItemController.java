package com.testproject.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
public class ItemController {

    @PutMapping
    public String put(){
        return "put-method";
    }

    @DeleteMapping
    public String delete(){
        return "delete-method";
    }
}
