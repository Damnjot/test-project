package com.testproject.data;

import com.testproject.domain.Item;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    boolean existsByName(String name);
}
