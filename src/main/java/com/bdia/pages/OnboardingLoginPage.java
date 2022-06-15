package com.bdia.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.CacheLookup;

public class OnboardingLoginPage extends BasePage {
    @iOSXCUITFindBy(accessibility = "login_onboarding")
    @CacheLookup
    private MobileElement lottieOnboadLoginImg;

    @iOSXCUITFindBy(xpath = "(XCUIElementTypeStaticText)[1]")
    @CacheLookup
    private MobileElement onboadLoginTitletxt;
    @iOSXCUITFindBy(xpath = "(XCUIElementTypeStaticText)[2]")
    @CacheLookup
    private MobileElement onboadLoginDescTxt;
    @iOSXCUITFindBy(accessibility = "LoginButtonId")
    @CacheLookup
    private MobileElement onboardingLoginBtn;

    @iOSXCUITFindBy(accessibility = "SkipButtonId")
    @CacheLookup
    private MobileElement onboardingSkipBtn;

    public OnboardingLoginPage() {
    }

    public OnboardingPickStorePage tapSkip() {

        try {
            tap(onboardingSkipBtn);
        } catch (StaleElementReferenceException e) {
            refreshScreen(onboardingSkipBtn);
            tap(onboardingSkipBtn);
        }

        return new OnboardingPickStorePage();
    }
}
