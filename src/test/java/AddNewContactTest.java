import config.AppiumConfiguration;
import model.Contact;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screen.ContactListScreen;
import screen.SplashScreen;

public class AddNewContactTest extends AppiumConfiguration {
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
    public void addNewContact(){
    int i = (int) (System.currentTimeMillis() / 1000) % 3600;

    Contact contact = Contact.builder()
            .name("PomPom_" + i)
            .lastName("Cont")
            .phone("01234578" + i)
            .email("pomdomes7" + i + "@mail.com")
            .address("Beer Sheva")
            .description("friend")
            .build();
    Assert.assertTrue(
    new ContactListScreen(driver)
            .openContactForm()
            .fillContactForm(contact)
            .submitContact()
        //    .isNewContactAdded(contact)
            .isNewContactAdded(contact)

    );

}
@Test
public void addNewContactScroll(){
    int i = (int) (System.currentTimeMillis() / 1000) % 3600;

    Contact contact = Contact.builder()
            .name("PomPom_" + i)
            .lastName("Cont")
            .phone("01234578" + i)
            .email("pomdomes7" + i + "@mail.com")
            .address("Beer Sheva")
            .description("friend")
            .build();
    Assert.assertTrue(
    new ContactListScreen(driver)
            .openContactForm()
            .fillContactForm(contact)
            .submitContact()
        //    .isNewContactAdded(contact)
            .isContactAddedScroll(contact)

    );

}
}
