package com.example.demo.IT.create;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.example.demo.DemoApplication;
import com.example.demo.IT.TestContext;

import io.cucumber.spring.CucumberContextConfiguration;

@SpringBootTest(classes = TestContext.class)
@CucumberContextConfiguration
@ContextConfiguration(classes = DemoApplication.class)
public class CreateSteps {

}
