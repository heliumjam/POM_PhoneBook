package screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ContactListScreen extends BaseScreen{

    public ContactListScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/action_bar']/android.widget.TextView")
    MobileElement activityViewText;

    @FindBy(xpath = "//*[@content-desc='More options']")
    MobileElement moreOptions;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/title']")
    MobileElement logOutBtn;

   @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/add_contact_btn']")
     MobileElement addContactBtn;
    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowContainer']")
    List<MobileElement> rowContainer;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowName']")
    List<MobileElement>  rowName;

    @FindBy(xpath = "//*[@resource-id='com.sheygam.contactapp:id/rowPhone']")
    List<MobileElement> rowPhone;


public boolean isContactListPagePresent() {

    return shouldHave(activityViewText,"Contact list",5);
    }

   public AuthentificationScreen logOut() {
    moreOptions.click();
    logOutBtn.click();
    return new AuthentificationScreen(driver);
   }
   public AddNewContactScreen openContactForm(){
    waitElement(addContactBtn,5);
    addContactBtn.click();
    return new AddNewContactScreen(driver);
   }

}
