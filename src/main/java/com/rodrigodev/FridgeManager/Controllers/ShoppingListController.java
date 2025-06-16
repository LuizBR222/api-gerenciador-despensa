package com.rodrigodev.FridgeManager.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigodev.FridgeManager.Models.StorageType;
import com.rodrigodev.FridgeManager.Services.ShoppingListService;


@RestController
@RequestMapping("/shopping-list")
public class ShoppingListController extends BaseController {
    public ShoppingListController(ShoppingListService shoppingListService) {
        super(shoppingListService, StorageType.SHOPPING_LIST);
    }
}
