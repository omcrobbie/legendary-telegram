package com.example.demo.friend;

import javax.persistence.*;

import com.example.demo.generic.BaseEntity;
import com.example.demo.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "friends")
public class Friend extends BaseEntity {

    @ManyToOne(optional = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = true)
    @JsonBackReference
    private User user;

    private String relation;

    public Friend(String name, String relation, User user) {
        super(name);
        this.relation = relation;
        this.user = user;
    }

    public Friend() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

}
