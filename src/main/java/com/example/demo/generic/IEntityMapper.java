package com.example.demo.generic;

public interface IEntityMapper<T> {
  void updateUser(T entityDto, T entity);
}
