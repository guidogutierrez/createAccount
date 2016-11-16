package groovy

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserTools {

    WebDriver driver = new FirefoxDriver();

    public void openBrowser(url){


        driver.get(url);


    }

    public void pressButton(button){


        driver.findElement(By.linkText(button)).click();

    }


    public void fillEmailField(id, email){

        driver.findElement(By.id(id)).sendKeys(email);

    }


    public void fillPasswordField(id, password){

        driver.findElement(By.id(id)).sendKeys(password);

    }


    public void submitButton(button){


        driver.findElement(By.name(button)).click();

    }
    public void errorMessage(error){
        if(driver.findElement(By.id(error)).isEnabled()) {

           def message = driver.findElement(By.id(error)).getText();
           if(message == "Email is invalid" || message == "Password is too short (minimum is 6 characters)" || message == "Password can't be blank" || message == "You typed the CAPTCHA words incorrectly. Please try again."){
                System.out.println("Test 1 Pass");
            }

      } else {
         System.out.println("Test 1 Fail");
      }
      driver.close();

    }
}