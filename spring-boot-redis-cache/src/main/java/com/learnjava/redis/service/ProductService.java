package com.learnjava.redis.service;

import com.learnjava.redis.entity.Product;
import com.learnjava.redis.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao dao;


    public Product save(Product product) {
        return dao.save(product);
    }

    public List<Product> getAllProducts() {
        return dao.findAll();
    }

    public Product findProduct(int id) {
        return dao.findProductById(id);
    }

    public String remove(int id) {
        return dao.deleteProduct(id);
    }

}
