package com.bdia.component;

import com.bdia.pages.AccountPage;
import com.bdia.pages.BasePage;
import com.bdia.pages.HomePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.CacheLookup;

public class TabbarComponent extends BasePage {

    @iOSXCUITFindBy(accessibility = "homeIcon")
    @CacheLookup
    protected MobileElement tabbarHomeBtn;

    @iOSXCUITFindBy(accessibility = "mcommerceIcon")
    @CacheLookup
    protected MobileElement tabbarMcommerceBtn;

    @iOSXCUITFindBy(accessibility = "cartIcon")
    @CacheLookup
    protected MobileElement cartBtn;

    @iOSXCUITFindBy(accessibility = "promotionsIcon")
    @CacheLookup
    protected MobileElement promotionsBtn;

    @iOSXCUITFindBy(accessibility = "accountIcon")
    @CacheLookup
    protected MobileElement userBtn;


    public HomePage goToHomePage(){
        tap(tabbarHomeBtn);
        return new HomePage();
    }

    public AccountPage goToAccountPage(){
        tap(userBtn);
        return new AccountPage();
    }

    public void goToMcommerce(){
        tap(tabbarMcommerceBtn);
    }

    public void goToCouponsPage(){
        tap(promotionsBtn);
    }


}
