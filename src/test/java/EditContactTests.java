import config.AppiumConfiguration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screen.ContactListScreen;
import screen.SplashScreen;

public class EditContactTests extends AppiumConfiguration {
    int i = (int) (System.currentTimeMillis() / 1000) % 3600;


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
    public void editOneContactPositive(){
        String text = "updated_" + i + "@mail.com";
        new ContactListScreen(driver)
                .editOneContact()
                .editEmail(text)
                .submitEditContact()
                .isContactContains(text);
    }

}
