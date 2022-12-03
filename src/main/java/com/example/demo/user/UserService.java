package com.example.demo.user;

import com.example.demo.friend.Friend;
import com.example.demo.generic.CRUDService;
import com.example.demo.utils.DataNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CRUDService<User, UserRepository, UserMapper> {

  @Autowired
  public UserService(UserRepository repostory, UserMapper mapper) {
    super(repostory, mapper);
  }

  public List<Friend> getUserFriends(String userId) throws DataNotFoundException {
    Set<Friend> friends = getOne(userId).getFriends();
    return new ArrayList<>(friends);
  }
}
