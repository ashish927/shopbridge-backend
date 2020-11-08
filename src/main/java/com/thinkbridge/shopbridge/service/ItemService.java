package com.thinkbridge.shopbridge.service;

import com.thinkbridge.shopbridge.model.Item;
import com.thinkbridge.shopbridge.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Item create(Item item) {
        return itemRepository.save(item);
    }
}
