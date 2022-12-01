package com.example.demo.create;

import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.DemoApplication;
import com.example.demo.TestContext;

import io.cucumber.spring.CucumberContextConfiguration;

@SpringBootTest(classes = TestContext.class)
@CucumberContextConfiguration
public class CreateSteps {

}
