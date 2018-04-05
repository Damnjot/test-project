package com.testproject.services;

import com.google.common.collect.Lists;
import com.testproject.data.ItemRepository;
import com.testproject.domain.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public void addItem(Item item) throws Exception {
        if(itemRepository.existsByName(item.getName()))
            throw new Exception("Item with that name already exist");
        itemRepository.save(item);
    }

    public void delete(long id) throws Exception {
        if(!itemRepository.existsById(id))
            throw new Exception("Item with given id doesn't exist");
        itemRepository.deleteById(id);
    }

    public void edit(Item item, long id) throws Exception {
        if(itemRepository.existsByName(item.getName()))
            throw new Exception("Item with that name already exist");

        Optional<Item> result = itemRepository.findById(id);

        if(result.isPresent()){
            result.get().update(item);
        }else{
            throw new Exception("There is no item with such id");
        }
    }

    public Item getItem(long id) throws Exception {
        Optional<Item> result = itemRepository.findById(id);

        if(result.isPresent()){
            return result.get();
        }else{
            throw new Exception("There is no item with such id");
        }
    }

    public List<Item> getItems(){
        return Lists.newArrayList(itemRepository.findAll());
    }
}
