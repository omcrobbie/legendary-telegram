package com.example.demo.user;

import com.example.demo.generic.IEntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends IEntityRepository<User> {}
