import com.bdia.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.assertj.core.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;


public class DummyTest {
    AppiumDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void openApp() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.PLATFORM_NAME, "ios");
        caps.setCapability(MobileCapabilityType.UDID, "00008110-0006409C3482801E");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        caps.setCapability(MobileCapabilityType.APP, "/Users/bambadia/Desktop/APK/smi.app");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 13 mini");
        caps.setCapability("useNativeCachingStrategy", false);
        caps.setCapability("useNewWDA", true);
        try {
            driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
            // driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectCountry() throws InterruptedException {
        // App Start page  screen
        // logo ---> birdy  accessibility Id
        // suggestChangeCountryBtn ---> suggestedChangeCountry   accessibility ID
        // suggestedContinueBtn ----> suggestedContinue    accessibility ID


        // Select country page

        // verify page title with iospredicate string ---> name == "Select your country" AND type == "XCUIElementTypeNavigationBar"
        // Select a country with xpath  param1 = Country, param2 = language --->   //XCUIElementTypeStaticText[@name="Luxembourg"]/preceding-sibling::XCUIElementTypeStaticText[@name="Français"]


        /** One Trust consent ***/
        // Verify Image with Accessibility ID ---> FriendlyTracking
        // Verify title text with Accessibility ID  ----> TitleLabelId
        // Verify description text with Accessibility ID  ----> DescriptionLabelId
        // Click On continue button with Accessibility ID  -----> ContinueButtonId
        // Action Accept alert with accessibility ID Allow or using Xpath (//XCUIElementTypeAlert//XCUIElementTypeButton)[2]

        /** Cookies Consent ***/
        // Verify image of cookies consent by accessibility ID ----> cookie
        // Verify cookies consent title text by xpath ----> (//XCUIElementTypeStaticText)[1]
        // Verify cookies consent description by Xpath ----> (//XCUIElementTypeStaticText)[2]
        // Action Refuse all cookies button by Xpath ----> (//XCUIElementTypeButton/XCUIElementTypeStaticText)[position()=last()-1]
        // Action Accept all cookies button by xpath -----> (//XCUIElementTypeButton/XCUIElementTypeStaticText)[position()=last()]


        wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("suggestedChangeCountry")));

        MobileElement suggestChangeCountryBtn = (MobileElement) driver.findElement(MobileBy.AccessibilityId("suggestedChangeCountry"));
        suggestChangeCountryBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.iOSNsPredicateString("name == \"Select your country\" AND type == \"XCUIElementTypeNavigationBar\""))).click();
        MobileElement selectCountryTitle = (MobileElement) driver.findElement(MobileBy.iOSNsPredicateString("name == \"Select your country\" AND type == \"XCUIElementTypeNavigationBar\""));
        String selectCountryTitleTxt = selectCountryTitle.getAttribute("name");

        SoftAssertions softAss = new SoftAssertions();
        softAss.assertThat(selectCountryTitleTxt).isEqualTo("Select your country");

        softAss.assertAll();

        MobileElement country = (MobileElement) driver.findElement(MobileBy.xpath("//XCUIElementTypeStaticText[@name='Luxembourg']/preceding-sibling::XCUIElementTypeStaticText[@name='Français']"));
        country.click();

        MobileElement suggestedContinueBtn = (MobileElement) driver.findElement(MobileBy.AccessibilityId("suggestedContinue"));
        suggestedContinueBtn.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("ContinueButtonId"))).click();
        wait.until(ExpectedConditions.alertIsPresent());
        // MobileElement acceptTrackingBtn = (MobileElement) driver.findElement(MobileBy.name("Allow"));
        MobileElement acceptTrackingBtn = (MobileElement) driver.findElement(MobileBy.xpath("(//XCUIElementTypeAlert//XCUIElementTypeButton)[2]"));
        acceptTrackingBtn.click();

        MobileElement refuseCookiesBtn = (MobileElement) driver.findElement(MobileBy.xpath("(//XCUIElementTypeButton/XCUIElementTypeStaticText)[position()=last()-1]"));
        refuseCookiesBtn.click();


        /*MobileElement acceptCookiesBtn = (MobileElement) driver.findElement(MobileBy.xpath("(//XCUIElementTypeButton/XCUIElementTypeStaticText)[position()=last()]"));
        acceptCookiesBtn.click();
        */

        /** Onboarding screens **/
        //1. OnboardLoginScreen
        // Verify the OnboardLoginScreen image by Accessibility id ---> login_onboarding
        // Verify the OnboardLoginScreen title's text by Xpath ----> (XCUIElementTypeStaticText)[1]
        // Verify the OnboardLoginScreen description txt by xpath ---> (XCUIElementTypeStaticText)[2]
        // Action on login button using  Accessibility ID ---> LoginButtonId
        // Action  on skip button using Accessibility ID ----> SkipButtonId


        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("login_onboarding")));
        // MobileElement loginButton = (MobileElement)driver.findElement(MobileBy.AccessibilityId("LoginButtonId"));
        //  loginButton.click();
        By skipBtn = MobileBy.AccessibilityId("SkipButtonId");
       /* wait.until(ExpectedConditions.presenceOfElementLocated(skipBtn)).click();
        String handle = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();
        for(String window  : set ){
            System.out.println(window.toString());
        }

        */

        try {
            Thread.sleep(6000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //2. OnboardChooseStoreScreen
        // Verify the OnboardChooseStoreScreen image by Accessibility id ---> pick_a_store_onboarding
        // Verify the OnboardChooseStoreScreen title's text by Xpath ----> (XCUIElementTypeStaticText)[1]
        // Verify the OnboardChooseStoreScreen description txt by xpath ---> (XCUIElementTypeStaticText)[2]
        // Action on Choose a store button using  Accessibility ID ---> ChooseButtonId
        // Action  on skip button using Accessibility ID ----> SkipButtonId
      //  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("pick_a_store_onboarding")));
       // wait.until(ExpectedConditions.presenceOfElementLocated(skipBtn)).click();

        //3. OnboardNotificationScreen
        // Verify the OnboardNotificationScreen image by Accessibility id ---> notification_onboarding
        // Verify the OnboardNotificationScreen title's text by Xpath ----> (XCUIElementTypeStaticText)[1]
        // Verify the OnboardNotificationScreen description txt by xpath ---> (XCUIElementTypeStaticText)[2]
        // Action on Choose a store button using  Accessibility ID ---> ActiveNotificationButtonId
        // Action  on skip button using Accessibility ID ----> SkipButtonId

      //  wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("notification_onboarding")));
      //  wait.until(ExpectedConditions.presenceOfElementLocated(skipBtn)).click();
        try {
            Thread.sleep(6000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.findElement(MobileBy.AccessibilityId("accountIcon")).click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//XCUIElementTypeButton/XCUIElementTypeStaticText"))).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("SignInButtonId")));
        driver.findElement(MobileBy.iOSNsPredicateString("type == \"XCUIElementTypeTextField\"")).sendKeys("bre@auchan.fr");
        driver.findElement(MobileBy.iOSNsPredicateString("type == \"XCUIElementTypeSecureTextField\"")).sendKeys("Test1234");
        driver.findElement(MobileBy.AccessibilityId("SignInButtonId")).click();
        driver.findElement(MobileBy.AccessibilityId("accountIcon")).click();
        Thread.sleep(9000);
        System.out.println(driver.getPageSource());
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//XCUIElementTypeButton/XCUIElementTypeStaticText")));
        Thread.sleep(10000);




    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
