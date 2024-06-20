package org.kirzhoy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TopMenuBlock extends BasePage{

    public TopMenuBlock(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = " //span[@class='svelte-1rc85o5' and .='Home']")
    private WebElement homeButton;

    @FindBy (xpath = "//a[.='About']")
    private WebElement aboutButton;

    public void homeButtonClick(){
        wait5.until(ExpectedConditions.visibilityOf(homeButton)).isDisplayed();
        homeButton.click();
    }

    public void aboutButtonClick(){
        wait5.until(ExpectedConditions.visibilityOf(aboutButton)).isDisplayed();
        aboutButton.click();
    }

}
