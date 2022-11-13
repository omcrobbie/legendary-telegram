package com.example.demo.friend;

import com.example.demo.generic.EntityController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/friends")
public class FriendController
  extends EntityController<Friend, FriendRepository, FriendMapper> {

  public FriendController(FriendService service) {
    super(service);
  }
}
