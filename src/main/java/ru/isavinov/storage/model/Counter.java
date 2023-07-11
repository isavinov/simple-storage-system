package ru.isavinov.storage.model;

public class Counter {

    private static Long counter = 0L;

    public static synchronized Long next(){
        return counter++;
    }
}
