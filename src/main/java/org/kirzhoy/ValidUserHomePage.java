package org.kirzhoy;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ValidUserHomePage extends BasePage {

    public ValidUserHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//li[@class='svelte-1rc85o5 mdc-menu-surface--anchor']//a[@class='svelte-1rc85o5']")
    private WebElement userName;

    @FindBy(xpath = "//h1[.='Blog']")
    private WebElement homePageHeading;

    @FindBy (xpath = "//a[@href='/posts/116080']")
    private WebElement linkToPost10;

    @FindBy(xpath = "//img[@src='http://test-stand.gb.ru/files/public/image/ca370eef0fb7bcf23d5ac610c5b21158.jpg']")
    private WebElement linkToPost10Image;

    @FindBy(xpath = "//h2[.='Test10']")
    private WebElement post10TitleText;

    @FindBy(xpath = "//div[.='little spider']")
    private WebElement post10Description;

    public void checkUserGetHomePage(String expectedUserName) {
        wait5.until(ExpectedConditions.visibilityOf(userName)).isDisplayed();
        Assertions.assertEquals(expectedUserName, userName.getText());
    }

    public void checkPageHeadingIsDisplayed(){
        wait5.until(ExpectedConditions.visibilityOf(homePageHeading)).isDisplayed();
        Assertions.assertEquals("Symfony Blog", getDriver().getTitle());
        }

    public void checkLatestPostIsVisible(){
        wait5.until(ExpectedConditions.visibilityOf(homePageHeading)).isDisplayed();
        Assertions.assertTrue((linkToPost10).isDisplayed());
        Assertions.assertTrue((linkToPost10Image).isDisplayed());
        Assertions.assertTrue((post10TitleText).isDisplayed());
        Assertions.assertTrue((post10Description).isDisplayed());
    }

    public void getEmptyPage(){
       wait5.until(ExpectedConditions.urlToBe("https://test-stand.gb.ru/"));
        getDriver().get("https://test-stand.gb.ru/?page=10");
    }

}



