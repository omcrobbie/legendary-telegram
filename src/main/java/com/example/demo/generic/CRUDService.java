package com.example.demo.generic;

import com.example.demo.utils.DataNotFoundException;
import java.util.List;

public class CRUDService<
  T extends BaseEntity,
  R extends IEntityRepository<T>,
  M extends IEntityMapper<T>
>
  implements ICRUDService<T> {

  private R repository;

  private M mapper;

  public CRUDService(R repository, M mapper) {
    this.repository = repository;
    this.mapper = mapper;
  }

  private T findOne(String id) throws DataNotFoundException {
    return repository
      .findById(Long.parseLong(id))
      .orElseThrow(() -> new DataNotFoundException(id));
  }

  public T getOne(String id) throws DataNotFoundException {
    return findOne(id);
  }

  public void addOne(T entity) {
    repository.save(entity);
  }

  public void updateOne(String id, T entity) throws DataNotFoundException {
    T found = findOne(id);
    mapper.updateUser(entity, found);
    repository.save(found);
  }

  public void deleteOne(String id) throws DataNotFoundException {
    T found = findOne(id);
    repository.delete(found);
  }

  public List<T> getAll() {
    return (List<T>) repository.findAll();
  }
}
// }
