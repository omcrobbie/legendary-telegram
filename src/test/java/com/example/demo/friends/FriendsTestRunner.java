package com.example.demo.friends;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/FriendsMock.feature", extraGlue = "com.example.demo.common", plugin = {
        "pretty", "html:target/cucumber-reports/friends-report.html",
        "json:target/cucumber-reports/friends-report.json" })
public class FriendsTestRunner {

}
