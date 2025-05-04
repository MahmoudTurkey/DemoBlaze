package StepDefinition;
import io.qameta.allure.Step;
import io.qameta.allure.Description;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Hooks {
    public static WebDriver driver;

    @Before
    public static void Browser(){
        String BrowserName="edge";
        if (BrowserName.contains("firfox")){
            driver=new FirefoxDriver();
        }else if (BrowserName.contains("chrome")){
            driver=new ChromeDriver();
        }else if (BrowserName.contains("edge")){
            driver=new ChromeDriver();
        }else {driver=new ChromeDriver();}

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/index.html");
    }
    @After
public void quit()throws InterruptedException{
        if (driver!=null){
            driver.quit();
        }
    }
}
