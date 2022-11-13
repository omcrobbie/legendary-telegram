package com.example.demo.generic;

import java.util.List;

import com.example.demo.utils.DataNotFoundException;

public interface ICRUDService<T extends BaseEntity> {

    public List<T> getAll();

    public T getOne(String id) throws DataNotFoundException;

    public void addOne(T entity);

    public void updateOne(String id, T entity) throws DataNotFoundException;

    public void deleteOne(String id) throws DataNotFoundException;

}
