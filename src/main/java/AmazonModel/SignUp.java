package AmazonModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
    public WebDriver driver;

    @FindBy(id = "createAccountSubmit")
    WebElement continueButton;
    @FindBy(id = "ap_customer_name")
    WebElement fullName;
    //	@FindBy(id="ap_phone_number")
//	WebElement phoneNumber;
    @FindBy(id = "ap_email")
    WebElement mailID;
    @FindBy(id = "ap_password")
    WebElement password;
    @FindBy(id = "ap_password_check")
    WebElement passwordCheck;
    @FindBy(id = "continue")
    WebElement verifyemail;

    @FindBy(className = "a-link-emphasis")
    WebElement signIn;

    public SignUp(WebDriver driver) {

        PageFactory.initElements(driver, this);
//	 System.out.println(driver);
    }

    public void set_fullName(String name) {
        fullName.clear();
        fullName.sendKeys(name);
//	public void set_phoneNumber(String mobileNumber) {
//		phoneNumber.clear();
//		phoneNumber.sendKeys(mobileNumber);
    }

    public void set_mailID(String email) {
        mailID.clear();
        mailID.sendKeys(email);
    }

    public void set_password(String passWord) {
        password.clear();
        password.sendKeys(passWord);
    }

    public void set_passwordCheck(String password) {
        passwordCheck.clear();
        passwordCheck.sendKeys(password);
    }

    public void set_verifyemailClick() {
        verifyemail.submit();
    }

    public void set_signIn() {
        signIn.click();
    }

}
