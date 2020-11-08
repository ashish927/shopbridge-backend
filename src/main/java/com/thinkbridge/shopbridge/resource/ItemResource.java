package com.thinkbridge.shopbridge.resource;

import com.thinkbridge.shopbridge.model.Item;
import com.thinkbridge.shopbridge.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemResource {

    private final ItemService itemService;

    public ItemResource(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.create(item), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Item>> get(){
        return new ResponseEntity<>(itemService.get(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Item> getById(@PathVariable("id") String itemId){
        return new ResponseEntity<>(itemService.getById(itemId), HttpStatus.OK);
    }
}
