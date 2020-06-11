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
}
