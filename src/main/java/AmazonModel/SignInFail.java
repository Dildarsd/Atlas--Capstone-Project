package AmazonModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class SignInFail {
    public WebDriver driver;
    @FindBy(id = "ap_email")
    WebElement username;
    @FindBy(id = "ap_password")
    WebElement password;
    @FindBy(id = "signInSubmit")
    WebElement button;
    @FindBy(id = "continue")
    WebElement continueButton;
    @FindBy(id = "ap_change_login_claim")
    WebElement changeButton;
    public SignInFail(WebDriver driver) {
        this.driver = driver;//Constructor created to initialize the elements
        PageFactory.initElements(driver, this);
//		 System.out.println(driver);
    }
    public void set_username(String usern) { // Created the methods for the above class and defined few functionalities
        username.clear();
        username.sendKeys(usern);
    }
    public void set_password(String userp) {
        password.clear();
        password.sendKeys(userp);
    }
    public void click_button() {
        button.submit();
    }
    public void continueButtonClick() {
        continueButton.submit();
    }
    public boolean isErrorDisplayed() {
        try {
            WebElement errorMessage = driver.findElement(By.cssSelector(".a-alert-heading"));
            System.out.println(errorMessage);
            System.out.println(errorMessage.isDisplayed());
            return errorMessage.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }
    public void set_change() {
        changeButton.click();
    }
}



