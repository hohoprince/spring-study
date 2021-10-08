package com.sunghoon.springwebfluxbook;

import com.sunghoon.springwebfluxbook.Cart;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;


public interface CartRepository extends ReactiveCrudRepository<Cart, String> {

}
