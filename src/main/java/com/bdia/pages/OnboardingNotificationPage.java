package com.bdia.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.CacheLookup;

public class OnboardingNotificationPage extends BasePage{

    @iOSXCUITFindBy(accessibility = "ActiveNotificationButtonId")
    @CacheLookup
    private MobileElement onboardingActiveNotificationBtn;

    @iOSXCUITFindBy(accessibility = "SkipButtonId")
    @CacheLookup
    private MobileElement onboardingSkipBtn;

    public OnboardingNotificationPage(){

    }

    public HomePage tapSkip(){
        try{
            tap(onboardingSkipBtn);
        } catch (StaleElementReferenceException e){
            refreshScreen(onboardingSkipBtn);
            tap(onboardingSkipBtn);
        }
         return new HomePage();
    }
}
