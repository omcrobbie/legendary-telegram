package com.example.demo.generic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IEntityRepository<T> extends CrudRepository<T, Long> {

}
