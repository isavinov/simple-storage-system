package ru.isavinov.storage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.isavinov.storage.model.Storage;
import ru.isavinov.storage.service.StorageService;

@Controller
public class StorageMvcController {

    private final StorageService storageService;

    public StorageMvcController(StorageService storageService) {
        this.storageService = storageService;
    }


    @GetMapping
    public String index(Model model){
        model.addAttribute("storages", storageService.getAllStorages());
        model.addAttribute("storage", new Storage());
        return "index";
    }

    @PostMapping("/saveStorage")
    public String addStorage(@ModelAttribute Storage storage){
        storageService.create(storage);
        return "redirect:";
    }
}
