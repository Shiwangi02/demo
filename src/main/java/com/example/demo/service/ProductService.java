package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public boolean createProduct(Product product) {
        return repo.insert(product);
    }

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product updateProduct(Product product, int id) {
        return repo.updateById(product, id);
    }

    public boolean deleteProduct(int id) {
        return repo.deleteById(id);
    }
}
