package org.kirzhoy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserPostsTest extends BaseTest {

    @BeforeEach
    void initAuthorizePage() {
        AuthorizationPage authorizationPage = new AuthorizationPage(getDriver());
        authorizationPage.validUserQuickRegistration("Mary54", "fb37b90703");
    }

    @Test
    @DisplayName("Проверка отображения всех атрибутов последнего поста в ленте")
    public void userPostsDisplayTest() {
        ValidUserHomePage validUserHomePage = new ValidUserHomePage(getDriver());
        validUserHomePage.checkLatestPostIsVisible();
    }

    @Test
    @DisplayName("Проверка обращения к ленте постов через кнопку Home")
    public void receiveUserPostsWithHomeButtonTest() {
        TopMenuBlock topMenuBlock = new TopMenuBlock(getDriver());
        topMenuBlock.aboutButtonClick();
        topMenuBlock.homeButtonClick();

        ValidUserHomePage validUserHomePage = new ValidUserHomePage(getDriver());
        validUserHomePage.checkLatestPostIsVisible();
        validUserHomePage.checkPageHeadingIsDisplayed();
    }

    @Test
    @DisplayName("Проверка перехода между страницами")
    public void switchBetweenPagesTest() {
        PaginatorBlock paginatorBlock = new PaginatorBlock(getDriver());
        paginatorBlock.clickToNextPageButton(2);
        paginatorBlock.clickToPreviousPageButton(1);

        paginatorBlock.checkSecondPageIsDisplayed();
    }

    @Test
    @DisplayName("Проверка вызова пустой страницы")
    public void emptyPageTest() {
        ValidUserHomePage validUserHomePage = new ValidUserHomePage(getDriver());
        validUserHomePage.getEmptyPage();

        EmptyPage emptyPage = new EmptyPage(getDriver());
        emptyPage.checkEmptyPageAppeal();
    }
}
