package com.thinkbridge.shopbridge.resource;

import com.thinkbridge.shopbridge.model.Item;
import com.thinkbridge.shopbridge.service.ItemService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/item")
public class ItemResource {

    private final ItemService itemService;

    public ItemResource(ItemService itemService) {
        this.itemService = itemService;
    }

    @ApiOperation(value = "Create item into inventory", response = Item.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created item"),
    }
    )
    @PostMapping
    public ResponseEntity<Item> create(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.create(item), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Retrieve list of items from inventory", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list of items"),
    }
    )
    @GetMapping
    public ResponseEntity<List<Item>> get() {
        return new ResponseEntity<>(itemService.get(), HttpStatus.OK);
    }

    @ApiOperation(value = "Retrieve item for {id} from inventory", response = Item.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved item"),
            @ApiResponse(code = 400, message = "No item found for Id:{id}")
    }
    )
    @GetMapping("{id}")
    public ResponseEntity<Item> getById(@PathVariable("id") Long itemId) {
        return new ResponseEntity<>(itemService.getById(itemId), HttpStatus.OK);
    }

    @ApiOperation(value = "update item for {id} into inventory", response = Item.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated item")
    }
    )
    @PutMapping
    public ResponseEntity<Item> update(@RequestBody Item item) {
        return new ResponseEntity<>(itemService.update(item), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete item for {id} into inventory")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted item")
    }
    )
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") Long itemId) {
        itemService.deleteById(itemId);
    }
}
