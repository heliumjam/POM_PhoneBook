package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BaseScreen {
    AppiumDriver<MobileElement> driver;

    public BaseScreen(AppiumDriver<MobileElement> driver) {         //initialize
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); // read page that driver read at now

    /*
    AppiumFieldDecorator receive (driver) information (field) about structure of screen
    than with method .initElements get collection of objects that we see on screen
    this - for THIS page that we get from BaseScreen (where we at now)
     */
    }


}
