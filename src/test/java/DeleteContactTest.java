import config.AppiumConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screen.SplashScreen;

public class DeleteContactTest extends AppiumConfiguration {
    @BeforeMethod
    public void precondition(){
        String email = "domes7@mail.com";
        String password = "123456Aa$";
        new SplashScreen(driver)
                .goToAuthentificationScreen()
                .fillEmail(email)
                .fillPassword(password)
                .submitLogin();
    }
    @Test
    public void deleteAllContactsTest(){

    }
}
