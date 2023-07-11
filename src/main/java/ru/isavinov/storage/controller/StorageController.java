package ru.isavinov.storage.controller;

import org.springframework.web.bind.annotation.*;
import ru.isavinov.storage.model.Storage;
import ru.isavinov.storage.service.StorageService;

import java.util.Collection;

@RestController
@RequestMapping("/storage")
public class StorageController {

    private final StorageService storageService;


    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping
    public Collection<Storage>  getAll(){
        return storageService.getAllStorages();
    }

    @GetMapping("/{id}")
    public Storage getById(@PathVariable("id") Long id){
        return storageService.getById(id);
    }

    @PostMapping
    public void createStorage(@RequestBody Storage storage){
        storageService.create(storage);
    }
}
