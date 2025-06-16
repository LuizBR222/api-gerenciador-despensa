package com.rodrigodev.FridgeManager.Services;

import org.springframework.stereotype.Service;

import com.rodrigodev.FridgeManager.Models.StorageType;
import com.rodrigodev.FridgeManager.Repository.ProductRepository;

@Service
public class FreezerService extends BaseProductService {
    public FreezerService(ProductRepository productRepository) {
        super(productRepository, StorageType.FREEZER);
    }
}
