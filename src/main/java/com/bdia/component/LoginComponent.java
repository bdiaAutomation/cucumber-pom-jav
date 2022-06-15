package com.bdia.component;

import com.bdia.pages.BasePage;
import com.bdia.utils.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.remote.HideKeyboardStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;

import java.util.List;
import java.util.Set;

public class LoginComponent extends BasePage {

    By webViewEmailField = By.id("uname1");
    By webViewPwdlField = By.name("passwordLogin");
    By webViewSignInBtn = By.id("btnSubmit_login");
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextField\"")
    @CacheLookup
    private MobileElement emailField;
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeSecureTextField\"")
    @CacheLookup
    private MobileElement pwdField;
    @iOSXCUITFindBy(accessibility = "ForgottenPasswordButtonId")
    @CacheLookup
    private MobileElement forgottenPwdBtn;
    @iOSXCUITFindBy(accessibility = "SignInButtonId")
    @CacheLookup
    private MobileElement signInBtn;
    @iOSXCUITFindBy(accessibility = "SignUpButtonId")
    @CacheLookup
    private MobileElement SignUpBtn;
    @iOSXCUITFindBy(accessibility = "Next:")
    @CacheLookup
    private MobileElement keyboardNextBtn;
    @iOSXCUITFindBy(id = "Done")
    @CacheLookup
    private MobileElement keyboardDoneBtn;

    public void loginWithEmailAndPassword(String email, String pwd) {
        Set<String> contexts = DriverManager.getDriver().getContextHandles();
        System.out.println(contexts);
        if (contexts.size() > 2) {
            DriverManager.getDriver().context((String) contexts.toArray()[contexts.size() - 1]);
            System.out.println(DriverManager.getDriver().getContext());
            sendTxt(webViewEmailField, email);
            sendTxt(webViewPwdlField, pwd);
            tap(webViewSignInBtn);

            DriverManager.getDriver().context((String) contexts.toArray()[0]);
        } else {
            waitForVisibilityOfElement(signInBtn);
            sendTxt(emailField, email);
            tap(keyboardNextBtn);
            sendTxt(pwdField, pwd);
            tap(keyboardDoneBtn);
            tap(signInBtn);
        }


    }

}
