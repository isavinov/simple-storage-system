package ru.isavinov.storage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.isavinov.storage.model.Item;
import ru.isavinov.storage.model.Storage;
import ru.isavinov.storage.service.ItemService;
import ru.isavinov.storage.service.StorageService;

@Controller
public class StorageMvcController {

    private final StorageService storageService;

    private final ItemService itemService;

    public StorageMvcController(StorageService storageService, ItemService itemService) {
        this.storageService = storageService;
        this.itemService = itemService;
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

    @GetMapping("/storage/{storageId}/items")
    public String showItems(Model model, @PathVariable("storageId") Long storageId){
        model.addAttribute("items", itemService.getAll(storageId));
        model.addAttribute("storageId", storageId);
        model.addAttribute("newItem", new Item());
        return "items";
    }

    @PostMapping("/storage/{storageId}/items")
    public String createItem(@PathVariable("storageId") Long storageId, @ModelAttribute Item item){
        itemService.createItem(storageId, item);
        return "redirect:storage/"+storageId+"/items";
    }
}
