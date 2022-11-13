package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.generic.EntityController;

@RestController
@RequestMapping(path = "/users")
public class UserController extends EntityController<User, UserRepository, UserMapper> {

    @Autowired
    public UserController(UserService crudService) {
        super(crudService);
    }

}
