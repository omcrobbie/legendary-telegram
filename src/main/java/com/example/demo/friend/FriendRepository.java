package com.example.demo.friend;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.demo.generic.IEntityRepository;

@Qualifier("friendRepository")
@Repository
public interface FriendRepository extends IEntityRepository<Friend> {

}
