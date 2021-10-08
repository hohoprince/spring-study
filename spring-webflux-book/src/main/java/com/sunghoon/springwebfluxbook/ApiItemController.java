package com.sunghoon.springwebfluxbook;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiItemController {

    private final ItemRepository itemRepository;

    public ApiItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    
}
