package com.example.demo.generic;

import com.example.demo.utils.DataNotFoundException;
import java.util.List;

public interface ICRUDService<T extends BaseEntity> {
  public List<T> getAll();

  public T getOne(String id) throws DataNotFoundException;

  public void addOne(T entity);

  public void updateOne(String id, T entity) throws DataNotFoundException;

  public void deleteOne(String id) throws DataNotFoundException;
}
