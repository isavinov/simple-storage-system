package ru.isavinov.storage.service;

import ru.isavinov.storage.model.StorageStatistic;

import java.util.Collection;

public interface StatisticService {

    Collection<StorageStatistic> generateStatistic();
}
