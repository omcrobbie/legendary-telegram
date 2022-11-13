package com.example.demo;

import com.example.demo.friend.Friend;
import com.example.demo.friend.FriendRepository;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private FriendRepository friendRepository;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  @Bean
  CommandLineRunner init() {
    return args -> {
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
}
