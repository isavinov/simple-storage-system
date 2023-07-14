package ru.isavinov.storage.repository;

import org.springframework.stereotype.Repository;
import ru.isavinov.storage.model.Storage;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class InMemoryStorageRepository implements StorageRepository{

    private Map<Long, Storage> storageMap = new HashMap<>();

    public InMemoryStorageRepository(){

    }

    @Override
    public Collection<Storage> getAllStorages() {
        return storageMap.values();
    }

    @Override
    public Storage getById(Long id) {
        return storageMap.get(id);
    }

    @Override
    public void create(Storage storage) {
        storageMap.put(storage.getId(), storage);
    }
}
