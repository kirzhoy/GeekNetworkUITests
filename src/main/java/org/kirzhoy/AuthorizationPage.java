package org.kirzhoy;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthorizationPage extends BasePage {

    public AuthorizationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='text']")
    private WebElement loginField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[.='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//h2[.='401']")
    private WebElement loginAuthErrorCode;

    public void inputLoginData(String login) {
        loginField.sendKeys(login);
    }
    public void inputPasswordData(String password) {
        passwordField.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }

    public void validUserQuickRegistration(String username, String password){
        loginField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void checkAuthLoginError401(){
        wait5.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[.='401']"))).isDisplayed();
        Assertions.assertTrue(loginAuthErrorCode.isDisplayed());
    }

}
