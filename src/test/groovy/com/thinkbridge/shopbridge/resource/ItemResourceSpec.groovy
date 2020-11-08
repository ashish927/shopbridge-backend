package com.thinkbridge.shopbridge.resource

import com.google.common.collect.ImmutableList
import com.thinkbridge.shopbridge.model.Item
import com.thinkbridge.shopbridge.service.ItemService
import spock.lang.Specification

import static com.thinkbridge.shopbridge.stub.ItemStub.getIem

class ItemResourceSpec extends Specification {

    private ItemResource itemResource
    private ItemService mockItemService = Mock(ItemService.class)

    def setup() {
        itemResource = new ItemResource(mockItemService)
    }

    def "create(): Should create item into inventory"() {
        given:
        Item request = getIem()
        Item response = getIem()
        response.id = 1
        when:
        def result = itemResource.create(request)
        then:
        1 * mockItemService.create(request) >> response

        assert result.statusCode.value() == 201
        assert result.body.id == 1
    }

    def "get(): Should get list of items from inventory"() {
        given:
        Item response = getIem()
        response.id = 1
        when:
        def result = itemResource.get()
        then:
        1 * mockItemService.get() >> ImmutableList.of(response, response)

        assert result.statusCode.value() == 200
        assert result.body.size() == 2
    }

    def "getById(): Should get item for id from inventory"() {
        given:
        Item response = getIem()
        response.id = 1
        when:
        def result = itemResource.getById(1)
        then:
        1 * mockItemService.getById(1) >> response

        assert result.statusCode.value() == 200
        assert result.body.id == 1
    }

    def "update(): Should update item into inventory"() {
        given:
        Item request = getIem()
        request.id = 1
        Item response = getIem()
        response.id = 1
        when:
        def result = itemResource.update(request)
        then:
        1 * mockItemService.update(request) >> response

        assert result.statusCode.value() == 200
        assert result.body.id == 1
    }

    def "deleteById(): Should delete item for id from inventory"() {
        when:
        itemResource.deleteById(1)
        then:
        1 * mockItemService.deleteById(1)

    }


}
