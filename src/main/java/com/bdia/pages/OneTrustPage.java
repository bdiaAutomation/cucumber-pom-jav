package com.bdia.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.CacheLookup;

public class OneTrustPage extends BasePage{

    @iOSXCUITFindBy(accessibility = "ContinueButtonId")
    @CacheLookup
    private MobileElement continueBtn;
    @iOSXCUITFindBy(accessibility = "Allow")
    @CacheLookup
    private MobileElement allowTrackingBtn;


    public OneTrustPage(){}

    public void tapContinueBtn(){
        tap(continueBtn);
    }

    public void allowTracking(){
        waitForAlertToBePresent();
        tap(allowTrackingBtn);
    }

    public CookiesConsentPage acceptOneTrust(){
        tapContinueBtn();
        allowTracking();
        return new CookiesConsentPage();
    }


}
