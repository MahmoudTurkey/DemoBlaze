package Locator;

import StepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TC01_SignUp {
    public WebDriver driver=Hooks.driver;
    public WebElement SignUp_Button_Header=driver.findElement(By.xpath("//a[text()='Sign up']"));
    public WebElement UserName=driver.findElement(By.id("sign-username"));
    public WebElement Password=driver.findElement(By.id("sign-password"));
    public WebElement SignUp_Button=driver.findElement(By.xpath("//button[text()='Sign up']"));
}
