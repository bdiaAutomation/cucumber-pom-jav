package com.bdia.pages;

import com.bdia.component.LoginComponent;
import com.bdia.component.TabbarComponent;
import com.bdia.utils.DriverManager;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class AccountPage extends TabbarComponent {

    @iOSXCUITFindBy(accessibility = "accountViewControllerTableViewAL")
    private MobileElement accountView;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeStaticText")
    private MobileElement accountTitleTxt;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeTable/descendant::XCUIElementTypeButton/XCUIElementTypeStaticText)[position()=1]")
    private MobileElement loginBtn;

    @iOSXCUITFindBy(accessibility = "SignInButtonId")
    private MobileElement signInBtn;


    @iOSXCUITFindBy(iOSNsPredicate = "label CONTAINS '1.'")
    @CacheLookup
    private MobileElement versionTxt;

    @iOSXCUITFindBy(xpath = "XCUIElementTypeButton")
    private MobileElement dummyBtn;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeCell'")
    @CacheLookup
    private List<MobileElement> accountEntries;

    @iOSXCUITFindBy(accessibility = "Allow Auchan To Access")
    private MobileElement settingsAllowAppTtx;


    public LoginComponent goToLoginPage() {
        tap(loginBtn);
        return new LoginComponent();
    }

    public String getUserAccount() {
        //goToAccountPage();
        isDisplayed(dummyBtn, 10);
        return getAttribute(accountTitleTxt, "name");
    }

    public String getAppVersion() {
       scrollToElement(versionTxt, "up");
       //  ioSNativeScrollToElement();
        return getAttribute(versionTxt, "name");
    }

    public void openSettings() {
        // TODO refactor tis method using accessibility Id
        isDisplayed(dummyBtn, 5);
        int size = accountEntries.size();
        System.out.println(size);
        MobileElement settings = accountEntries.get(accountEntries.size() - 10);
        scrollToElement(settings,"up" );
        tap(settings);
    }

    public String getAppPrefenciesTxt(){
        return getAttribute(settingsAllowAppTtx, "name");
    }

    public void goToIssueWithApp(){
        MobileElement issueEntry = accountEntries.get(this.getNumberOfEntries() - 2);
        scrollToElement(issueEntry,"up" );
        tap(issueEntry);
    }

    private int getNumberOfEntries(){
       // isDisplayed(dummyBtn, 15);
        return accountEntries.size();
    }


}
