package com.bdia.tests.account;

import com.bdia.pages.AccountPage;
import com.bdia.pages.HomePage;
import com.bdia.pages.OnboardingPage;
import com.bdia.pages.SelectCountryPage;
import com.bdia.tests.BaseTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest extends BaseTest {

    OnboardingPage onboardingPage;
    HomePage homePage;
    AccountPage accountPage;

    @Test
    public void verifyIssueWithAppES(){
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
        accountPage.goToIssueWithApp();



        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifySettingsLU(){
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
        accountPage.goToIssueWithApp();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
