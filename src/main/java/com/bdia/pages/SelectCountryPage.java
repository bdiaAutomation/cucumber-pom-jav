package com.bdia.pages;

import com.bdia.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

public class SelectCountryPage extends BasePage {


    @iOSXCUITFindBy(accessibility = "suggestedChangeCountry")
    @CacheLookup
    private MobileElement suggestedChangeCountryBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "name == \"Select your country\" AND type == \"XCUIElementTypeNavigationBar\"")
    @CacheLookup
    private MobileElement selectCountryPageTitle;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Luxembourg']/preceding-sibling::XCUIElementTypeStaticText[@name='Français']")
    @CacheLookup
    private MobileElement selectedCountry;

    @iOSXCUITFindBy(accessibility = "suggestedContinue")
    @CacheLookup
    private MobileElement suggestedContinueBtn;

    public SelectCountryPage() {
    }

    public OneTrustPage selectACountry(){
        tap(suggestedChangeCountryBtn);
        tap(selectedCountry);
        tap(suggestedContinueBtn);
        return new OneTrustPage();
    }

    private By getXpath(String country, String lang){
        return MobileBy.xpath("//XCUIElementTypeStaticText[@name='"+country+"']/preceding-sibling::XCUIElementTypeStaticText[@name='"+lang+"']");
    }

    public void selectCountryWith(String country, String lang){
        scrollToElement(getXpath(country,lang), "up");
        DriverManager.getDriver().findElement(getXpath(country, lang)).click();

    }

    public OneTrustPage selectACountry(String country, String lang){
        tap(suggestedChangeCountryBtn);
        selectCountryWith(country, lang);
        tap(suggestedContinueBtn);
        return new OneTrustPage();
    }

}
