package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.demo.user.UserRepository;
import com.example.demo.user.UserService;
import com.example.demo.utils.DataNotFoundException;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@SpringBootTest(
  classes = DemoApplication.class,
  webEnvironment = WebEnvironment.MOCK
)
@CucumberOptions(features = "src/test/resources")
public class FeatureTest {}
