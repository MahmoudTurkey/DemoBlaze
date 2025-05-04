package StepDefinition;
import io.qameta.allure.Step;
import io.qameta.allure.Description;

import Locator.TC02_Products;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static StepDefinition.Hooks.driver;
import static org.junit.Assert.assertEquals;

public class TC03_TheSameProduct {

    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("the user is on the Demoblaze homepage")
    public void the_user_is_on_the_demoblaze_homepage() {
        driver.get("https://www.demoblaze.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nava"))); // Waits for the navbar logo
    }

    @When("the user adds {string} to the cart twice")
    public void addSameProductTwice(String productName) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(By.linkText(productName))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Add to cart']"))).click();
            wait.until(ExpectedConditions.alertIsPresent());
            driver.switchTo().alert().accept();
            driver.navigate().to("https://www.demoblaze.com"); // back to homepage
        }
    }

    @And("navigates to the cart page")
    public void goToCartPage() {
        driver.findElement(By.id("cartur")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbodyid")));
    }

    @Then("the cart should contain 1 entries for {string}")
    public void verifyTwoEntriesInCart(String productName) {
        List<WebElement> items = driver.findElements(By.xpath("//td[text()='" + productName + "']"));
        assertEquals("Expected 1 instances of product: " + productName, 1, items.size());
    }

}
