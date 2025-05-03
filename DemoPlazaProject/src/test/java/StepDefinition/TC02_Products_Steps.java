package StepDefinition;
import io.qameta.allure.Step;
import io.qameta.allure.Description;

import Locator.TC02_Products;
import Utils.TestData;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class TC02_Products_Steps {

    String firstProductName, secondProductName, validateTotal;
    String FirstProductPriceInCard,SecondProductPriceInCard;
    String cartFirstPrice,cartSecondPrice;
    WebDriver driver=Hooks.driver;
    TC02_Products Products=new TC02_Products();
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    Faker faker = new Faker();
    SoftAssert softAssert=new SoftAssert();

    @When("User Click on the Log in button in the Header.")
    public void user_click_on_the_log_in_button_in_the_header() {
        wait.until(ExpectedConditions.elementToBeClickable(Products.LogInHeader()));
        Products.LogInHeader().click();
    }
    @When("Fill in the {string} and {string} in the login form and Click on the Log In button.")
    public void fill_in_the_and_in_the_login_form_and_click_on_the_log_in_button(String UserName, String Password) {
        wait.until(ExpectedConditions.visibilityOf(Products.UserName()));
        Products.UserName().sendKeys(TestData.UserName);
        Products.Password().sendKeys(TestData.Password);
        Products.LogInButton().click();

        ///Attempt to log in with incorrect credentials and verify that an error message isdisplayed.

        //Products.UserName().sendKeys("user+name");
        //Products.Password().sendKeys("Password");
        //Products.LogInButton().click();
        //String message=wait.until(ExpectedConditions.alertIsPresent()).getText();
        //System.out.println(message);


    }
    @Then("The account should open successfully, and the user should be logged in.")
    public void the_account_should_open_successfully_and_the_user_should_be_logged_in() {
        WebElement welcome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nameofuser")));
        Assert.assertTrue("Login failed!", welcome.isDisplayed());
        System.out.println(welcome.getText());
    }
    @Given("User click on Laptops under categories on the homepage")
    public void user_click_on_laptops_under_categories_on_the_homepage() {
        wait.until(ExpectedConditions.elementToBeClickable(Products.selectLaptopCategory()));
        Products.selectLaptopCategory().click();
    }
    @Given("User select Product  Sony vaio i5")
    public void user_select_product_sony_vaio_i5() {
        wait.until(ExpectedConditions.elementToBeClickable(Products.selectFirstProduct()));
        firstProductName = Products.selectFirstProduct().getText();
        FirstProductPriceInCard=Products.FirstProductPrice().getText();
        //System.out.println(FirstProductPriceInCard);
        //System.out.println("First selected product: " + firstProductName);
        Products.selectFirstProduct().click();
    }

    @Given("User click on the Add to Cart button")
    public void user_click_on_the_add_to_cart_button() {
        wait.until(ExpectedConditions.elementToBeClickable(Products.addToCart()));
        Products.addToCart().click();
    }
    @Then("User should see a confirmation message {string}")
    public void user_should_see_a_confirmation_message(String ExpectedResult) {
        wait.until(ExpectedConditions.alertIsPresent());
        String ActualResult=Products.driver.switchTo().alert().getText();
        softAssert.assertTrue(ActualResult.contains(ExpectedResult), "Alert message does not match");
        Products.driver.switchTo().alert().accept();
        System.out.println(ActualResult);
        softAssert.assertAll();
        Products.BackHome().click();
    }
    @When("User click on Laptops under categories on the homepage again")
    public void user_click_on_laptops_under_categories_on_the_homepage_again() {
        wait.until(ExpectedConditions.elementToBeClickable(Products.selectLaptopCategory()));
        Products.selectLaptopCategory().click();
    }
    @When("User select Product  MacBook air")
    public void user_select_product_mac_book_air() {
        wait.until(ExpectedConditions.elementToBeClickable(Products.selectSecondProduct()));
        secondProductName = Products.selectSecondProduct().getText();
        SecondProductPriceInCard=Products.SecondProductPrice().getText();
        // System.out.println(SecondProductPriceInCard);
        //System.out.println("Second selected product: " + secondProductName);
        Products.selectSecondProduct().click();
    }

    @Then("User click on the Add second to Cart button and see a confirmation message {string}")
    public void user_click_on_the_add_second_to_cart_button_and_see_a_confirmation_message(String ExpectedResult) {
        wait.until(ExpectedConditions.elementToBeClickable(Products.addToCart2()));
        Products.addToCart2().click();
        wait.until(ExpectedConditions.alertIsPresent());
        String ActualResult=Products.driver.switchTo().alert().getText();
        softAssert.assertTrue(ActualResult.contains(ExpectedResult), "Alert message does not match");
        Products.driver.switchTo().alert().accept();
        System.out.println(ActualResult);
        softAssert.assertAll();
    }
    @Given("User click on the cart button in the header")
    public void user_click_on_the_cart_button_in_the_header() {
        wait.until(ExpectedConditions.elementToBeClickable(Products.cartButton()));
        Products.cartButton().click();
    }
    @Then("User should see both products {string} and {string} in the cart with their respective {string} and {string}")
    public void user_should_see_both_products_and_in_the_cart_with_their_respective_and(String expectedFirstName, String expectedSecondName, String expectedSecondPrice, String expectedFirstPrice) {
        wait.until(ExpectedConditions.visibilityOfAllElements(Products.cardProduct()));

        String cartFirstName = Products.FirstProductInCard().getText();
        String cartSecondName = Products.SecondProductInCard().getText();
        cartFirstPrice = Products.FirstProductPriceInCard().getText();
        cartSecondPrice = Products.SecondProductPriceInCard().getText();


        System.out.println("Cart First Product: " + cartFirstName);
        System.out.println("Cart Second Product: " + cartSecondName);

        Assert.assertEquals("First product name mismatch!", firstProductName, cartFirstName);
        Assert.assertEquals("Second product name mismatch!", secondProductName, cartSecondName);

        Assert.assertTrue("First product price mismatch!", FirstProductPriceInCard.contains(cartFirstPrice));
        Assert.assertTrue("Second product price mismatch!", SecondProductPriceInCard.contains(cartSecondPrice));
    }
    @Given("User validate the total amount displayed in the cart")
    public void user_validate_the_total_amount_displayed_in_the_cart() {
        validateTotal=Products.validateTotal().getText();
        //System.out.println(validateTotal);
        org.testng.Assert.assertFalse(validateTotal.isEmpty(), "The total amount displayed is empty.");
    }
    @Then("The total amount should be calculated correctly based on the prices of both products")
    public void the_total_amount_should_be_calculated_correctly_based_on_the_prices_of_both_products() {
        int p1 = Integer.parseInt(cartFirstPrice);
        int p2 = Integer.parseInt(cartSecondPrice);
        int actualTotal = Integer.parseInt(validateTotal);
        int expectedTotal = p1 + p2;
        Assert.assertEquals("Total cart price mismatch!", expectedTotal, actualTotal);
        System.out.println("Total amount : " + actualTotal);
    }
    @Given("User click on the Place Order button")
    public void user_click_on_the_place_order_button() {
        Products.placeOrderButton().click();
    }
    @When("User fill in my purchase details:")
    public void user_fill_in_my_purchase_details() {
        wait.until(ExpectedConditions.visibilityOf(Products.Name()));

        TestData.Name = faker.name().fullName();
        Products.Name().sendKeys(TestData.Name);

        TestData.Country = faker.country().name();
        Products.Country().sendKeys(TestData.Country);

        TestData.City = faker.address().city();
        Products.City().sendKeys(TestData.City);

        TestData.CreditCard = faker.finance().creditCard();
        Products.CreditCard().sendKeys(TestData.CreditCard);

        TestData.Month = String.valueOf(faker.number().numberBetween(1, 12));
        Products.Month().sendKeys(TestData.Month);

        TestData.Year = String.valueOf(faker.number().numberBetween(2025, 2035));
        Products.Year().sendKeys(TestData.Year);

                                  /// Negative Scenario
        /// Attempt to purchase with an expired credit card and verify the error message.

        //Products.Year().sendKeys("2020");

    }
    @When("User click on the purchase button")
    public void user_click_on_the_purchase_button() {
        Products.PurchaseButton().click();
    }
    @Then("User should see a success message {string}")
    public void user_should_see_a_success_message(String message) {
        wait.until(ExpectedConditions.visibilityOf(Products.orderSuccessMessage()));
        String actualMessage = Products.orderSuccessMessage().getText();
        org.testng.Assert.assertEquals(actualMessage, message, "Success message does not match!");
        System.out.println(actualMessage);

                                 /// Negative Scenario
        /// Attempt to purchase with an expired credit card and verify the error message.

        //wait.until(ExpectedConditions.visibilityOf(Products.orderSuccessMessage()));
        //String actualMessage = Products.orderSuccessMessage().getText();
        //message="error message";
        //org.testng.Assert.assertEquals(actualMessage, message, "Success message does not match!");
        //System.out.println(actualMessage);

    }

}
