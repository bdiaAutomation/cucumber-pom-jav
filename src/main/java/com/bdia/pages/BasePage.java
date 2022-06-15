package com.bdia.pages;

import com.bdia.utils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.appmanagement.ApplicationState;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.remote.HideKeyboardStrategy;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.Nullable;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriverWait wait;
    private AppiumDriver<?> driver;

    public BasePage() {
        this.driver = new DriverManager().getDriver();
        wait = new WebDriverWait(this.driver, 30);
        PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
    }

    public void waitForVisibilityOfElement(MobileElement e) {
        wait.until(ExpectedConditions.visibilityOf(e));

    }


    public void waitForVisibilityOfElement(WebElement e) {
        wait.until(ExpectedConditions.visibilityOf(e));

    }

    public void waitForVisibilityOfElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForPresenceOfElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(MobileElement e) {
        wait.until(ExpectedConditions.elementToBeClickable(e));

    }

    public void waitForRefreshElement(MobileElement e) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(e)));
    }

    public void tap(MobileElement e) {
        waitForVisibilityOfElement(e);
        // new TouchAction<>(driver).tap(ElementOption.element(e)).perform();
        e.click();


    }

    public void tap(WebElement e) {
        waitForVisibilityOfElement(e);
        e.click();
    }

    public void click(MobileElement e) {
        waitForElementToBeClickable(e);
        e.click();
    }
    public void click(WebElement e) {
        waitForVisibilityOfElement(e);
        e.click();
    }

    public void sendTxt(MobileElement e, String txt) {
        waitForVisibilityOfElement(e);
        e.sendKeys(txt);
    }

    public String getAttribute(MobileElement e, String attribute) {
        waitForVisibilityOfElement(e);
        return e.getAttribute(attribute);
    }

    public void sendTxt(By by, String txt) {
        waitForVisibilityOfElement(by);
        driver.findElement(by).sendKeys(txt);
    }

    public void tap(By by) {
        waitForVisibilityOfElement(by);
        driver.findElement(by).click();
        // new TouchAction<>(driver).tap(ElementOption.element(driver.findElement(by))).perform();
    }

    public void waitForAlertToBePresent() {
        wait.until(ExpectedConditions.alertIsPresent());
    }

    private FluentWait<AppiumDriver> fluentWait(MobileElement locator, int time) {
        return new FluentWait<>(DriverManager.getDriver())
                .withTimeout(Duration.ofSeconds(time))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .withMessage(locator + "is not displayed");
    }

    public void waitForElement(MobileElement locator, int time) {
        try {
            System.out.println("Checking the " + locator + "  having " + time + " seconds limit");
            fluentWait(locator, time).until(ExpectedConditions.visibilityOf(locator));
        } catch (TimeoutException | NoSuchElementException e) {
            throw new Error("The " + locator + " isn't clickable after timeout");
        }
    }

    public void refreshScreen(MobileElement e) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(e)));
    }

    public Boolean isDisplayed(final By by, long timeOutInSeconds) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            return wait.until(new ExpectedCondition<Boolean>() {
                @NullableDecl
                @Override
                public Boolean apply(@NullableDecl WebDriver driver) {
                    if ((driver.findElement(by).getAttribute("visible")).equalsIgnoreCase("true") || (driver.findElement(by).getAttribute("visible")).equalsIgnoreCase("1")) {

                        System.out.println("Element is displayed : " + true);
                        return true;
                    }
                    System.out.println("Element is not displayed : " + false);
                    return false;
                }
            });
        } catch (Exception ex) {

            System.out.println("Error Element is not displayed : " + false);
            return false;
        }
    }

    public Boolean isDisplayed(final MobileElement e, long timeOutInSeconds) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            return wait.until(new ExpectedCondition<Boolean>() {
                @NullableDecl
                @Override
                public Boolean apply(@NullableDecl WebDriver driver) {
                    if ((e.getAttribute("visible")).equalsIgnoreCase("true") || (e.getAttribute("visible")).equalsIgnoreCase("1")) {

                        System.out.println("Element is displayed : " + true);
                        return true;
                    }
                    System.out.println("Element is not displayed : " + false);
                    return false;
                }
            });
        } catch (Exception ex) {
            return false;
        }
    }


    public void longPress(MobileElement e, int timeInSecond) {
        waitForVisibilityOfElement(e);
        new TouchAction<>(driver).longPress(ElementOption.element(e)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeInSecond))).release().perform();
    }

    public void scrollUsingDirection(String swipeDirection) {

        Dimension size = DriverManager.getDriver().manage().window().getSize();

        int startX = (size.getHeight() / 2);
        int endX = startX;

        int startY = 0;
        int endY = 0;
        if (swipeDirection.toLowerCase().equalsIgnoreCase("up")) {
            startY = (int) (size.getHeight() * 0.8);
            endY = (int) (size.getHeight() * 0.2);
        } else if (swipeDirection.toLowerCase().equalsIgnoreCase("down")) {
            startY = (int) (size.getHeight() * 0.2);
            endY = (int) (size.getHeight() * 0.8);
        } else throw new Error("Unknown swipe Direction : ABORT !!!!");

        new TouchAction<>(driver).press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();

    }

    public void scrollToElement(By by, String direction) {
        for (int i = 0; i < 5; i++) {
            if (isDisplayed(by, 5)) {
                break;
            } else if (direction.equalsIgnoreCase("up")) {
                scrollUsingDirection("up");
            } else if (direction.equalsIgnoreCase("down")) {
                scrollUsingDirection("down");
            }
        }


    }

    public void scrollToElement(MobileElement elt, String direction) {
        for (int i = 0; i < 5; i++) {
            if (isDisplayed(elt, 5)) {
                break;
            } else if (direction.equalsIgnoreCase("up")) {
                scrollUsingDirection("up");
            } else if (direction.equalsIgnoreCase("down")) {
                scrollUsingDirection("down");
            }
        }

    }

    public void closePreferenciesApp(){
        try {
            ApplicationState state = driver.queryAppState("com.apple.Preferences");
            if((state != ApplicationState.NOT_INSTALLED) && (state != ApplicationState.NOT_RUNNING) ){
                driver.terminateApp("com.apple.Preferences");
            }

        } catch (Exception e ){
            throw new Error("Settings App is not ");
        }
    }

    public void ioSNativeScrollToElement(){
        RemoteWebElement parent  = (RemoteWebElement) driver.findElement(By.className("//XCUIElementTypeScrollView"));
        String parenID = parent.getId();
        HashMap<String, String> scrollObject = new HashMap<String,String>();
        scrollObject.put("element", parenID);
        scrollObject.put("predicateString","label CONTAINS '1.'" );
        driver.executeScript("mobile:scroll", scrollObject);

    }

}
