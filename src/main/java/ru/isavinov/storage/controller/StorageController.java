package ru.isavinov.storage.controller;

import org.springframework.web.bind.annotation.*;
import ru.isavinov.storage.model.Item;
import ru.isavinov.storage.model.Storage;
import ru.isavinov.storage.service.ItemService;
import ru.isavinov.storage.service.StorageService;

import java.util.Collection;

@RestController
@RequestMapping("/api/storage")
public class StorageController {

    private final StorageService storageService;

    private final ItemService itemService;


    public StorageController(StorageService storageService, ItemService itemService) {
        this.storageService = storageService;
        this.itemService = itemService;
    }

    @GetMapping
    public Collection<Storage> getAll() {
        return storageService.getAllStorages();
    }

    @GetMapping("/{id}")
    public Storage getById(@PathVariable("id") Long id) {
        return storageService.getById(id);
    }

    @PostMapping
    public void createStorage(@RequestBody Storage storage) {
        storageService.create(storage);
    }

    @GetMapping("/{storageId}/item")
    public Collection<Item> getItemFromStorage(@PathVariable("storageId") Long storageId) {
        return itemService.getAll(storageId);
    }

    @GetMapping(value = "/{storageId}/item", params = {"code"})
    public Collection<Item> getItemFromStorageByCode(@PathVariable("storageId") Long storageId, @RequestParam("code") String code) {
        return itemService.getByCode(storageId, code);
    }

    @GetMapping("/{storageId}/item/{itemId}")
    public Item getItemFromStorageById(@PathVariable("storageId") Long storageId, @PathVariable("itemId") Long itemId) {
        return itemService.getById(storageId, itemId);
    }

    @PostMapping("/{storageId}/item")
    public void createItem(@PathVariable("storageId") Long storageId, @RequestBody Item item) {
        itemService.createItem(storageId, item);
    }
}
