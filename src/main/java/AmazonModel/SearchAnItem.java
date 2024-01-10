package AmazonModel;


import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchAnItem {

    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;
    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;
    @FindBy(xpath = "//span[@class=\"a-size-medium a-color-base a-text-normal\"]")
    WebElement selectProduct;
    @FindBy(id = "add-to-cart-button")
    WebElement addToCart;
    @FindBy(name = "proceedToRetailCheckout")
    WebElement proceedToCart;
    @FindBy(id = "addressChangeLinkId")
    WebElement change;
    @FindBy(id = "add-new-address-popover-link")
    WebElement addNewAddress;


    public SearchAnItem(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //System.out.println(driver);
    }

    public void set_searchBox(String product) {
        searchBox.clear();
        searchBox.sendKeys(product);
    }

    public void set_searchButton() {
        searchButton.click();
    }

    public void set_selectProduct() {
        selectProduct.click();
    }

    public void set_addToCart() {
        addToCart.click();
    }

    public void set_proceedToCart() {
        proceedToCart.submit();
    }

    public void set_change() {
        change.click();
    }

    public void set_addNewAdress() {
        addNewAddress.click();
    }


}
