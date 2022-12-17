package com.example.demo.IT.create;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.IT.TestContext;

import io.cucumber.spring.CucumberContextConfiguration;

@SpringBootTest(classes = TestContext.class)
@CucumberContextConfiguration
public class CreateSteps {

}
