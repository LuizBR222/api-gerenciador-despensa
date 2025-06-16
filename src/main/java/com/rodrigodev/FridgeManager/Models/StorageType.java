package com.rodrigodev.FridgeManager.Models;

public enum StorageType {
    FRIDGE("Geladeira"),
    FREEZER("Freezer"),
    PANTRY("Despensa"),
    SHOPPING_LIST("Lista de Compras"),;

    private final String name;

    StorageType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
