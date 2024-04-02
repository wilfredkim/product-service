package com.wilfred.productservice.productservice.controller;

import com.wilfred.productservice.productservice.dto.ProductRequest;
import com.wilfred.productservice.productservice.dto.ProductResponse;
import com.wilfred.productservice.productservice.model.Product;
import com.wilfred.productservice.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return productService.createProduct(productRequest);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getListOfProducts() {
        return productService.getListOfProducts();
    }

}
