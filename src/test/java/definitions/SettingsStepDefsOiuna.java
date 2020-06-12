package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class SettingsStepDefsOiuna {
    @Then("name {string} is displayed")
    public void nameIsDisplayed(String name) {
        String nametxt = getDriver().findElement(By.xpath("//h3[contains(text(),'"+name+"')]")).getText();
        assertThat(nametxt.equals(name)).isTrue();

    }


    @When("I click Change Your Name button")
    public void iClickChangeYourNameButton() {
        getDriver().findElement(By.xpath("//body//button[1]")).click();
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

    @When("I click {string} menu item")
    public void iClickMenuItem(String item) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+item+"')]")).click();

    }


    @When("I click Change Your Password button")
    public void iClickChangeYourPasswordButton() {
        getDriver().findElement(By.xpath("//body//button[2]")).click();
    }

    @When("I type {string} into Password input field")
    public void iTypeIntoPasswordInputField(String password) {
        getDriver().findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
    }

    @And("I type {string} into New Password field")
    public void iTypeIntoNewPasswordField(String newPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='New Password']")).sendKeys(newPassword);
    }

    @And("I type {string} into Confirm New Password field")
    public void iTypeIntoConfirmNewPasswordField(String newPassword) {
        getDriver().findElement(By.xpath("//input[@placeholder='Confirm New Password']")).sendKeys(newPassword);
    }


    @When("I click on Log out button")
    public void iClickOnLogOutButton() {
        getDriver().findElement(By.xpath("//button[@class='mat-button mat-warn']")).click();
    }





    @Then("{string} pop-up box is displayed")
    public void popUpBoxIsDisplayed(String txt) {
        String boxtitle = getDriver().findElement(By.xpath("//*[contains(text(),'"+txt+"')]")).getText();
        assertThat(boxtitle.equals(txt)).isTrue();
    }

    @Then("{string} page is displayed")
    public void pageIsDisplayed(String txt) {
        String pagetitle = getDriver().findElement(By.xpath("//*[contains(text(),'"+txt+"')]")).getText();
        assertThat(pagetitle.equals(txt)).isTrue();
    }
}
