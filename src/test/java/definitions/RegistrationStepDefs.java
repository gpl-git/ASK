package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RegistrationStepDefs {
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String page) {
        if (page.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }
        else if (page.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else
            System.out.println("Page is not supported");
        }

    @When("I type first name {string}")
    public void iTypeFirstName(String firstName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='firstName']")).sendKeys(firstName);
    }

    @And("I type last name {string}")
    public void iTypeLastName(String lastName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='lastName']")).sendKeys(lastName);
    }

    @And("I type group code {string}")
    public void iTypeGroupCode(String groupCode) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='group']")).sendKeys(groupCode);

    }

    @And("I type email {string} at registration")
    public void iTypeEmailAtRegistration(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type password {string} at registration")
    public void iTypePasswordAtRegistration(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @And("I type confirm password {string}")
    public void iTypeConfirmPassword(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='confirmPassword']")).sendKeys(password);
    }

    @And("I click Register Me button")
    public void iClickRegisterMeButton() {
        getDriver().findElement(By.xpath("//button[@type = 'submit']")).click();
    }

    @Then("message {string} should be displayed")
    public void messageShouldBeDisplayed(String message) {
        String confirmation = getDriver().findElement(By.xpath("//mat-card/h4")).getText();
        assertThat(confirmation.equals(message));
    }

    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String error) {
        String errorMessage = getDriver().findElement(By.xpath("//mat-error[@role='alert']")).getText();
        assertThat(errorMessage.equals(error));
    }
}
