package com.testproject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @GetMapping
    public String get(){
        return "item";
    }

    @PostMapping
    public String post(){
        return "itempost";
    }
    @PutMapping
    public String put(){
        return "put-method";
    }

    @DeleteMapping
    public String delete(){
        return "delete-method";
    }
}
