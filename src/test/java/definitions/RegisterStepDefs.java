package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Register;

import java.awt.*;

import static support.TestContext.getDriver;

public class RegisterStepDefs {
    @And("I fill out the registration form")
    public void iFillOutTheRegistrationForm() throws AWTException, InterruptedException {
        new Register().fillOutRegistrationForm("Ann", "Smith", "345", "12345");
    }

    @Then("I verify that registration is complete")
    public void iVerifyThatRegistrationIsComplete() {
        new Register().confirmRegistration();
    }

    @When("I type {string} into first name field")
    public void iTypeIntoFirstNameField(String firstName) {
        new Register().fillOutFirstName(firstName);
    }

    @And("I type {string} into last name field")
    public void iTypeIntoLastNameField(String lastName) {
        new Register().fillOutLastName(lastName);
    }

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String email) {
        new Register().fillOutEmail(email);
    }

    @And("I type {string} into group code field")
    public void iTypeIntoGroupCodeField(String group) {
        new Register().fillOutGroupCode(group);
    }

    @When("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        new Register().fillOutPassword(password);
    }

    @And("I type {string} into  confirm password field")
    public void iTypeIntoConfirmPasswordField(String password) {
        new Register().fillOutConfirmPassword(password);
    }



    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String message) {
        new Register().checkError(message);

    }

    @When("I submit registration form")
    public void iSubmitRegistrationForm() {
        new Register().clickRegisterBtn();
    }
}
