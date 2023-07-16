package ru.isavinov.storage.model;

public class StorageStatistic {

    private String name;

    private Long capacity;

    private Long occupation;

    public StorageStatistic(String name, Long capacity, Long occupation) {
        this.name = name;
        this.capacity = capacity;
        this.occupation = occupation;
    }

    public StorageStatistic(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public Long getOccupation() {
        return occupation;
    }

    public void setOccupation(Long occupation) {
        this.occupation = occupation;
    }
}
