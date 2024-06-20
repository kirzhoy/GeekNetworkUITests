package org.kirzhoy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait5;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait5 = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebDriver getDriver() {
        return driver;
    }
}
