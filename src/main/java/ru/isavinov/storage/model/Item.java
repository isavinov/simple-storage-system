package ru.isavinov.storage.model;

import java.util.Date;

public class Item {

    private Long id;

    private String name;

    private String code;

    private Double weight;

    private Date dueTo;

    public Item() {

    }

    public Item(Long id, String name, String code, Double weight, Date dueTo) {
        this.id= id;
        this.name = name;
        this.code = code;
        this.weight = weight;
        this.dueTo = dueTo;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Date getDueTo() {
        return dueTo;
    }

    public void setDueTo(Date dueTo) {
        this.dueTo = dueTo;
    }
}
