package com.example.demo.friend;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.generic.CRUDService;
import com.example.demo.utils.DataNotFoundException;

@Service
public class FriendService extends CRUDService<Friend, FriendRepository, FriendMapper> {

    public FriendService(FriendRepository repostory, FriendMapper mapper) {
        super(repostory, mapper);
    }

    @Override
    public void addOne(Friend entity) {
        super.addOne(entity);
    }

    @Override
    public void deleteOne(String id) throws DataNotFoundException {
        super.deleteOne(id);

    }

    @Override
    public List<Friend> getAll() {
        return super.getAll();
    }

    @Override
    public Friend getOne(String id) throws DataNotFoundException {
        return super.getOne(id);
    }

    @Override
    public void updateOne(String id, Friend entity) throws DataNotFoundException {
        super.updateOne(id, entity);

    }

}
