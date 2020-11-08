package com.thinkbridge.shopbridge.resource;

import com.thinkbridge.shopbridge.model.Item;
import com.thinkbridge.shopbridge.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/item")
public class ItemResource {

    private final ItemService itemService;

    public ItemResource(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.create(item), HttpStatus.CREATED);
    }
}
