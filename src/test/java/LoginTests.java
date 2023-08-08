import config.AppiumConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screen.ContactListScreen;
import screen.SplashScreen;

public class LoginTests extends AppiumConfiguration {
String email = "domes7@mail.com";
String password = "123456Aa$";

    @Test
    public void LoginPositive(){
        Assert.assertTrue(
        new SplashScreen(driver)
                .goToAuthentificationScreen()
                .fillEmail(email)
                .fillPassword(password)
                .submitLogin()
                        .isContactListPagePresent()
        );

    }

    @AfterMethod
    public void postcondition(){
        if(new ContactListScreen(driver).isContactListPagePresent()){
            new ContactListScreen(driver).logOut();
            new SplashScreen(driver);
        }
    }
}
