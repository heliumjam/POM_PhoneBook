package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumConfiguration {
    public static AppiumDriver<MobileElement> driver; // static fo priority

//    {
//        "platformName": "Android",
//            "platformVersion": "8.0",
//            "appPackage": "com.sheygam.contactapp",
//            "appActivity": ".SplashActivity",
//            "deviceName": "Nex6"
//    }

@BeforeSuite
    public void setUp() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities(); // setup capabilities
    capabilities.setCapability("platformName", "Android");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nex6");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.0");
    capabilities.setCapability("appPackage", "com.sheygam.contactapp");
    capabilities.setCapability("appActivity", ".SplashActivity");

    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
    capabilities.setCapability(MobileCapabilityType.APP, "C:\\Tools\\apk\\contacts-android.apk");

    driver = new AppiumDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);

}

@AfterSuite
    public void tearDown(){
 //   driver.quit();
}



}
