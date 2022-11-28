package com.example.demo.create;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.DemoApplication;

import io.cucumber.spring.CucumberContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = DemoApplication.class)
@CucumberContextConfiguration
public class CreateSteps {

}
