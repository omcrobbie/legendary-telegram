package com.example.demo.friend;

import com.example.demo.generic.CRUDService;
import org.springframework.stereotype.Service;

@Service
public class FriendService
  extends CRUDService<Friend, FriendRepository, FriendMapper> {

  public FriendService(FriendRepository repostory, FriendMapper mapper) {
    super(repostory, mapper);
  }
}
