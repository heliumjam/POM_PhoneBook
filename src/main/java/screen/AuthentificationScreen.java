package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class AuthentificationScreen extends BaseScreen {

    public AuthentificationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement authViewText;
    public String getPageAuthName() throws InterruptedException {
        authViewText.wait(  10000);
        return authViewText.getText();
    }

}
