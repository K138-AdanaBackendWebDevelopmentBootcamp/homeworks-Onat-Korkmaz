package com.example.homework3.services;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T findByID(int id);
    T save(T object);
    void deleteByID(int id);
    T update(T object);
}
