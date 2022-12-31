package com.example.demo.utils;

import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.friend.Friend;
import com.example.demo.friend.FriendRepository;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FriendRepository friendRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        loadData();

    }

    private void loadData() {
        Stream
                .of("John", "Julie", "Jennifer", "Helen", "Rachel")
                .forEach(name -> {
                    User user = new User(name);
                    userRepository.save(user);
                    if (name == "John") {
                        Friend friend = new Friend("Sam", "roommate", user);
                        friendRepository.save(friend);
                    }
                });
        userRepository.findAll().forEach(System.out::println);
    };

}
