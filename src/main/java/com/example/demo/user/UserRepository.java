package com.example.demo.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.generic.IEntityRepository;

@Qualifier("userRepository")
@Repository
public interface UserRepository extends IEntityRepository<User> {

}
