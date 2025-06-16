package com.rodrigodev.FridgeManager.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigodev.FridgeManager.Models.Product;
import com.rodrigodev.FridgeManager.Models.StorageType;
import com.rodrigodev.FridgeManager.Repository.ProductRepository;

@Service
public class InventoryService {

    private final ProductRepository productRepository;

    @Autowired
    public InventoryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null || product.getStorageType() == StorageType.SHOPPING_LIST) {
            return null;
        }
        return product;
    }

    public List<Product> getExpiredProducts() {
        LocalDate today = LocalDate.now();

        return getAllStock().stream()
                .filter(p -> p.getExpirationDate() != null && p.getExpirationDate().isBefore(today))
                .collect(Collectors.toList());
    }

    public List<Product> getAllStock() {
        return productRepository.findAll()
                .stream()
                .filter(p -> p.getStorageType() != StorageType.SHOPPING_LIST)
                .collect(Collectors.toList());
    }

    public List<Product> checkNearExpiration() {
        LocalDate today = LocalDate.now();
        return getAllStock().stream()
                .filter(p -> {
                    LocalDate exp = p.getExpirationDate();
                    return exp != null && !exp.isBefore(today) && exp.minusDays(3).isBefore(today);
                })
                .collect(Collectors.toList());
    }

    public void addToShoppingList(Product product) {
        product.setStorageType(StorageType.SHOPPING_LIST);
        productRepository.save(product);
    }
}
