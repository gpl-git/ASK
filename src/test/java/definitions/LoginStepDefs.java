package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class LoginStepDefs {
    @Given("I open {string} page")
    public void iOpenPage(String page) {
        if (page.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        }else if (page.equals("registration")){
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        }else {
            System.out.println("Unsupported site");
        }
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(sec*1000);
    }

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click SignIn button")
    public void iClickSignInButton() {
        getDriver().findElement(By.xpath("//*[@type='submit']")).click();
    }

    @Then("text {string} is displayed")
    public void textIsDisplayed(String text) {
        String role = getDriver().findElement(By.xpath("//p[contains(text(),'"+text+"')]")).getText();
        assertThat(role.equals(text)).isTrue();
    }

}
