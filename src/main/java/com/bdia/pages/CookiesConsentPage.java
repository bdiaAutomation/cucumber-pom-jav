package com.bdia.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.CacheLookup;

public class CookiesConsentPage extends BasePage{

    public CookiesConsentPage(){
    }
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton/XCUIElementTypeStaticText)[position()=last()-1]")
    @CacheLookup
    private MobileElement refuseCookiesBtn;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton/XCUIElementTypeStaticText)[position()=last()]")
    @CacheLookup
    private MobileElement acceptAllCookiesBtn;

    @iOSXCUITFindBy(accessibility = "cookie")
    @CacheLookup
    private MobileElement lottieImg;

    @iOSXCUITFindBy(accessibility = "(//XCUIElementTypeStaticText)[1]")
    @CacheLookup
    private MobileElement cookiesTitleTxt;

    @iOSXCUITFindBy(accessibility = "(//XCUIElementTypeStaticText)[2]")
    @CacheLookup
    private MobileElement cookiesTitleDesc;

    public OnboardingPage refuseCookies(){
        tap(refuseCookiesBtn);
        return new OnboardingPage();
    }

    public OnboardingLoginPage refuseCookies2(){
        tap(refuseCookiesBtn);
        return new OnboardingLoginPage();
    }

}
