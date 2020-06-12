package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class TextualQuestionTextStepDefs {
    @And("I open {string} link")
    public void iOpenLink(String menuLink) {
        if (menuLink.equals("Home")){
            getDriver().get("http://ask-qa.portnov.com/#/home");
        }else if (menuLink.equals("Submissions")){
            getDriver().get("http://ask-qa.portnov.com/#/submissions/0");
        }else if (menuLink.equals("Assignments")){
            getDriver().get("http://ask-qa.portnov.com/#/assignments");
        }else if (menuLink.equals("Quizzes")){
            getDriver().get("http://ask-qa.portnov.com/#/quizzes");
        }else if (menuLink.equals("Users management")){
            getDriver().get("http://ask-qa.portnov.com/#/users-management");
        }else if (menuLink.equals("Settings")){
            getDriver().get("http://ask-qa.portnov.com/#/settings");
        }
    }

    @And("I click Create New Quiz button")
    public void iClickCreateNewQuizButton() {
        getDriver().findElement(By.xpath("//*[contains(text(),'Create New Quiz')]")).click();
    }


    @And("I type title of the quiz as {string}")
    public void iTypeTitleOfTheQuizAs(String quizName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(quizName);
    }


    @And("I click add question button")
    public void iClickAddQuestionButton() {
        getDriver().findElement(By.xpath("//mat-icon[@class='mat-icon material-icons']")).click();
    }

    @And("I select Textual radio button")
    public void iSelectTextualRadioButton() {
        getDriver().findElement(By.xpath("//*[contains(text(),'Textual')]")).click();
    }

    @When("I type {string} into Question field")
    public void iTypeIntoQuestionField(String textualQuestion) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='question']")).sendKeys(textualQuestion);
    }

    @And("I click on Save button")
    public void iClickOnSaveButton() {
        getDriver().findElement(By.xpath("//div[@class='form-controls-container ng-star-inserted']//button[2]")).click();
    }

    @Then("I should see quiz {string} in the List of Quizzes")
    public void iShouldSeeQuizInTheListOfQuizzes(String quizName) {
        String nameOfQuiz = getDriver().findElement(By.xpath("//div[@class='quizzes']//*[contains(text(),'"+quizName+"')]")).getText();
        assertThat(nameOfQuiz.equals(quizName)).isTrue();
    }


    @When("I open {string} quiz for preview")
    public void iOpenQuizForPreview(String quizName) {
        getDriver().findElement(By.xpath("//div[@class='quizzes']//*[contains(text(),'"+quizName+"')]")).click();
    }

    @And("I click on preview button")
    public void iClickOnPreviewButton() {
        getDriver().findElement(By.xpath("//div[@class='mat-expansion-panel-content ng-trigger ng-trigger-bodyExpansion mat-expanded']//span[@class='mat-button-wrapper'][contains(text(),'Preview')]")).click();

    }

    @Then("I should see that the quiz {string} contains question {string}")
    public void iShouldSeeThatTheQuizContainsQuestion(String quizName, String textualQuestion) {
        String questionContent=getDriver().findElement(By.xpath("//mat-card[@class='mat-card ng-star-inserted']//h3[contains(text(),'"+textualQuestion+"')]")).getText();
        assertThat(questionContent.equals(textualQuestion)).isTrue();
    }

    @And("I close quiz {string} preview window")
    public void iCloseQuizPreviewWindow(String quizName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Close')]")).click();
    }


    @And("I delete existing quiz {string} by clicking delete button")
    public void iDeleteExistingQuizByClickingDeleteButton(String quizName) {

        getDriver().findElement(By.xpath("//*[contains(text(),'"+quizName+"')]//..//..//..//*[contains(text(),'Delete')]")).click();
    }

    @And("I confirm deletion of quiz {string}")
    public void iConfirmDeletionOfQuiz(String quizName) {
        getDriver().findElement(By.xpath("//button[@class='mat-button mat-warn']/*[contains(text(),'Delete')]")).click();
    }


    @Then("I should not see quiz {string} in the list of quizzes")
    public void iShouldNotSeeQuizInTheListOfQuizzes(String quizName) {

        assertThat(getDriver().findElements(By.xpath("//*[contains(text(),'"+quizName+"')]"))).hasSize(0);
    }


    @Then("I should see error message {string}")
    public void iShouldSeeErrorMessage(String errorMessage) {
        String questionFieldError = getDriver().findElement(By.xpath("//mat-error[@class='mat-error ng-star-inserted'][contains(text(),'"+errorMessage+"')]")).getText();
        assertThat(questionFieldError.contains(errorMessage)).isTrue();

    }

    @When("I clear textual question text field")
    public void iClearTextualQuestionTextField() {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Question *']")).clear();
    }
}
