package com.rodrigodev.FridgeManager.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigodev.FridgeManager.Models.StorageType;
import com.rodrigodev.FridgeManager.Services.PantryService;

@RestController
@RequestMapping("/pantry")
public class PantryController extends BaseController {
    public PantryController(PantryService pantryService) {
        super(pantryService, StorageType.PANTRY);
    }
}
