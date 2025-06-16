package com.rodrigodev.FridgeManager.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigodev.FridgeManager.Models.Product;
import com.rodrigodev.FridgeManager.Services.InventoryService;


@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    
    @GetMapping("/item/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Product product = inventoryService.getProductById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(product);
    }

    @GetMapping("/stock")
    public ResponseEntity<List<Product>> listAllStock() {
        return ResponseEntity.ok(inventoryService.getAllStock());
    }

    @GetMapping("/expiring")
    public ResponseEntity<List<Product>> listExpiringSoon() {
        return ResponseEntity.ok(inventoryService.checkNearExpiration());
    }

    @GetMapping("/expired")
    public ResponseEntity<List<Product>> listExpired() {
        return ResponseEntity.ok(inventoryService.getExpiredProducts());
    }

    // @PostMapping("/shopping-list/add")
    // public ResponseEntity<String> addToShoppingList(@RequestBody Product product) {
    //     inventoryService.addToShoppingList(product);
    //     return ResponseEntity.ok("Product added to shopping list.");
    // }
}