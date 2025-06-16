package com.rodrigodev.FridgeManager.Controllers;

import com.rodrigodev.FridgeManager.Models.Product;
import com.rodrigodev.FridgeManager.Models.StorageType;
import com.rodrigodev.FridgeManager.Services.Interfaces.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*") // Permite que qualquer origem acesse a API.
public abstract class BaseController {

    protected final ProductService service;
    protected final StorageType storageType;

    protected BaseController(ProductService service, StorageType storageType) {
        this.service = service;
        this.storageType = storageType;
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = service.getProduct(id);
        if (product == null || product.getStorageType() != storageType) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }


    @GetMapping("/items")
    public ResponseEntity<List<Product>> listItems() {
        // 1. Pega todos os itens que o serviço conhece.
        List<Product> allItems = service.listItems();
        // 2. Filtra a lista para retornar apenas os itens que pertencem a este controlador.
        List<Product> filteredItems = allItems.stream()
                .filter(product -> product.getStorageType() == this.storageType)
                .collect(Collectors.toList());
        // 3. Retorna a lista filtrada.
        return ResponseEntity.ok(filteredItems);
    }

    @PutMapping("/consume/{id}")
    public ResponseEntity<String> consumeOneUnity(@PathVariable Long id) {
        Product product = service.getProduct(id);

        if (product == null || product.getStorageType() != storageType) {
            return ResponseEntity.status(403).body("Invalid product for this endpoint.");
        }

        service.consumeOneUnity(id);
        return ResponseEntity.ok("One unit consumed.");
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {

        if (product.getStorageType() != storageType) {
            return ResponseEntity.badRequest().body("Invalid storage type for this endpoint.");
        }
        service.addProduct(product);
        return ResponseEntity.ok("Product added to " + storageType.name().toLowerCase() + ".");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        Product existing = service.getProduct(id);

        if (existing == null) {
            return ResponseEntity.status(404).body("Product not found.");
        }

        if (existing.getStorageType() != storageType || updatedProduct.getStorageType() != storageType) {
            return ResponseEntity.status(403).body("Invalid storage type for this endpoint.");
        }

        updatedProduct.setId(id);
        service.addProduct(updatedProduct);
        return ResponseEntity.ok("Product updated successfully.");
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> removeProduct(@PathVariable Long id) {
        Product product = service.getProduct(id);
        if (product == null || product.getStorageType() != storageType) {
            return ResponseEntity.badRequest().body("Product not found or not in " + storageType.name().toLowerCase() + ".");
        }
        service.removeProduct(id);
        return ResponseEntity.ok("Product removed from " + storageType.name().toLowerCase() + ".");
    }
}


