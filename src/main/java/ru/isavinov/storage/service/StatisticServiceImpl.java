package ru.isavinov.storage.service;

import org.springframework.stereotype.Service;
import ru.isavinov.storage.model.StorageStatistic;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class StatisticServiceImpl implements StatisticService{

    private final StorageService storageService;

    public StatisticServiceImpl(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public Collection<StorageStatistic> generateStatistic() {
        return storageService.getAllStorages()
                .stream()
                .map(storage -> new StorageStatistic(storage.getName(), storage.getCapacity(), (long) storage.getItems().size()))
                .collect(Collectors.toList());
    }
}
