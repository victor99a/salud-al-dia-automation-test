package com.SaludAlDia.StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions; // Nueva importación
import java.io.File;                           // Nueva importación
import java.util.HashMap;                      // Nueva importación
import java.util.Map;                          // Nueva importación

public class Hooks {

    private static WebDriver driver;
    public static String downloadPath = System.getProperty("user.dir") + File.separator + "descargas";

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadPath);
        prefs.put("download.prompt_for_download", false);
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        File folder = new File(downloadPath);
        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}