package com.orangehrmlive.opensourcedemo.runner.admin.usermanagement.users;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        publish = true,
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html"},
        features = {"src\\test\\resources\\features.webui\\administrativemodule\\administrativemodule.feature"},
        glue = {"com.orangehrmlive.opensourcedemo.stepdefinition.admin.usermanagement.users"},
        tags = "not @ignore"
)
public class UserCucumberTest {
}