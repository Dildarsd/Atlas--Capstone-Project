package AmazonModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {

    public WebDriver driver;

    @FindBy(id = "ap_email")
    WebElement username;
    @FindBy(id = "ap_password")
    WebElement password;
    @FindBy(id = "signInSubmit")
    WebElement button;
    @FindBy(id = "continue")
    WebElement continueButton;

    public SignIn(WebDriver driver) {
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
            // Assuming the error message is displayed within an element with a specific CSS class
            WebElement errorMessage = driver.findElement(By.cssSelector(".error-message"));

            // Check if the error message element is displayed
            return errorMessage.isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            // If the element is not found or is stale, consider the error not displayed
            return false;
        }

    }
}



