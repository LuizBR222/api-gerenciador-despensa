package com.rodrigodev.FridgeManager.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigodev.FridgeManager.Models.StorageType;
import com.rodrigodev.FridgeManager.Services.FridgeService;

@RestController
@RequestMapping("/fridge")
public class FridgeController extends BaseController {
    public FridgeController(FridgeService fridgeService) {
        super(fridgeService, StorageType.FRIDGE);
    }
}
