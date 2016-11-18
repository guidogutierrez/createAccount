package StepDefs

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.PageFactory
import pageObjects.Account_POF

this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

url="http://account-regression-1567302699.us-east-1.elb.amazonaws.com/";

System.setProperty("webdriver.chrome.driver", "./chromedriver");
WebDriver driver = new ChromeDriver();

Account_POF Page = PageFactory.initElements(driver, Account_POF.class);


Given(~"I navigate to main page"){ ->

    Page.openBrowser(url);
}


Given(~"I click on create account button"){ ->

    Page.btn_Account.click();

}


Given(~"I send an empty email and a valid password"){ ->

    Page.txtbx_Email.sendKeys(" ");
    Page.txtbx_Password.sendKeys("123456");

}


Given(~"I send a wrong email and a valid password"){ ->

    Page.txtbx_Email.sendKeys("qaaa ");
    Page.txtbx_Password.sendKeys("123456");

}



Given(~"I send an valid email but with an empty password"){ ->

    Page.txtbx_Email.sendKeys("qa@qa.com");
    Page.txtbx_Password.sendKeys(" ");

}


Given(~"I send an valid email but with a shorter password"){ ->

    Page.txtbx_Email.sendKeys("qa@qa.com");
    Page.txtbx_Password.sendKeys("12345");

}


Given(~"I send an valid email and password but with wrong captcha"){ ->

    Page.txtbx_Email.sendKeys("qa@qa.com");
    Page.txtbx_Password.sendKeys("123456");
    Page.txtbx_Captcha.sendKeys("koadasas");

}


When (~"I submit the user"){ ->

    Page.btn_CreateAccount.click();

}


Then(~"I get an error message"){ ->

    Page.checkError();

}


