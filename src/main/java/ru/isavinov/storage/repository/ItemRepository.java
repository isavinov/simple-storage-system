package ru.isavinov.storage.repository;

import ru.isavinov.storage.model.Item;

public interface ItemRepository {

    void createItem(Long storageId, Item item);
}
