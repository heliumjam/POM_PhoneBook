import config.AppiumConfiguration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screen.ContactListScreen;
import screen.SplashScreen;

public class RemoveContactTest extends AppiumConfiguration {
    @BeforeClass
    public void precondition(){
        String email = "domes@mail.com";
        String password = "123456Aa$";
        new SplashScreen(driver)
                .goToAuthentificationScreen()
                .fillEmail(email)
                .fillPassword(password)
                .submitLogin();
    }

    @BeforeMethod
    public void providerContacts(){
        new ContactListScreen(driver).provideContacts();
    }

    @Test
    public void removeOneContactTest(){

        new ContactListScreen(driver)
                .removeOneContact()
                .isContactRemoved();
    }

    @Test
    public void removeAllContactsPositive(){
        new ContactListScreen(driver)
                .removeAllContacts()
                .isNoContactMessage();
    }
}
