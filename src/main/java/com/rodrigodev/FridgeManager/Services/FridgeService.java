package com.rodrigodev.FridgeManager.Services;

import org.springframework.stereotype.Service;

import com.rodrigodev.FridgeManager.Models.StorageType;
import com.rodrigodev.FridgeManager.Repository.ProductRepository;

@Service
public class FridgeService extends BaseProductService {
    public FridgeService(ProductRepository productRepository) {
        super(productRepository, StorageType.FRIDGE);
    }
}
