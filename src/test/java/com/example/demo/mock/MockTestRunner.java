package com.example.demo.mock;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/UsersMock.feature", extraGlue = "com.example.demo.common")
public class MockTestRunner {
}
