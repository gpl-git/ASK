package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.security.Key;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizStepDefs {
    @When("I click {string} link")
    public void iClickLink(String link) {
        getDriver().findElement(By.xpath("//h5[@class='mat-line'][text()='"+link +"']")).click();
    }

    @Then("I click Create New Quiz button")
    public void iClickCreateNewQuizButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Create New Quiz')]")).click();
    }

    @And("enter {string} as quiz title")
    public void enterAsQuizTitle(String title) {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(title);
    }

    @When("I click Add Question Button")
    public void iClickAddQuestionButton() {
        getDriver().findElement(By.xpath("//mat-icon[contains(text(),'add_circle')]")).click();
    }

    @Then("I click {string} button")
    public void iClickButton(String btnName) {
       getDriver().findElement(By.xpath("//*[contains(text(),'"+ btnName + "')]")).click();
    }

    @Then("quiz title error message {string} is displayed")
    public void quizTitleErrorMessageIsDisplayed(String message) {
       assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'"+ message + "'")).isDisplayed()).isTrue();
    }

    @When("I click quiz title field")
    public void iClickQuizTitleField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).click();
    }

    @When("I click space in quiz title field")
    public void iClickSpaceInQuizTitleField() {
        getDriver().findElement(By.xpath("//input[@formcontrolname='name']")).sendKeys(Keys.SPACE);
    }
}
