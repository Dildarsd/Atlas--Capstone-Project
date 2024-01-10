package AmazonModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AutoFill {
    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(xpath = "//span[@class=\"address-ui-widgets-desktop-button-text\"]")
    WebElement autoFill;

    public AutoFill(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void set_autoFill() {
        autoFill.click();
    }
}
