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

    public Product createProduct(Product product) {
        return repo.save(product);
    }

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public Product updateProduct(Product product, int id) {
    	Product getProduct = repo.getById(id);
    	getProduct.setPrice(product.getPrice());
    	getProduct.setDescription(product.getDescription());
    	getProduct.setName(product.getName());
        return repo.save(getProduct);
    }

    public boolean deleteProduct(int id) {
        repo.deleteById(id);
        return true;
    }
}
