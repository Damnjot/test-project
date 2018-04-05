package com.testproject.controllers;

import com.testproject.domain.Item;
import com.testproject.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    private ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService){
        this.itemService=itemService;
    }

    @GetMapping ("{id}")
    public ResponseEntity getItem(@PathVariable long id) {
        try {
            return ResponseEntity.status(200).body(itemService.getItem(id));
        }catch (Exception e){

            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
    }
    @PostMapping
    public ResponseEntity post(@RequestBody Item item){
        try {
            itemService.addItem(item);
            return ResponseEntity
                    .status(201)
                    .body(Map.of(
                    "message", "Item created successfully",
                    "path", "/api/items/" + item.getId()));
        }catch (Exception e){
            return ResponseEntity.status(404).body(Map.of("message", e.getMessage()));
        }
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
