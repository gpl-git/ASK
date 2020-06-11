package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.setRemoveAssertJRelatedElementsFromStackTrace;
import static support.TestContext.getDriver;

public class RegistrationStepDefsIrina {

    @When("I type {string} into First Name field")
    public void iTypeIntoFirstnameField(String firstName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys(firstName);

    }

    @And("I type {string} into Last Name field")
    public void iTypeIntoLastnameField(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys(lastName);

    }

    @And("I type {string} into group code field")
    public void iTypeIntoGroupCodeField(String groupcode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys(groupcode);
    }

    @And("I type {string} into confirm password field")
    public void iTypeIntoConfirmPasswordField(String confirmpassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys(confirmpassword);

    }

    @Then("I click {string} button")
    public void iClickButton(String button) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();
    }

    @Then("text {string} displayed")
    public void textDisplayed(String verificationmessage) {
        String message=getDriver().findElement(By.xpath("//h4[contains(text(),'You have been Registered.')]")).getText();
       assertThat(message.equals(verificationmessage)).isTrue();

    }

    @When("I do not type {string} into First Name field")
    public void iDoNotTypeIntoFirstNameField(String firstNameFieldclen) {
        ////*[contains(text(),'This field is required')]
        // //*[contains(text(),'mat-error')]
        String acctualError=getDriver().findElement(By.xpath("//*[contains(text(),'This field is required')]")).getText();
        String expected_error="This field is required";
        Assert.assertEquals(acctualError, expected_error);
        System.out.println("Test is completed");
        }

    @Then("error message {string} displayed")
    public void errorMessageDisplayed(String errormessage) {
        String message = getDriver().findElement(By.xpath("//mat-error[contains(text(),'Whitespaces are not allowed')]")).getText();
        assertThat(message.equals(errormessage)).isTrue();
    }
}



