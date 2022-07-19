package com.example.homework3.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BaseService<T> {
    List<T> findAll();
    T findByID(int id);
    T save(T object);
    void deleteByID(int id);
    T update(T object);
}
