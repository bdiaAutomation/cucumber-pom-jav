package com.bdia.utils;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Optional;

import java.io.InputStream;
import java.util.Properties;

public class CapabilitiesManager {
    ThreadLocal<Properties> prop = new ThreadLocal<Properties>();

    public Properties getProp() {
        return prop.get();
    }

    public void setPros(Properties newProps) {
        this.prop.set(newProps);
    }

    public DesiredCapabilities getCaps(@Optional String platformName, String udid, String deviceName, @Optional("paralleOnly") String webkitDebugProxyPort, @Optional("paralleOnly") String wdaLocalPort) throws Exception {
        try {
            InputStream stream = null;
            Properties newProps = new Properties();

            String fileName = "config.properties";

            try {
                stream = getClass().getClassLoader().getResourceAsStream(fileName);
                newProps.load(stream);
                setPros(newProps);


            } catch (Exception e) {
                throw new Exception("/!\\" + "Properties file is not loade !!!!!" + e.toString());
            } finally {
                if (stream != null) {
                    stream.close();
                }
            }
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(CapabilityType.PLATFORM_NAME, platformName);
            caps.setCapability(MobileCapabilityType.UDID, udid);
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);

            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, getProp().getProperty("iOSAutomationName"));
            caps.setCapability(MobileCapabilityType.APP, getClass().getResource(getProp().getProperty("iOSAppLocation")).getFile());

            caps.setCapability("useNativeCachingStrategy", Boolean.parseBoolean(getProp().getProperty("iOSUseNativeCachingStrategy")));
            caps.setCapability("wdaLocalPort", wdaLocalPort);
            caps.setCapability("webkitDebugProxyPort", webkitDebugProxyPort);
            caps.setCapability("useNewWDA", Boolean.parseBoolean(getProp().getProperty("iOSUseNewWDA")));
            caps.setCapability("includeSafariInWebviews", Boolean.parseBoolean(getProp().getProperty("iOSIncludeSafariInWebviews")));
            caps.setCapability("webviewConnectTimeout", Long.parseLong(getProp().getProperty("iOSWebviewConnectTimeout")));
            caps.setCapability("newCommandTimeout", Long.parseLong(getProp().getProperty("iOSNewCommandTimeout")));

            return caps;
        } catch (Exception e) {
            throw new Exception("Failed to load capabilities. ABORT!! " + e.toString());
        }

    }
}
