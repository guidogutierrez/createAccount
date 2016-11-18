package pageObjects

/**
 * Created by gag on 17/11/16.
 */

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.How;

class Account_POF {

    final WebDriver driver;

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


    public void checkError() {

        if (error.enabled) {

            System.out.println("Test 1 Pass");


        } else {

            System.out.println("Test 1 Fail");

        }

    }

    public Account_POF(WebDriver driver) {

        this.driver = driver;

    }

}
