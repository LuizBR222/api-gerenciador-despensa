package com.rodrigodev.FridgeManager.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigodev.FridgeManager.Models.StorageType;
import com.rodrigodev.FridgeManager.Services.FreezerService;

@RestController
@RequestMapping("/freezer")
public class FreezerController extends BaseController {
    public FreezerController(FreezerService freezerService) {
        super(freezerService, StorageType.FREEZER);
    }
}
