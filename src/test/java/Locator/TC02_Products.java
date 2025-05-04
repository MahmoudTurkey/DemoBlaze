package Locator;

import StepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class TC02_Products {
    public WebDriver driver= Hooks.driver;
    public WebElement LogInHeader(){return driver.findElement(By.xpath("//a[text()='Log in']"));}
    public WebElement UserName(){return driver.findElement(By.id("loginusername"));}
    public WebElement Password(){return driver.findElement(By.id("loginpassword"));}
    public WebElement LogInButton(){return driver.findElement(By.xpath("//button[text()='Log in']"));}
    public WebElement selectLaptopCategory(){return driver.findElement(By.xpath("//a[text()='Laptops']"));}
    public WebElement selectFirstProduct(){return driver.findElement(By.xpath("//a[text()='Sony vaio i5']"));}
    public WebElement FirstProductPrice(){return driver.findElement(By.xpath("//h5[text()='$790']"));}
    public WebElement addToCart(){return driver.findElement(By.xpath("//a[contains(@onclick, 'addToCart(8)')]"));}
    public WebElement BackHome(){return driver.findElement(By.id("nava"));}
    public WebElement selectSecondProduct(){return driver.findElement(By.xpath("//a[text()='MacBook air']"));}
    public WebElement SecondProductPrice(){return driver.findElement(By.xpath("//h5[text()='$700']"));}
    public WebElement addToCart2(){return driver.findElement(By.xpath("//a[contains(@onclick, 'addToCart(11)')]"));}
    public WebElement cartButton(){return driver.findElement(By.xpath("//*[@id=\"navbarExample\"]/ul/li[4]/a"));}
    public List<WebElement> cardProduct(){return driver.findElements(By.xpath("//*[@id='tbodyid']/tr"));}
    public WebElement SecondProductInCard(){return driver.findElement(By.xpath("//*[@id='tbodyid']//td[text()='MacBook air']"));}
    public WebElement FirstProductInCard(){return driver.findElement(By.xpath("//*[@id='tbodyid']//td[text()='Sony vaio i5']"));}
    public WebElement SecondProductPriceInCard(){return driver.findElement(By.xpath("//*[@id='tbodyid']//td[text()='700']"));}
    public WebElement FirstProductPriceInCard(){return driver.findElement(By.xpath("//*[@id='tbodyid']//td[text()='790']"));}
    public WebElement validateTotal(){return driver.findElement(By.xpath("//*[@id=\"totalp\"]"));}
    public WebElement placeOrderButton(){return driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div/div[2]/button"));}
    public WebElement Name() {
        return driver.findElement(By.id("name"));
    }
    public WebElement Country() {
        return driver.findElement(By.id("country"));
    }
    public WebElement City() {
        return driver.findElement(By.id("city"));
    }
    public WebElement CreditCard() {
        return driver.findElement(By.id("card"));
    }
    public WebElement Month() {
        return driver.findElement(By.id("month"));
    }
    public WebElement Year() {
        return driver.findElement(By.id("year"));
    }
    public WebElement PurchaseButton(){return driver.findElement(By.xpath("//*[@id=\"orderModal\"]/div/div/div[3]/button[2]"));}
    public WebElement orderSuccessMessage(){return  driver.findElement(By.xpath("//h2[text()='Thank you for your purchase!']"));}
}
