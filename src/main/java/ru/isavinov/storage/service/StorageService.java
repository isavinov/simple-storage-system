package ru.isavinov.storage.service;

import ru.isavinov.storage.model.Storage;

import java.util.Collection;

public interface StorageService {

    Collection<Storage> getAllStorages();

    Storage getById(Long id);

    void create(Storage storage);
}
