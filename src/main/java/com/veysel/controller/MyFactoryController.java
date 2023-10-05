package com.veysel.controller;

import com.veysel.service.MyFactoryService;
import com.veysel.util.ICrud;

import java.util.List;
import java.util.Optional;

public class MyFactoryController <T,ID> implements ICrud<T,ID> {

    MyFactoryService<T, ID> myFactoryService;

    public MyFactoryController(MyFactoryService<T, ID> myFactoryService) {
        this.myFactoryService = myFactoryService;
    }
    @Override
    public T save(T entity) {
        return (T) myFactoryService.save(entity);
    }

    @Override
    public Iterable<T> saveAll(Iterable<T> entities) {
        return (List<T>)myFactoryService.saveAll(entities);
    }

    @Override
    public void delete(T entity) {
        myFactoryService.delete(entity);
    }

    @Override
    public void deleteById(ID id) {
        myFactoryService.deleteById(id);
    }

    @Override
    public void update(T entity) {
        myFactoryService.update(entity);
    }

    @Override
    public Optional<T> findByID(ID id) {
        return myFactoryService.findByID(id);
    }

    @Override
    public boolean existById(ID id) {
        return myFactoryService.existById(id);
    }

    @Override
    public List<T> findAll() {
        return myFactoryService.findAll();
    }

    @Override
    public List<T> findByEntity(T entity) {
        return myFactoryService.findByEntity(entity);
    }

    @Override
    public List<T> findByColumnNameAndValue(String columnName, String columnvalue) {
        return myFactoryService.findByColumnNameAndValue(columnName,columnvalue);
    }
}
