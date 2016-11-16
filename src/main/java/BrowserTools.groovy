import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

/**
 * Created by gag on 16/11/16.
 */
class BrowserTools {

    WebDriver driver = new FirefoxDriver();

    public void openBrowser(url){


        driver.get(url);



    }



}
