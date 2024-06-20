package org.kirzhoy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {

    private WebDriver driver;

    protected WebDriver getDriver() {
        return driver;
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        getDriver().get("https://test-stand.gb.ru/login");
    }

    @AfterEach
    void quitDriver() {
        driver.quit();
    }
}
