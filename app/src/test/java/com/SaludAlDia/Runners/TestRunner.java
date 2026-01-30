package com.SaludAlDia.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// Clase que configura y ejecuta las pruebas de Cucumber
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.SaludAlDia.StepDefinition",
        plugin = {"pretty", "html:build/reports/cucumber.html"},
        tags = "@RegresionSaludAlDia"
)
public class TestRunner {
}