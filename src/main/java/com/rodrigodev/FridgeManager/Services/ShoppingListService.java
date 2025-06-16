package com.rodrigodev.FridgeManager.Services;

import org.springframework.stereotype.Service;

import com.rodrigodev.FridgeManager.Models.StorageType;
import com.rodrigodev.FridgeManager.Repository.ProductRepository;

@Service
public class ShoppingListService extends BaseProductService {
    public ShoppingListService(ProductRepository productRepository) {
        super(productRepository, StorageType.SHOPPING_LIST);
    }
}
