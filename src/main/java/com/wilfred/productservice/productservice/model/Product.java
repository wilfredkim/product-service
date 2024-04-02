package com.wilfred.productservice.productservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "product")
@Builder
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;

}
