package ru.isavinov.storage.service;

import ru.isavinov.storage.model.Item;

import java.util.List;

public interface ItemService {

    List<Item> getAll(Long storageId);

    Item getById(Long storageId, Long itemId);

    List<Item> getByCode(Long storageId, String code);

    void createItem(Long storageId, Item item);
}
