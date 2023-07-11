package ru.isavinov.storage.model;

import java.util.Date;

public class Item {

    private Long id;

    private String code;

    private Double weight;

    private Date dueTo;

    public Item(String code, Double weight, Date dueTo) {
        this.id= Counter.next();
        this.code = code;
        this.weight = weight;
        this.dueTo = dueTo;
    }

    public Long getId() {
        return id;
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
