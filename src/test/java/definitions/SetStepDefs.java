package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class SetStepDefs {
    @Then("name {string} is displayed")
    public void nameIsDisplayed(String name) {
        getDriver().findElement(By.xpath("//h3[contains(text(),'"+name+"')]")).isDisplayed();

    }

    @When("I click Settings menu item")
    public void iClickSettingsMenuItem() {
        getDriver().findElement(By.xpath("//h5[contains(text(),'Settings')]")).click();
    }

    @Then("button Change Your Name is displayed")
    public void buttonChangeYourNameIsDisplayed() {
        getDriver().findElement(By.xpath("//body//button[1]")).isDisplayed();
    }

    @When("I click Change Your Name button")
    public void iClickChangeYourNameButton() {
        getDriver().findElement(By.xpath("//body//button[1]")).click();
    }

    @Then("pop-up box Change Your Name is displayed")
    public void popUpBoxChangeYourNameIsDisplayed() {
        getDriver().findElement(By.xpath("//h1[contains(text(),'Change Your Name')]")).isDisplayed();
    }

    @Then("I clear Full Name input field")
    public void iClearFullNameInputField() {
        getDriver().findElement(By.xpath("//input[@placeholder='Full Name']")).clear();
    }

    @And("I type {string} into Full Name input field")
    public void iTypeIntoFullNameInputField(String newName) {
        getDriver().findElement(By.xpath("//input[@placeholder='Full Name']")).sendKeys(newName);
    }

    @And("I click Change button")
    public void iClickChangeButton() {
        getDriver().findElement(By.xpath("//*[@class='mat-dialog-actions']//button[@class='mat-raised-button mat-primary']")).click();
    }

    @Then("new User's Name {string} is displayed")
    public void newUserSNameIsDisplayed(String newName) {
        String newNametxt =getDriver().findElement(By.xpath("//td[text()='" + newName + "']")).getText();
        assertThat(newNametxt.equals(newName)).isTrue();

    }
}
