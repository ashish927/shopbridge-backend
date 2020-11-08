package com.thinkbridge.shopbridge.service;

import com.thinkbridge.shopbridge.model.Item;
import com.thinkbridge.shopbridge.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item create(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> get() {
        return itemRepository.findAll();
    }
}
