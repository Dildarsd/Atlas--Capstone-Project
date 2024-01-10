package AmazonModel;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement.*;

public class AddAddress {

    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(id = "address-ui-widgets-countryCode-dropdown-nativeId")
    WebElement country;
    @FindBy(id = "address-ui-widgets-enterAddressFullName")
    WebElement fullName;

    @FindBy(id = "address-ui-widgets-enterAddressCity")
    WebElement city;
    @FindBy(id = "address-ui-widgets-enterAddressLine1")
    WebElement addressLine1;
    @FindBy(id = "address-ui-widgets-enterAddressLine2")
    WebElement addressLine2;
    @FindBy(id = "address-ui-widgets-enterAddressStateOrRegion")
    WebElement state;
    @FindBy(id = "address-ui-widgets-enterAddressStateOrRegion")
    WebElement stateOrRegion;
    @FindBy(id = "address-ui-widgets-enterAddressPostalCode")
    WebElement zipCode;
    //@FindBy(className = "a-button-input")
    @FindBy(id = "address-ui-widgets-enterAddressPhoneNumber")
    WebElement phoneNumber;

    @FindBy(id = "address-ui-widgets-use-as-my-default")
    WebElement checkBox;
    @FindBy(id = "address-ui-widgets-form-submit-button-announce")
    WebElement useAddress;

    @FindBy(id = "orderSummaryPrimaryActionBtn-announce")
    WebElement useThisAddress;
//	@FindBy(xpath = "//input[@class=\"a-button-input\"]")
//	WebElement clickableElement;

    public AddAddress(WebDriver driver) {
//	    initialize elements ;
        this.driver = driver;

        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//       driver.switchTo().defaultContent();

    }


    public void set_country() {
//      this.driver.switchTo().frame("a-popover-content-1");

        country.sendKeys("IN");

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		WebElement dropdownElement = wait.until(ExpectedConditions.elementToBeClickable(country));
//		dropdownElement.click();

    }

    public void set_fullname(String fname) {

        try {
            fullName.clear();
            fullName.click();
            fullName.sendKeys(fname);
        } catch (StaleElementReferenceException e) {
            fullName = driver.findElement(By.id("address-ui-widgets-enterAddressFullName"));
            fullName.click();
            fullName.sendKeys(fname);
        }
    }

    public void set_addressLine1(String line1) {
        try {
            addressLine1.clear();
            addressLine1.click();
            addressLine1.sendKeys(line1);
        } catch (StaleElementReferenceException e) {
            addressLine1 = driver.findElement(By.id("address-ui-widgets-enterAddressLine1"));
            addressLine1.clear();
            addressLine1.click();
            addressLine1.sendKeys(line1);
        }
    }

    public void set_addressLine2(String line2) {
        try {
            addressLine2.clear();
            addressLine2.click();
            addressLine2.sendKeys(line2);
        } catch (StaleElementReferenceException e) {
            addressLine2 = driver.findElement(By.id("address-ui-widgets-enterAddressLine2"));
            addressLine2.clear();
            addressLine2.click();
            addressLine2.sendKeys(line2);
        }
    }

    public void set_city(String cty) {
        try {
            city.clear();
            city.click();
            city.sendKeys(cty);
        } catch (StaleElementReferenceException e) {
            city = driver.findElement(By.id("address-ui-widgets-enterAddressCity"));
            city.clear();
            city.click();
            city.sendKeys(cty);
        }
    }

    public void set_postalCode(String pcode) {
        try {
            zipCode.clear();
            zipCode.click();
            zipCode.sendKeys(pcode);
        } catch (StaleElementReferenceException e) {
            zipCode = driver.findElement(By.id("address-ui-widgets-enterAddressPostalCode"));
            zipCode.clear();
            zipCode.click();
            zipCode.sendKeys(pcode);
        }

    }

    public void set_state(String region) {
        try {
            stateOrRegion.clear();
            stateOrRegion.click();
            stateOrRegion.sendKeys(region);
        } catch (StaleElementReferenceException e) {
            stateOrRegion = driver.findElement(By.id("address-ui-widgets-enterAddressStateOrRegion"));
            stateOrRegion.clear();
            stateOrRegion.click();
            stateOrRegion.sendKeys(region);
        }
    }


    public void set_phonenumber(String phnumber) {
        try {
            phoneNumber.clear();
            phoneNumber.click();
            phoneNumber.sendKeys(phnumber);
        } catch (StaleElementReferenceException e) {
            phoneNumber = driver.findElement(By.id("address-ui-widgets-enterAddressPhoneNumber"));
            phoneNumber.clear();
            phoneNumber.click();
            phoneNumber.sendKeys(phnumber);
        }
    }

    public void set_checkBox() {
        checkBox.submit();
    }

    public void set_address() {
        useAddress.submit();

    }

}

