package com.example.demo.user;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.*;

import com.example.demo.friend.Friend;
import com.example.demo.generic.BaseEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Friend> friends;

    public User(String name) {
        super(name);
    }

    public User() {

    }

    public Set<Friend> getFriends() {
        return friends;
    }

    public void setFriends(Set<Friend> friends) {
        this.friends = friends;
    }

}
