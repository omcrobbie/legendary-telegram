package com.example.demo.IT.mock;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/UsersMock.feature", extraGlue = "com.example.demo.IT.common", plugin = {
                "pretty", "html:target/cucumber-reports/mock-report.html",
                "json:target/cucumber-reports/mock-report.json" })
public class MockTestRunner {
}
