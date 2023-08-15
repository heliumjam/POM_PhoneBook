package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseScreen {
    AppiumDriver<MobileElement> driver;

    public BaseScreen(AppiumDriver<MobileElement> driver) {         //initialize
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this); // Sending to PageFactory Page that we view at now .read THIS page that driver read at now

    /*
    AppiumFieldDecorator receive (driver) information (field) about structure of screen
    than with method .initElements get collection of objects that we see on screen
    this - for THIS page that we get from BaseScreen (where we at now)
     */
    }

    public String getTextBase(MobileElement element)  {

        return element.getText().trim().toUpperCase();
    }

    public void type(MobileElement element, String text){
        element.click();
        element.clear();
        element.sendKeys(text);
        driver.hideKeyboard();
    }

    public void pause(int time){
        try{
            Thread.sleep(time);
        }
        catch (Exception e){
        e.printStackTrace();}
    }

    public  void waitElement(MobileElement element, int time){
        new WebDriverWait(driver,time)
                .until(ExpectedConditions.visibilityOf(element));
    }

    public boolean shouldHave(MobileElement element, String text, int time){
        return new WebDriverWait(driver,time)
                .until(ExpectedConditions.textToBePresentInElement(element , text));
    }

    public boolean isErrorMessageContainsText(String text){
        Alert alert = new WebDriverWait(driver,5)
                .until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        boolean res = alert.getText().contains(text);
        alert.accept();
        return res;
    }
}
