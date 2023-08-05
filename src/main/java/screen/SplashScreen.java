package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SplashScreen extends BaseScreen{

    public SplashScreen(AppiumDriver<MobileElement> driver) {
        super(driver); // start constructor BaseScreen
    }
/*
resource-id	com.sheygam.contactapp:id/version_text
 */
    // Selenium FindBy(strategy: find for me all elements that contains on this page (BaseScreen) and put it in element MobileElement.
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/version_text']")
    MobileElement versionTextView; // putted elemenet with this xPath to link versionTextView

    public String getCurrentVersion(){
        return versionTextView.getText();
    }
}
