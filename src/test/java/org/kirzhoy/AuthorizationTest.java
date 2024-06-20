package org.kirzhoy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AuthorizationTest extends BaseTest {

    @BeforeEach
    void initAuthorizePage() {
        getDriver().get("https://test-stand.gb.ru/login");
    }

    @Test
    @DisplayName("Авторизация пользователя с валидными данными")
    void validAuthorizationTest() {
        AuthorizationPage authorizationPage = new AuthorizationPage(getDriver());
        authorizationPage.inputLoginData("Mary54");
        authorizationPage.inputPasswordData("fb37b90703");
        authorizationPage.clickLoginButton();

        ValidUserHomePage validUserHomePage = new ValidUserHomePage(getDriver());
        validUserHomePage.checkUserGetHomePage("Hello, Mary54");
    }

    @Test
    @DisplayName("Авторизация незарегистрированного пользователя")
    void unregisteredUserAuthorizationTest() {
        AuthorizationPage authorizationPage = new AuthorizationPage(getDriver());
        authorizationPage.inputLoginData("sdggdh");
        authorizationPage.inputPasswordData("fb37b90703");
        authorizationPage.clickLoginButton();

        authorizationPage.checkAuthLoginError401();
    }

    @Test
    @DisplayName("Авторизация пользователя с логином в 3 буквы")
    void boundary3lettersAuthorizationTest() {
        AuthorizationPage authorizationPage = new AuthorizationPage(getDriver());
        authorizationPage.inputLoginData("w12");
        authorizationPage.inputPasswordData("bfe24c7248");
        authorizationPage.clickLoginButton();

        ValidUserHomePage validUserHomePage = new ValidUserHomePage(getDriver());
        validUserHomePage.checkUserGetHomePage("Hello, w12");
    }

    @Test
    @DisplayName("Авторизация пользователя с логином в 21 букву")
    void boundary21lettersAuthorizationTest() {
        AuthorizationPage authorizationPage = new AuthorizationPage(getDriver());
        authorizationPage.inputLoginData("12wr1236lkitr1254popo");
        authorizationPage.inputPasswordData("3fc4c0f76f");
        authorizationPage.clickLoginButton();

        ValidUserHomePage validUserHomePage = new ValidUserHomePage(getDriver());
        validUserHomePage.checkUserGetHomePage("Hello, 12wr1236lkitr1254popo");
    }

    @Test
    @DisplayName("Авторизация пользователя с логином в верхнем регистре")
    void uppercaseLoginAuthorizationTest() {
        AuthorizationPage authorizationPage = new AuthorizationPage(getDriver());
        authorizationPage.inputLoginData("TOTORRO");
        authorizationPage.inputPasswordData("4922a4f9f8");
        authorizationPage.clickLoginButton();

        ValidUserHomePage validUserHomePage = new ValidUserHomePage(getDriver());
        validUserHomePage.checkUserGetHomePage("Hello, TOTORRO");
    }
}
