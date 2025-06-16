package com.rodrigodev.FridgeManager.Services.Interfaces;

import java.util.List;

import com.rodrigodev.FridgeManager.Models.Product;

public interface ProductService {
    Product getProduct(Long id);
    List<Product> listItems();
    void addProduct(Product product);
    void consumeOneUnity(Long id);
    void removeProduct(Long id);
}
