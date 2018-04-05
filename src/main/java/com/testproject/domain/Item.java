package com.testproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

    public Item(){}
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void update(Item item){
        this.description=item.getDescription();
        this.name=item.getName();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }
}
