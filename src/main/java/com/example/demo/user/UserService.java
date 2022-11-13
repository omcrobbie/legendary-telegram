package com.example.demo.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.generic.CRUDService;
import com.example.demo.utils.DataNotFoundException;

@Service
public class UserService extends CRUDService<User, UserRepository, UserMapper> {

    public UserService(UserRepository repostory, UserMapper mapper) {
        super(repostory, mapper);
    }

    @Override
    public List<User> getAll() {
        return (List<User>) super.getAll();
    }

    @Override
    public User getOne(String id) throws DataNotFoundException {
        return super.getOne(id);
    }

    @Override
    public void addOne(User entity) {
        super.addOne(entity);

    }

    @Override
    public void updateOne(String id, User entity) throws DataNotFoundException {
        super.updateOne(id, entity);

    }

    @Override
    public void deleteOne(String id) throws DataNotFoundException {
        super.deleteOne(id);

    }

}
