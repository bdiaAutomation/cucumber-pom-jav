package com.bdia.pages;

import com.bdia.component.TabbarComponent;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.CacheLookup;

public class HomePage extends TabbarComponent {

    @iOSXCUITFindBy(accessibility = "auchanLogo")
    @CacheLookup
    private MobileElement headerLogoImg;

    @iOSXCUITFindBy(accessibility = "loyaltyVisual")
    @CacheLookup
    private MobileElement headerLoyaltyCardBtn;

    @iOSXCUITFindBy(accessibility = "welcomeName")
    @CacheLookup
    private MobileElement headerWelcomeNameTxt;

    @iOSXCUITFindBy(accessibility = "secondlineTxt")
    @CacheLookup
    private MobileElement headerSecondLineTxt;

    @iOSXCUITFindBy(accessibility = "search_edittext")
    @CacheLookup
    private MobileElement headerSearchField;

    @iOSXCUITFindBy(accessibility = "FoldButtonId")
    @CacheLookup
    private MobileElement homePickAStoreBtn;

    @iOSXCUITFindBy(accessibility = "background")
    @CacheLookup
    private MobileElement advertisingPopup;

    @iOSXCUITFindBy(accessibility = "close")
    @CacheLookup
    private MobileElement closeAdvertisingPopupBtn;

    public HomePage(){}

    public boolean isHomePageDisplayed(){
        try{
            waitForVisibilityOfElement(headerWelcomeNameTxt);
        } catch (TimeoutException | NoSuchElementException e){
            if(advertisingPopup.isDisplayed()){

                System.out.println("Is advertising displayed: " + advertisingPopup.isDisplayed() );
                tap(closeAdvertisingPopupBtn);
                waitForVisibilityOfElement(headerWelcomeNameTxt);
                if(headerWelcomeNameTxt.isDisplayed()){
                    System.out.println("Is Header displayed: " + headerLogoImg.isDisplayed() );
                    return true;
                }
                return false;
            }
            return false;
        }
        return true;
    }
}
