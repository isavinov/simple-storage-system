package ru.isavinov.storage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.isavinov.storage.model.StorageStatistic;
import ru.isavinov.storage.service.StatisticService;

import java.util.Collection;

@RestController
@RequestMapping("/api/statistic")
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping
    public Collection<StorageStatistic> getStatistic(){
        return statisticService.generateStatistic();
    }
}
