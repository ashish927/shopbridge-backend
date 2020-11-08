package com.thinkbridge.shopbridge.stub

import com.thinkbridge.shopbridge.model.Item

class ItemStub {
    static Item getIem() {
        Item item = new Item()
        item.name = "I-1"
        item.description = "Mens shirt"
        item.price = 200.90
        return item
    }
}
