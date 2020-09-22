package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.Quiz;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MultipleChoiceStepDefs {
    @Then("I check checkbox {string} as correct answer in question {string}")
    public void iCheckCheckboxAsCorrectAnswerInQuestion(String option, String question) {
        new Quiz().checkCheckBoxCorrectOption(option,question);

    }

    @Then("choice error message {string} should be displayed")
    public void choiceErrorMessageShouldBeDisplayed(String message) {
        assertThat(new Quiz().getChoiceError().equals(message)).isTrue();
    }

    @And("I select {string} from the list of Assignments")
    public void iSelectFromTheListOfAssignments(String quiz) {

        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        WebElement titles = getDriver().findElement(By.xpath("//span[contains(text(),'Select Quiz To Assign')]/.."));
        executor.executeScript("arguments[0].click()", titles);

        WebElement item = getDriver().findElement(By.xpath("//*[contains(text(),'" + quiz + "')]/.."));
        executor.executeScript("arguments[0].click()", item);
    }
}
