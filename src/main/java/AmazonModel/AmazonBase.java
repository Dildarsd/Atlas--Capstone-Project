package AmazonModel;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;
public class AmazonBase {
    public static void main(String[] args) throws IOException {
        System.setProperty("WebDriver.chromer.driver", "C:\\Users\\dildarsd\\Downloads\\chromedriver-win32.zip\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        File SS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(SS.toPath(), new File("C:\\Users\\dildarsd\\Downloads\\SS\\AmazonScreenShots.jpg").toPath());
        }catch (IOException e){
            e.printStackTrace();
        }
        PreSignUp preSignUp = new PreSignUp(driver);
        preSignUp.set_accountButton();
        preSignUp.set_createAccount();
        SignUp signUp = new SignUp(driver);
        signUp.set_fullName("Abdul Dildar");
//      signUp.set_phoneNumber("9985794328");  Disabled the mobile number
        signUp.set_mailID("abduldildar@gmail.com");
        signUp.set_password("1212111917");
        signUp.set_passwordCheck("1212111917");
        signUp.set_verifyemailClick();
        signUp.set_signIn();
        SignInFail signInfail = new SignInFail(driver);
        signInfail.set_username("abduldildar@gmail.com");
        signInfail.continueButtonClick();
        signInfail.set_password("1212111911");
        signInfail.click_button();
        if (signInfail.isErrorDisplayed()) {
            System.out.println("error displayed!");
        }
        signInfail.set_change();
        //Object created for signinPage
        SignIn login = new SignIn(driver);
        login.set_username("abduldildar@gmail.com");
        login.continueButtonClick();
        login.set_password("1212111917");
        login.click_button();
        SearchAnItem products = new SearchAnItem(driver);
        products.set_searchBox("google pixel 7a");
        products.set_searchButton();
        products.set_selectProduct();
        products.set_addToCart();
        products.set_proceedToCart();
        products.set_change();
        products.set_addNewAdress();
//		AutoFill auto = new AutoFill(driver);
//		auto.set_autoFill();
        AddAddress address = new AddAddress(driver);
        address.set_country();
        address.set_fullname("Abdul Dildar");
        address.set_addressLine1("1st Floor, SPM Apartments");
        address.set_addressLine2("Thoraipakkam");
        address.set_city("Chennai");
        address.set_state("Tamil Nadu");
        address.set_postalCode("600001");
        address.set_phonenumber("9985794328");
        address.set_fullname("Abdul Dildar");
        address.set_addressLine1("1A, 1st floor,SPM Apartments");
        address.set_addressLine2("Pilliyar koil Street,Thoraipakkam");
        address.set_state("Tamil Nadu");
        address.set_address();
        address.set_checkBox();
//      address.set_useThisAddress();
        driver.close();
    }
}

