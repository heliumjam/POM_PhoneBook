package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthentificationScreen extends BaseScreen {

    public AuthentificationScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement authViewText;

//    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/inputEmail']")
//    MobileElement emailInput;
    @FindBy(id = "com.sheygam.contactapp:id/inputEmail")
    MobileElement inputEmail;

    @FindBy(id = "com.sheygam.contactapp:id/inputPassword")
    MobileElement inputPassword;

    @FindBy(id = "com.sheygam.contactapp:id/regBtn")
    MobileElement regBtn;
    @FindBy(id = "com.sheygam.contactapp:id/loginBtn")
    MobileElement loginBtn;

    public String getPageAuthName()  {

        return getTextBase(authViewText);
    }

    public AuthentificationScreen fillEmail(String email) { //for stay on This page and remember this statement
        waitElement(inputEmail,5);
        type(inputEmail,email);
        return this; //return Yourself
    }

    public AuthentificationScreen fillPassword(String password) {
        waitElement(inputPassword,5);
        type(inputPassword,password);
        return this;
    }

    public ContactListScreen submitLogin(){
        loginBtn.click();
        return new ContactListScreen(driver);
    }

    public ContactListScreen submitRegistration(){
        regBtn.click();
        return new ContactListScreen(driver);
    }

    public boolean isAlertPresent() {

        Alert alert = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) return false;
        driver.switchTo().alert();
        // System.out.println(alert.getText());
        alert.accept();
        return true;
    }

    public AuthentificationScreen submitRegistrationNegative(){
        Alert alert = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) return this;
        driver.switchTo().alert();
        // System.out.println(alert.getText());
        alert.accept();
        return this;

    }


}
