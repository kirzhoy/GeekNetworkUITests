package org.kirzhoy;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PaginatorBlock extends BasePage {

    public PaginatorBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[.='Next Page']")
    private WebElement nextPageButton;

    @FindBy(xpath = "//a[.='Previous Page']")
    private WebElement previousPageButton;

    @FindBy(xpath = "//h1[.='Blog']")
    private WebElement pageHeading;

    public void clickToNextPageButton(int times) {
        wait5.until(ExpectedConditions.visibilityOf(nextPageButton));
        for (int i = 0; i < times; i++) {
            nextPageButton.click();
        }
    }

    public void clickToPreviousPageButton(int times) {
        wait5.until(ExpectedConditions.visibilityOf(previousPageButton));
        for (int i = 0; i < times; i++) {
            previousPageButton.click();
        }
    }

    public void checkSecondPageIsDisplayed() {
        wait5.until(ExpectedConditions.visibilityOf(pageHeading));
        wait5.until(ExpectedConditions.urlContains("page=2"));
        Assertions.assertEquals("https://test-stand.gb.ru/?page=2", driver.getCurrentUrl());
    }
}
