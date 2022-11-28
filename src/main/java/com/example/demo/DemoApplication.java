package com.example.demo;

import com.example.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

  @Autowired
  UserRepository userRepository;

  // @Autowired
  // private FriendRepository friendRepository;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }
  // @Bean
  // CommandLineRunner init() {
  // return args -> {
  // Stream
  // .of("John", "Julie", "Jennifer", "Helen", "Rachel")
  // .forEach(name -> {
  // User user = new User(name);
  // userRepository.save(user);
  // if (name == "John") {
  // Friend friend = new Friend("Sam", "roommate", user);
  // friendRepository.save(friend);
  // }
  // });
  // userRepository.findAll().forEach(System.out::println);
  // };
  // }
}
