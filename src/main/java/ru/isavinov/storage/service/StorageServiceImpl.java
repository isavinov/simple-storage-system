package ru.isavinov.storage.service;

import org.springframework.stereotype.Service;
import ru.isavinov.storage.model.Storage;
import ru.isavinov.storage.repository.StorageRepository;

import java.util.Collection;

@Service
public class StorageServiceImpl implements StorageService{

    private final StorageRepository storageRepository;

    public StorageServiceImpl(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    @Override
    public Collection<Storage> getAllStorages() {
        return storageRepository.getAllStorages();
    }

    @Override
    public Storage getById(Long id) {
        return storageRepository.getById(id);
    }

    @Override
    public void create(Storage storage) {
        storageRepository.create(storage);
    }
}
