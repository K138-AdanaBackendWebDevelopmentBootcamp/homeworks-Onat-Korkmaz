package com.example.homework3.DAO;

import java.util.List;

public interface BaseDAO<T> {
    List<T> findAll();
    T findByID(int id);
    T save(T object);
    void deleteByID(int id);
    T update(T object);
}
