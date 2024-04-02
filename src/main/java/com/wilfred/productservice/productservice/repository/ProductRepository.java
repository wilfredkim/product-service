package com.wilfred.productservice.productservice.repository;

import com.wilfred.productservice.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
