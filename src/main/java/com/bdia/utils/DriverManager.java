package com.bdia.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;

public class DriverManager {

    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public static AppiumDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(AppiumDriver newDriver) {
        driver.set(newDriver);
    }

    public void initializeDriver(String platformName, String udid, String deviceName, String webkitDebugPort, String wdaLocalPort ) throws IOException {
        AppiumDriver driver = null;

        if (driver == null) {
            try {
                driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), new CapabilitiesManager().getCaps(platformName,udid,deviceName, webkitDebugPort, wdaLocalPort));
                if (driver == null) {
                    throw new Exception("driver is null. ABORT!!!");
                }
                this.driver.set(driver);
            } catch (Exception e) {
                throw new Error("Driver initialization failure. ABORT !!!!" + e.toString());
            }


        }
    }


}
