package definitions;

import com.google.inject.spi.Message;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;
import org.testng.Assert;

public class QuiztitleStepdefs {
    @Then("I click Quizzes button")
    public void iClickQuizzesButton() {
        getDriver().findElement(By.xpath("//*[contains(text(),'Quizzes')]")).click();


    }

    @Then("I click Create new Quiz  button")
    public void iClickCreateNewQuizButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
    }

    @Then("I Type {string} into input")
    public void iTypeIntoInput(String input) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(input);
    }

    @And("I click on Add Question button")
    public void iClickOnAddQuestionButton() {
        getDriver().findElement(By.xpath("//mat-icon[@class='mat-icon material-icons']")).click();
    }

    @Then("I click on Title of the quiz button")
    public void iClickOnTitleOfTheQuizButton() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).click();
    }


    @And("I should see message {string}")
    public void iShouldSeeMessage(String message) {
       String ErrorMessage = getDriver().findElement(By.xpath("//mat-error[@class='mat-error ng-star-inserted'] [contains(text(),'"+ message +"')]")).getText();
       assertThat(ErrorMessage.contains(message)).isTrue();
    }
}