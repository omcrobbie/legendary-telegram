package com.example.demo.friend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.generic.EntityController;

@RestController
@RequestMapping(path = "/friends")
public class FriendController extends EntityController<Friend, FriendRepository, FriendMapper> {

    @Autowired
    public FriendController(FriendService service) {
        super(service);
    }

}
