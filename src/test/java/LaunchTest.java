import config.AppiumConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import screen.SplashScreen;

public class LaunchTest extends AppiumConfiguration {

    @Test
    public void launch(){

        String version = new SplashScreen(driver).getCurrentVersion();  // AT FIRST START FROM THIS SCREEN

        Assert.assertTrue(version.contains("1.0.0")); // asset for sure that it is that screen

    }
}
