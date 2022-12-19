package com.example.demo;

import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.friend.Friend;
import com.example.demo.friend.FriendRepository;
import com.example.demo.user.User;
import com.example.demo.user.UserRepository;

// @EnableWebSecurity
@SpringBootApplication
public class DemoApplication {

  @Autowired
  UserRepository userRepository;

  @Autowired
  private FriendRepository friendRepository;

  public static void main(String[] args) {
    SpringApplication.run(DemoApplication.class, args);
  }

  // @Bean
  // public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
  // Exception {

  // return http.build();
  // }

  // @Bean
  // public UserDetailsService userDetailsService() {
  // PasswordEncoder encoder =
  // PasswordEncoderFactories.createDelegatingPasswordEncoder();
  // UserDetails user = User.withUsername("spring")
  // .password(encoder.encode("secret"))
  // .roles("USER")
  // .build();

  // return new InMemoryUserDetailsManager(user);
  // }
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
