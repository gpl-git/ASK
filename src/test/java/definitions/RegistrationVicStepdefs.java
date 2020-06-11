package definitions;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class RegistrationVicStepdefs {
    @Then("registration message {string} is displayed")
    public void registrationMessageIsDisplayed(String message) {
        String confirmationMessage = getDriver().findElement(By.xpath("//h4[contains(text(),'"+message+"')]")).getText();
        assertThat(confirmationMessage.equals(message)).isTrue();
    }

    @Then("message {string} is displayed")
    public void messageIsDisplayed(String errormessage) {
        String requiredFieldMessage = getDriver().findElement(By.xpath("//mat-error[@class='mat-error ng-star-inserted'][contains(text(),'"+errormessage+"')]")).getText();
        String moreThan10CharMessage = getDriver().findElement(By.xpath("//mat-error[contains(text(),'"+errormessage+"')]")).getText();
        if (errormessage.equalsIgnoreCase(requiredFieldMessage)) {
        } else if (errormessage.equalsIgnoreCase(moreThan10CharMessage));

    }

    @Then("password error message {string} is displayed")
    public void passwordErrorMessageIsDisplayed(String passworderrormessage) {
        String messagerequiredfield = getDriver().findElement(By.xpath("//div[@class='ng-tns-c9-6 ng-trigger ng-trigger-transitionMessages ng-star-inserted']//mat-error[@class='mat-error ng-star-inserted'][contains(text(),'"+passworderrormessage+"')]")).getText();
        assertThat(messagerequiredfield.equals(passworderrormessage)).isTrue();

        String messageshouldbemore5 = getDriver().findElement(By.xpath("//div[@class='ng-tns-c9-6 ng-trigger ng-trigger-transitionMessages ng-star-inserted']//mat-error[@class='mat-error ng-star-inserted'][contains(text(),'"+passworderrormessage+"')]")).getText();
        assertThat(messageshouldbemore5.equals(passworderrormessage)).isTrue();



    }
}

