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
        getDriver().findElement(By.xpath("//input[@formcontrolname='firstName']")).sendKeys("abc");

    }

    @And("I type {string} into Last Name field")
    public void iTypeIntoLastnameField(String lastName) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys("I");

    }

    @And("I type {string} into group code field")
    public void iTypeIntoGroupCodeField(String groupcode) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='group']")).sendKeys("123");
    }

    @And("I type {string} into confirm password field")
    public void iTypeIntoConfirmPasswordField(String confirmpassword) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys("12344");

    }

    @Then("I click {string} button")
    public void iClickButton(String button) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Register Me')]")).click();
    }

    @Then("text {string} displayed")
    public void textDisplayed(String verificationmessage) {
        String message=getDriver().findElement(By.xpath("//*[contains(text(),' 1.')]")).getText();
        System.out.println("Message is displayed " + verificationmessage);

    }

    @When("I do not type {string} into First Name field")
    public void iDoNotTypeIntoFirstNameField(String firstNameFieldclen) {
        ////*[contains(text(),'This field is required')]
        // //*[contains(text(),'mat-error')]
        String acctualError=getDriver().findElement(By.xpath("//*[contains(text(),'This field is required')]")).getText();
        String expected_error="This field is required";
        Assert.assertEquals(acctualError, expected_error);
        }
    }



