package com.EvertecTest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;

    // Construtor — recebe o driver e inicializa os elementos da página
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    protected void click(WebElement element) {
        esperePor(element);
        driver.findElement((By) element).click();
    }

    protected void digite(WebElement element, String text) {
        var elemento = driver.findElement((By) element);
        elemento.clear();
        elemento.sendKeys(text);
    }

    protected String Texto(WebElement element) {
        return driver.findElement((By) element).getText();
    }

    protected boolean ehVisivel(WebElement element) {
        try {
            driver.findElement((By) element).isDisplayed();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    protected void esperePor(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
