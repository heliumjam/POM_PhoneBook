import config.AppiumConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import screen.SplashScreen;

public class RegistrationTests extends AppiumConfiguration {
    int i = (int) (System.currentTimeMillis() / 1000) % 3600;
    String email = "pomreg"+i+"@mail.com";
    String password = "123456Aa$";
    String emailNegative = "pommail.ru";

    @Test
    public void LoginPositive(){
        Assert.assertTrue(
                new SplashScreen(driver)
                        .goToAuthentificationScreen()
                        .fillEmail(email)
                        .fillPassword(password)
                        .submitRegistration()
                        .isContactListPagePresent()
        );

    }
}
