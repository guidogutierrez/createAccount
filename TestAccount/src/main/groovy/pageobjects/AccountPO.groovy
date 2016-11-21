package pageobjects

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How
import org.openqa.selenium.support.PageFactory;
import org.yaml.snakeyaml.Yaml;

class AccountPO {

    public static final Yaml YAML = new Yaml()

    public static final Object PROPERTIES = YAML.load(new FileInputStream(new File("../TestAccount/src/main/resources/properties.yml")))

    public static final String ENVIRONMENT = System.getProperty('environment', "primus-web")

    public static final String URL = PROPERTIES[ENVIRONMENT]['url']

    def static WebDriver driver;

    @FindBy(how = How.ID, using = "user_email")

    public WebElement txtbxEmail;

    @FindBy(how = How.ID, using = "user_password")

    public WebElement txtbxPassword;

    @FindBy(how = How.ID, using = "recaptcha_response_field")

    public WebElement txtbxCaptcha;

    @FindBy(how = How.NAME, using = "commit")

    public WebElement btnCreateAccount;

    @FindBy(how = How.LINK_TEXT, using = "Create Account")

    public WebElement btnAccount;

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

    public void setEmail(email){

        txtbxEmail.sendKeys(email);

    }

    public void setPassword(password){

        txtbxPassword.sendKeys(password);

    }

    public void clickCreateAccount(){

        btnAccount.click();
    }

    public void submitUser(){

        btnCreateAccount.click();

    }

    public void setCaptcha(captcha){

        txtbxCaptcha.sendKeys(captcha);

    }

    public String getErrorMessage() {
        if (error.enabled) {
            return error.getText();
        } else {
            return ""
        }
    }

    public AccountPO() {

        System.setProperty("webdriver.chrome.driver", "./chromedriver");

        WebDriver driver = new ChromeDriver();

        PageFactory.initElements(driver, this);

        this.driver = driver;

    }

}
