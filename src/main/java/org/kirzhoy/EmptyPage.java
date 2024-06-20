package org.kirzhoy;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmptyPage extends BasePage {

    public EmptyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p[.='No items for your filter']")
    private WebElement emptyPageStatement;


    public void checkEmptyPageAppeal() {
        wait5.until(ExpectedConditions.visibilityOf(emptyPageStatement)).isDisplayed();
        Assertions.assertEquals("No items for your filter", emptyPageStatement.getText());
    }
}
