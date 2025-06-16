package com.rodrigodev.FridgeManager.Services;

import org.springframework.stereotype.Service;

import com.rodrigodev.FridgeManager.Models.StorageType;
import com.rodrigodev.FridgeManager.Repository.ProductRepository;

@Service
public class PantryService extends BaseProductService {
    public PantryService(ProductRepository productRepository) {
        super(productRepository, StorageType.PANTRY);
    }
}
