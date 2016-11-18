package pageObjects

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How
import org.openqa.selenium.support.PageFactory;
import org.yaml.snakeyaml.Yaml;

@Singleton(strict = false)
class Account_POF {

    public static final Yaml YAML = new Yaml()

    public static final Object PROPERTIES = YAML.load(new FileInputStream(new File("../TestAccount/src/main/resources/properties.yml")))

    public static final String ENVIRONMENT = System.getProperty('environment', "primus-web")

    public static final String URL = PROPERTIES[ENVIRONMENT]['url']

    def static WebDriver driver;

    @FindBy(how = How.ID, using = "user_email")

    public WebElement txtbx_Email;

    @FindBy(how = How.ID, using = "user_password")

    public WebElement txtbx_Password;

    @FindBy(how = How.ID, using = "recaptcha_response_field")

    public WebElement txtbx_Captcha;

    @FindBy(how = How.NAME, using = "commit")

    public WebElement btn_CreateAccount;

    @FindBy(how = How.LINK_TEXT, using = "Create Account")

    public WebElement btn_Account;

    @FindBy(how = How.ID, using = "flash_error")

    public WebElement error;


    public void openBrowser() {

        String url = URL;

        driver.get(url);

        driver.manage().window().maximize();
    }

     public void closeBrowser(){

         driver.quit();

    }

    public void checkError() {

        if (error.enabled) {

            System.out.println("Test 1 Pass");

        } else {

            System.out.println("Test 1 Fail");

        }

    }

    public Account_POF() {

        System.setProperty("webdriver.chrome.driver", "./chromedriver");

        WebDriver driver = new ChromeDriver();

        PageFactory.initElements(driver, this);

        this.driver = driver;

    }

}
