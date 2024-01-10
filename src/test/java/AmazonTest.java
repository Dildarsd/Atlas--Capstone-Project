import AmazonModel.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class AmazonTest extends AmazonBase {

    WebDriver driver;

    @BeforeTest()
    public void setUp() {

        System.setProperty("Webdriver.chromer.driver", "C:\\Users\\dildarsd\\Downloads\\chromedriver-win32.zip\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        File SS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(SS.toPath(), new File("C:\\Users\\dildarsd\\Downloads\\SS\\AmazonPage.jpg").toPath());
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    @Test(priority = 1)
    public void signUp() {
        SignUp signUp = new SignUp(driver);

        //  driver.get("https://www.amazon.com/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26signIn%3D1%26useRedirectOnSuccess%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
        PreSignUp preSignUp = new PreSignUp(driver);
        preSignUp.set_accountButton();
        preSignUp.set_createAccount();


        signUp.set_fullName("Abdul Dildar");
        //	signUp.set_phoneNumber("9985794328");
        signUp.set_mailID("abduldildar@gmail.com");
        signUp.set_password("1212111917");
        signUp.set_passwordCheck("1212111917");
        signUp.set_verifyemailClick();
        File SS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(SS.toPath(), new File("C:\\Users\\dildarsd\\Downloads\\SS\\AmazonSignUp.jpg").toPath());
        }catch (IOException e){
            e.printStackTrace();
        }
        signUp.set_signIn();

    }

    @Test(priority = 3)
    public void signIn() {
        SignIn login = new SignIn(driver);  //Object created for signinPage

        // driver.get("https://www.amazon.com/");
        login.set_username("abduldildar@gmail.com");
        login.continueButtonClick();
        login.set_password("1212111917");
        login.click_button();
        File SS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(SS.toPath(), new File("C:\\Users\\dildarsd\\Downloads\\SS\\AmazonSignIn.jpg").toPath());
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    @Test(priority = 2)
    public void signInFail() {
        SignInFail signInfail = new SignInFail(driver);  //Object created for signinPage

        // driver.get("https://www.amazon.com/");

        signInfail.set_username("abduldildar@gmail.com");
        signInfail.continueButtonClick();
        signInfail.set_password("1212111918");
        signInfail.click_button();
        assertTrue(signInfail.isErrorDisplayed());
        File SS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(SS.toPath(), new File("C:\\Users\\dildarsd\\Downloads\\SS\\AmazonSignInFail.jpg").toPath());
        }catch (IOException e){
            e.printStackTrace();
        }
        signInfail.set_change();



    }

    @Test(priority = 4)
    public void searchItem() {
        SearchAnItem products = new SearchAnItem(driver);

        products.set_searchBox("google pixel 7a");
        products.set_searchButton();
        products.set_selectProduct();
        File SS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(SS.toPath(), new File("C:\\Users\\dildarsd\\Downloads\\SS\\SearchItem.jpg").toPath());
        }catch (IOException e){
            e.printStackTrace();
        }
        products.set_addToCart();
        products.set_proceedToCart();
        products.set_change();
        products.set_addNewAdress();


    }

    @Test(priority = 5)
    public void addAddress() {
        AddAddress address = new AddAddress(driver);
        //  driver.get("https://www.amazon.com/gp/buy/kyc/xborder/handlers/display.html?_from=cheetah");
        // auto.set_autoFill();
        address.set_country();
        address.set_fullname("Abdul Dildar");
        address.set_addressLine1("1st Floor, SPM Apartments");
        address.set_addressLine2("Thoraipakkam");
        address.set_city("Chennai");
        address.set_state("Tamil Nadu");
        address.set_postalCode("600001");
        address.set_phonenumber("9985794328");
        address.set_fullname("Abdul Dildar");
        address.set_addressLine1("1st Floor, SPM Apartments");
        address.set_addressLine2("Thoraipakkam");
        address.set_state("Tamil Nadu");
        address.set_address();
        address.set_checkBox();
        File SS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(SS.toPath(), new File("C:\\Users\\dildarsd\\Downloads\\SS\\Address.jpg").toPath());
        }catch (IOException e){
            e.printStackTrace();
        }
        //address.set_useThisAddress();

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
