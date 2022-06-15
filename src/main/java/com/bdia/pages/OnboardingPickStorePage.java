package com.bdia.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.CacheLookup;

public class OnboardingPickStorePage extends BasePage {


    @iOSXCUITFindBy(accessibility = "pick_a_store_onboarding")
    @CacheLookup
    private MobileElement lottieOnboardingChooseStoreImg;

    @iOSXCUITFindBy(xpath = "(XCUIElementTypeStaticText)[1]")
    @CacheLookup
    private MobileElement onboardPickStoreTitletxt;
    @iOSXCUITFindBy(xpath = "(XCUIElementTypeStaticText)[2]")
    @CacheLookup
    private MobileElement onboardPickStoreDescTxt;

    @iOSXCUITFindBy(accessibility = "ChooseButtonId")
    @CacheLookup
    private MobileElement onboadingChooseBtn;

    @iOSXCUITFindBy(accessibility = "SkipButtonId")
    // @CacheLookup
    private MobileElement onboardingSkipBtn;

    public OnboardingPickStorePage() {
    }

    public OnboardingNotificationPage tapSkip() {
        try{
            tap(onboardingSkipBtn);
        } catch (StaleElementReferenceException e){
            refreshScreen(onboardingSkipBtn);
            tap(onboardingSkipBtn);
        }

        return new OnboardingNotificationPage();
    }

}
