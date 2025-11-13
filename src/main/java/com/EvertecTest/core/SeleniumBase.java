package com.EvertecTest.core;

import com.EvertecTest.support.DriverFactory;
//import org.junit.After;
//import org.junit.Before;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SeleniumBase {

    protected static WebDriver driver;

    public void setup() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
