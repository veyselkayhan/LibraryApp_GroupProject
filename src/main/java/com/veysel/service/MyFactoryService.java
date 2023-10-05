package com.veysel.service;

import com.veysel.util.ICrud;
import com.veysel.util.MyFactoryRepository;

import java.util.List;
import java.util.Optional;

public class MyFactoryService<T,ID> implements ICrud<T,ID> {

    MyFactoryRepository<T, ID> myFactoryRepository;

    public MyFactoryService(T entity) {
        this.myFactoryRepository = new MyFactoryRepository<>(entity);
    }

    @Override
    public T save(T entity) {
        return (T) myFactoryRepository.save(entity);
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> entities) {
        return (List<T>)myFactoryRepository.saveAll(entities);
    }

    @Override
    public void delete(T entity) {
        myFactoryRepository.delete(entity);

    }

    @Override
    public void deleteById(ID id) {
        myFactoryRepository.deleteById(id);
    }

    @Override
    public void update(T entity) {
        myFactoryRepository.update(entity);
    }

    @Override
    public Optional<T> findByID(ID id) {
        return myFactoryRepository.findByID(id);
    }

    @Override
    public boolean existById(ID id) {
        return myFactoryRepository.existById(id);
    }

    @Override
    public List<T> findAll() {
        return myFactoryRepository.findAll();
    }

    @Override
    public List<T> findByEntity(T entity) {
        return myFactoryRepository.findByEntity(entity);
    }

    @Override
    public List<T> findByColumnNameAndValue(String columnName, String columnvalue) {
        return myFactoryRepository.findByColumnNameAndValue(columnName,columnvalue);
    }
}

