package com.bdia.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.CacheLookup;

public class OnboardingPage extends BasePage {

    @iOSXCUITFindBy(accessibility = "login_onboarding")
    @CacheLookup
    private MobileElement lottieOnboardLoginImg;
    @iOSXCUITFindBy(accessibility = "pick_a_store_onboarding")
    @CacheLookup
    private MobileElement lottieOnboardingChooseStoreImg;
    @iOSXCUITFindBy(accessibility = "notification_onboarding")
    @CacheLookup
    private MobileElement lottieOnboardingNotificationImg;
    @iOSXCUITFindBy(xpath = "(XCUIElementTypeStaticText)[1]")
    @CacheLookup
    private MobileElement onboardLoginTitletxt;
    @iOSXCUITFindBy(xpath = "(XCUIElementTypeStaticText)[2]")
    @CacheLookup
    private MobileElement onboardLoginDescTxt;
    @iOSXCUITFindBy(accessibility = "LoginButtonId")
    @CacheLookup
    private MobileElement onboardingLoginBtn;
    @iOSXCUITFindBy(accessibility = "ActiveNotificationButtonId")
    @CacheLookup
    private MobileElement onboardingActiveNotificationBtn;
    @iOSXCUITFindBy(accessibility = "SkipButtonId")
   // @CacheLookup
    private MobileElement onboardingSkipBtn;

    public OnboardingPage() {
    }

    public OnboardingPage tapSkip(){
        try{
            tap(onboardingSkipBtn);
        } catch (StaleElementReferenceException e){
            refreshScreen(onboardingSkipBtn);
            tap(onboardingSkipBtn);
        }
        return new OnboardingPage();
    }


}
