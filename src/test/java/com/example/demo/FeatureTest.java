package com.example.demo;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@ContextConfiguration(classes = { TestApplication.class })
@SpringBootTest(
  webEnvironment = WebEnvironment.RANDOM_PORT,
  classes = DemoApplication.class
)
@CucumberOptions(features = "src/test/resources")
public class FeatureTest {}
