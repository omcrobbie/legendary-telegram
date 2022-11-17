package com.example.demo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@SpringBootTest(
  classes = DemoApplication.class,
  webEnvironment = WebEnvironment.RANDOM_PORT
)
@CucumberOptions(features = "src/test/resources")
public class FeatureTest {}
