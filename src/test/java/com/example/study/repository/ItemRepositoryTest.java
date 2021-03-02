package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create() {

        Item item = new Item();
        item.setName("노트북2");
        item.setPrice(100_000);
        item.setContent("삼성 노트북2");

        Item newItem = itemRepository.save(item);
        Assertions.assertNotNull(newItem);
    }

    @Test
    public void read() {
        Optional<Item> item = itemRepository.findById(1L);

        Assertions.assertTrue(item.isPresent());

        item.ifPresent(i -> {
                System.out.println(i);
        });
    }
}
