package com.bdia.tests;

import com.bdia.pages.*;
import com.bdia.tests.BaseTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class LoginTest extends BaseTest {

    //SelectCountryPage selectCountryPage;
    OnboardingPage onboardingPage;
    HomePage homePage;
    AccountPage accountPage;

    @Test
    public void successfullLoginES() {
        onboardingPage = new SelectCountryPage()
                .selectACountry("España", "Español")
                .acceptOneTrust()
                .refuseCookies()
                .tapSkip()
                .tapSkip()
                .tapSkip();
        homePage = new HomePage();
        assertThat(homePage.isHomePageDisplayed()).isTrue();
        accountPage = homePage.goToAccountPage();
        accountPage.goToLoginPage().loginWithEmailAndPassword("loyaltyesplata@yopmail.com", "Test12345#");
        String actualUserAccount = accountPage.getUserAccount();
        String expectedUserAccount = "Jhh Jkk";

        assertThat(actualUserAccount).isEqualTo(expectedUserAccount);

        assertThat(accountPage.getAppVersion().trim()).containsIgnoringCase("1.39.0");


    }
    @Test
    public void successfullLoginPL() {
        onboardingPage = new SelectCountryPage()
                .selectACountry("Polski", "Polska")
                .acceptOneTrust()
                .refuseCookies()
                .tapSkip()
                .tapSkip()
                .tapSkip();
        homePage = new HomePage();
        assertThat(homePage.isHomePageDisplayed()).isTrue();
        accountPage = homePage.goToAccountPage();
        accountPage.goToLoginPage().loginWithEmailAndPassword("loyaltypl1@yopmail.com", "Test1234");
        String actualUserAccount = accountPage.getUserAccount();
        String expectedUserAccount = "Loyalty Testtest";

        assertThat(actualUserAccount).isEqualTo(expectedUserAccount);

        assertThat(accountPage.getAppVersion().trim()).containsIgnoringCase("1.39.0");


    }
    @Test
    public void successfullLoginLU()
    {
        onboardingPage = new SelectCountryPage()
                .selectACountry("Luxembourg", "Français")
                .acceptOneTrust()
                .refuseCookies()
                .tapSkip()
                .tapSkip()
                .tapSkip();
        homePage = new HomePage();
        assertThat(homePage.isHomePageDisplayed()).isTrue();
        accountPage = homePage.goToAccountPage();
        accountPage.goToLoginPage().loginWithEmailAndPassword("nathan@neville.com", "Test1111");
        String actualUserAccount = accountPage.getUserAccount();
        String expectedUserAccount = "Nathan Neville";

        assertThat(actualUserAccount.trim()).containsIgnoringCase(expectedUserAccount);
        assertThat(accountPage.getAppVersion().trim()).containsIgnoringCase("1.39.0");

    }

}
