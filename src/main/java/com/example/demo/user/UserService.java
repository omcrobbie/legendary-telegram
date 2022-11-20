package com.example.demo.user;

import com.example.demo.generic.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CRUDService<User, UserRepository, UserMapper> {

  @Autowired
  public UserService(UserRepository repostory, UserMapper mapper) {
    super(repostory, mapper);
  }
}
