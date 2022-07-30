package com.example.homework3.dao;

import java.util.List;

public interface BaseDAO<T> {
    List<T> findAll();
    T findByID(Long id);
    T save(T object);
    void deleteByID(Long id);
    T update(T object);
}
