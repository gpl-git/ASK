package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginStepDefs {
    @Given("I open login page")
    public void iOpenLoginPage() {
        getDriver().get("http://ask-qa.portnov.com/#/login");
    }

    @When("I type email {string}")
    public void iTypeEmail(String email) {
        getDriver().findElement(By.xpath("//input[@placeholder='Email *']")).sendKeys(email);
    }

    @And("I type password {string}")
    public void iTypePassword(String password) {
        getDriver().findElement(By.xpath("//input[@placeholder = 'Password *']")).sendKeys(password);
    }

    @And("I click SignIn button")
    public void iClickSignInButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Sign In')]")).click();

    }

    @Then("text {string} is displayed")
    public void textIsDisplayed(String text) throws InterruptedException {
        Thread.sleep(1000);
        String actualText = getDriver().findElement(By.xpath("//*[contains(text(), '" + text + "')]")).getText();
        assertThat(actualText).containsIgnoringCase(text);
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(), '" + text + "')]")).isDisplayed()).isTrue();
    }

    @And("I wait for {int} seconds")
    public void iWaitForSeconds(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @Then("email error message {string} is displayed")
    public void emailErrorMessageIsDisplayed(String message) {
       String emailError= getDriver().findElement(By.xpath("//*[contains(@class,'mat-error')]")).getText();
       assertThat(emailError.equals(message));
    }


    @Then("password error message {string} is displayed")
    public void passwordErrorMessageIsDisplayed(String message) {
       String passError = getDriver().findElement(By.xpath("//div[@class='cdk-overlay-container']")).getText();
       assertThat(passError.contains(message));
    }
}
