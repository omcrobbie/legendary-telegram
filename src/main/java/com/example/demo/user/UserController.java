package com.example.demo.user;

import com.example.demo.generic.EntityController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController
  extends EntityController<User, UserRepository, UserMapper> {

  public UserController(UserService service) {
    super(service);
  }
}
