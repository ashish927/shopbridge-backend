package com.thinkbridge.shopbridge.service

import com.google.common.collect.ImmutableList
import com.thinkbridge.shopbridge.model.Item
import com.thinkbridge.shopbridge.repository.ItemRepository
import spock.lang.Specification

import static com.thinkbridge.shopbridge.stub.ItemStub.getIem

class ItemServiceSpec extends Specification {

    private ItemService itemService
    private ItemRepository mockItemRepository = Mock(ItemRepository.class)

    def setup() {
        itemService = new ItemService(mockItemRepository)
    }

    def "create(): Should create item into inventory"() {
        given:
        Item request = getIem()
        Item response = getIem()
        response.id = 1
        when:
        def result = itemService.create(request)
        then:
        1 * mockItemRepository.save(request) >> response

        assert result.id == 1
    }

    def "get(): Should get list of items from inventory"() {
        given:
        Item response = getIem()
        response.id = 1
        when:
        def result = itemService.get()
        then:
        1 * mockItemRepository.findAll() >> ImmutableList.of(response, response)

        assert result.size() == 2
    }

    def "getById(): Should get item for id from inventory"() {
        given:
        Item response = getIem()
        response.id = 1
        when:
        def result = itemService.getById(1)
        then:
        1 * mockItemRepository.findById(1) >> Optional.of(response)

        assert result.id == 1
    }

    def "update(): Should update item into inventory"() {
        given:
        Item request = getIem()
        request.id = 1
        Item response = getIem()
        response.id = 1
        when:
        def result = itemService.update(request)
        then:
        1 * mockItemRepository.save(request) >> response

        assert result.id == 1
    }

    def "deleteById(): Should delete item for id from inventory"() {
        when:
        itemService.deleteById(1)
        then:
        1 * mockItemRepository.deleteById(1)

    }
}
