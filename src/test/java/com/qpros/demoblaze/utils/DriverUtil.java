package com.qpros.demoblaze.utils;

import com.qpros.demoblaze.common.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Locale;

public class DriverUtil {

    public WebDriver driver = null;

    public WebDriver initiateWebDriver() {
        WebDriverManager.chromedriver().setup();
        if (Boolean.valueOf(System.getProperty(Constants.HEADLESS_MODE.toLowerCase(Locale.ROOT)))) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else {
            driver = new ChromeDriver();
        }
        return driver;
    }
}
