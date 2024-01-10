package AmazonModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreSignUp {

    public WebDriver driver;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    WebElement accountButton;
    @FindBy(id = "createAccountSubmit")
    WebElement createAccount;


    public PreSignUp(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void set_accountButton() {
        accountButton.click();
    }

    public void set_createAccount() {
        createAccount.click();
    }
}
