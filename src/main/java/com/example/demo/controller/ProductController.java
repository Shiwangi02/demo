package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import com.sun.net.httpserver.HttpsServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping()
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product productRes = service.createProduct(product);
        return new ResponseEntity(productRes, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = service.getProducts();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updatedproduct = service.updateProduct(product, product.getId());
        return new ResponseEntity(updatedproduct, HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable  int id) {
        boolean status = service.deleteProduct(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
