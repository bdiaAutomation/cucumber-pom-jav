package com.bdia.tests;

import com.bdia.utils.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class BaseTest {

    @Parameters({"platformName", "udid", "deviceName", "webkitDebugProxyPort", "wdaLocalPort"})
    @BeforeMethod
    public void setup(String platformName, String udid, String deviceName, String webkitDebugProxyPort, String wdaLocalPort ){

        try {
            new DriverManager().initializeDriver(platformName,udid,deviceName, webkitDebugProxyPort, wdaLocalPort );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @AfterMethod
    public void teardown(){

       try{
           if(DriverManager.getDriver() != null){
               DriverManager.getDriver().quit();
               DriverManager.setDriver(null);
           }
       }catch (Exception e){

           throw new Error("!!!! Driver is not clean quit !!!!" + e.toString());

       }
    }
    
 



}
