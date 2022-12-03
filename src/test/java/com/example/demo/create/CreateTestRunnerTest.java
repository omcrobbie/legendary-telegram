package com.example.demo.create;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/UsersCreate.feature", extraGlue = "com.example.demo.common")
public class CreateTestRunnerTest {

}
