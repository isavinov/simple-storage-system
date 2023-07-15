package ru.isavinov.storage.model;

import java.util.ArrayList;
import java.util.List;

public class Storage {

    private Long id;

    private Long capacity;

    private String name;

    private String address;

    private List<Item> items = new ArrayList<>();

    public Storage() {

    }

    public Storage(Long id, String name, String address, Long capacity) {
        this.id= id;
        this.capacity = capacity;
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }
}
