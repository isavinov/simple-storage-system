package ru.isavinov.storage.repository;

import ru.isavinov.storage.model.Storage;

import java.util.Collection;
import java.util.List;

public interface StorageRepository {

    Collection<Storage> getAllStorages();

    Storage getById(Long id);

    void create(Storage storage);

}
