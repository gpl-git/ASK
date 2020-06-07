package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class TextualQuestionStepDefs {
    @And("I enter {string} as question title")
    public void iEnterAsQuestionTitle(String questionTitle) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='question']")).sendKeys(questionTitle);
        String questionText= getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]")).getText();
        assertThat(questionText.contains(questionTitle));
    }


    @When("I select question type {string}")
    public void iSelectQuestionType(String questionType) {
        getDriver().findElement(By.xpath("//div[contains(text(),'" + questionType + "')]")).click();
    }

    @And("I click space in question title field")
    public void iClickSpaceInQuestionTitleField() {
        getDriver().findElement(By.xpath("//*[@formcontrolname='question']")).sendKeys(Keys.SPACE);
    }

    @When("I clear the question title field")
    public void iClearTheQuestionTitleField() {
        getDriver().findElement(By.xpath("//*[@formcontrolname='question']")).clear();
        getDriver().findElement(By.xpath("//*[@formcontrolname='question']")).sendKeys(Keys.DELETE);
        getDriver().findElement(By.xpath("/html")).click();

//        getDriver().findElement(By.xpath("//*[@formcontrolname='question']")).click();

    }

    @Then("question title error message {string} is displayed")
    public void questionTitleErrorMessageIsDisplayed(String message) {
       String errorMessage = getDriver().findElement(By.xpath("//mat-error[contains(text(),'" + message + "')]")).getText();
        assertThat(errorMessage.equals(message));
    }

    @When("I verify {string} selected")
    public void iVerifySelected(String text) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+text+"')]")).click();
        String panelTitle = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]")).getText();
        assertThat(panelTitle.contains("Q1*:"));
    }

    @Then("I verify {string} is displayed  on panel title")
    public void iVerifyIsDisplayedOnPanelTitle(String text) {
        String panelTitle = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'Q1')]")).getText();
        assertThat(panelTitle.contains(text));
    }
}

