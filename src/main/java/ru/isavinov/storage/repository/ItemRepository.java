package ru.isavinov.storage.repository;

import ru.isavinov.storage.model.Item;

public interface ItemRepository {

    void create(Long storageId, Item item);
}
