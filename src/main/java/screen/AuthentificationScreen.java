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
       // waitElement(regBtn,5);
        loginBtn.click();
        return new ContactListScreen(driver);
    }

    public ContactListScreen submitRegistration(){
       // waitElement(regBtn,5);
        regBtn.click();
        return new ContactListScreen(driver);
    }

    public AuthentificationScreen submitRegistrationNegative(){
       // waitElement(regBtn,5);
        regBtn.click();
        return this;
    }


}
