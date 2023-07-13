package ru.isavinov.storage.service;

import org.springframework.stereotype.Service;
import ru.isavinov.storage.exception.ItemNotFoundException;
import ru.isavinov.storage.exception.StorageIsFullException;
import ru.isavinov.storage.model.Item;
import ru.isavinov.storage.model.Storage;
import ru.isavinov.storage.repository.ItemRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    public final StorageService storageService;

    public final ItemRepository itemRepository;

    public ItemServiceImpl(StorageService storageService, ItemRepository itemRepository) {
        this.storageService = storageService;
        this.itemRepository = itemRepository;
    }


    @Override
    public List<Item> getAll(Long storageId) {
        return storageService.getById(storageId).getItems();
    }

    @Override
    public Item getById(Long storageId, Long itemId) {
        return storageService.getById(storageId).getItems()
                .stream()
                .filter(s -> s.getId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Item with id"+ itemId +" not found"));
    }

    @Override
    public List<Item> getByCode(Long storageId, String code) {
        return storageService.getById(storageId).getItems()
                .stream()
                .filter(s -> s.getCode().equals(code))
                .collect(Collectors.toList());
    }

    @Override
    public void createItem(Long storageId, Item item) {
        Storage storage = storageService.getById(storageId);

        if (storage.getItems().size() >= storage.getCapacity() ){
            throw new StorageIsFullException("Storage "+storageId+" is full");
        }

        itemRepository.createItem(storageId, item);


    }
}
