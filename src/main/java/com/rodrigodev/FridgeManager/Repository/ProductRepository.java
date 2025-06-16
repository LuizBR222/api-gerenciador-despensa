package com.rodrigodev.FridgeManager.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigodev.FridgeManager.Models.Product;
import com.rodrigodev.FridgeManager.Models.StorageType;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByStorageType(StorageType storageType);
}
