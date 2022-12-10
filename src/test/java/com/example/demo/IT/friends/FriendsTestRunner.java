package com.example.demo.IT.friends;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/FriendsMock.feature", extraGlue = "com.example.demo.IT.common", plugin = {
                "pretty", "html:target/cucumber-reports/friends-report.html",
                "json:target/cucumber-reports/friends-report.json" })
public class FriendsTestRunner {

}
