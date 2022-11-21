package com.example.demo;

import com.example.demo.user.UserRepository;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

// @Profile("test")
// @TestConfiguration
// @ComponentScan
public class TestApplication {
  // @Bean
  // @Primary
  // public UserRepository userRepository() {
  //   UserRepository repo = Mockito.mock(UserRepository.class);
  //   Mockito.when(repo.findById(Mockito.anyLong())).thenReturn(null);
  //   return repo;
  // }
}
