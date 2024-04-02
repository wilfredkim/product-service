package com.wilfred.productservice.productservice.service;

import com.wilfred.productservice.productservice.dto.ProductRequest;
import com.wilfred.productservice.productservice.dto.ProductResponse;
import com.wilfred.productservice.productservice.model.Product;
import com.wilfred.productservice.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        Product savedProduct = productRepository.save(product);
        log.info("Saved A new product:::::::::::");
        return getProductResponse(savedProduct);
    }

    private ProductResponse getProductResponse(Product savedProduct) {
        return new ProductResponse(savedProduct.getId(), savedProduct.getName(), savedProduct.getDescription(), savedProduct.getPrice());
    }

    public List<ProductResponse> getListOfProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(this::getProductResponse).toList();
    }

}
