package com.SaludAlDia.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.SaludAlDia.StepDefinition",
        plugin = {"pretty", "html:build/reports/cucumber.html"},
        tags = "@smoke"
)
public class TestRunner {
}