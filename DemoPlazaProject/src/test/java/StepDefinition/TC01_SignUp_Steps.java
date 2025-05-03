package StepDefinition;
import io.qameta.allure.Step;
import io.qameta.allure.Description;

import Locator.TC01_SignUp;
import Utils.TestData;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TC01_SignUp_Steps {

     WebDriver driver=Hooks.driver;
     TC01_SignUp signUpPage=new TC01_SignUp();
     Faker faker=new Faker();
     WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    @When("User Click on the Sign up button in the Header.")
    public void user_click_on_the_sign_up_button_in_the_header() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpPage.SignUp_Button_Header));
        signUpPage.SignUp_Button_Header.click();
    }
    @When("Fill in the {string} and {string} in the signup form.")
    public void fill_in_the_and_in_the_signup_form(String UserName, String Password) {
        wait.until(ExpectedConditions.visibilityOf(signUpPage.UserName));
        wait.until(ExpectedConditions.visibilityOf(signUpPage.Password));
        TestData.UserName=faker.name().username();
        TestData.Password=faker.internet().password();
        signUpPage.UserName.sendKeys(TestData.UserName);
        signUpPage.Password.sendKeys(TestData.Password);

                              /// Negative Scenarios
       /// Try signing up with an existing username and verify the error message.

       // signUpPage.UserName.sendKeys("username");
       // signUpPage.Password.sendKeys("password");
    }
    @When("Click on the Sign Up button.")
    public void click_on_the_sign_up_button() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpPage.SignUp_Button));
        signUpPage.SignUp_Button.click();
    }
    @Then("A success message should be displayed: {string}")
    public void a_success_message_should_be_displayed(String ExpectedResult) {
        wait.until(ExpectedConditions.alertIsPresent());
        SoftAssert softAssert=new SoftAssert();
        String ActualResult = driver.switchTo().alert().getText();
        softAssert.assertEquals(ActualResult,ExpectedResult ,"Sign-up success message did not match.");
        driver.switchTo().alert().accept();
        System.out.println(ActualResult);
        softAssert.assertAll();

    }
}
