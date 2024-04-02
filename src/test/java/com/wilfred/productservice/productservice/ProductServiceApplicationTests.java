package com.wilfred.productservice.productservice;

import io.restassured.RestAssured;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.http.HttpStatus;
import org.testcontainers.containers.MongoDBContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductServiceApplicationTests {
    @ServiceConnection
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");
    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    static {
        mongoDBContainer.start();
    }
    @Test
    void shouldCreateProduct(){
        String request = """
                {
                    "name": "iPhone 14",
                    "description": "iPhone 14",
                    "price": 15000.00
                }
                """;
        RestAssured.given().contentType("application/json")
                .body(request).when()
                .post("/api/vi/products")
                .then()
                .statusCode(201)
                .body("id", Matchers.notNullValue())
                .body("name", Matchers.equalTo("iPhone 14"))
                .body("description", Matchers.equalTo("iPhone 14"));
                //.body("price", Matchers.equalTo("15000.0F"));

    }

    @Test
    void contextLoads() {
    }

}
