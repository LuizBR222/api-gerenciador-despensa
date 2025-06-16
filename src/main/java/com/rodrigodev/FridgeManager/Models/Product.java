package com.rodrigodev.FridgeManager.Models;

import java.beans.Transient;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate expirationDate;
    private int quantity;
    
    @Enumerated(EnumType.STRING)
    private StorageType storageType;

    public Product() {
    }

    public Product(String name, LocalDate expirationDate, int quantity, StorageType storageType) {
        this.name = name;
        this.expirationDate = expirationDate;
        this.quantity = quantity;
        this.storageType = storageType;
    }

    public void updateQuantity(int qty) {
        this.quantity = qty;
    }

    @Transient
    public boolean isExpired() {
        return expirationDate.isBefore(LocalDate.now());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StorageType getStorageType() {
        return storageType;
    }

    public void setStorageType(StorageType storageType) {
        this.storageType = storageType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
