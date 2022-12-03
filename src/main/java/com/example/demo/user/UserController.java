package com.example.demo.user;

import com.example.demo.friend.Friend;
import com.example.demo.generic.EntityController;
import com.example.demo.utils.DataNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController
    extends EntityController<User, UserRepository, UserMapper> {

  public UserController(UserService service) {
    super(service);
  }

  @GetMapping(path = "/{id}/friends")
  public List<Friend> getUserFriends(@PathVariable String id) throws DataNotFoundException {
    return ((UserService) crudService).getUserFriends(id);
  }
}
