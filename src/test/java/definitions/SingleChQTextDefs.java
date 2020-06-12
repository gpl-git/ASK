package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.Th;
import org.openqa.selenium.By;


import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class SingleChQTextDefs {

    @When("I navigate to Quizzes page")
    public void iNavigateToQuizzesPage() throws InterruptedException {
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//*[@href='/#/quizzes']")).click();
        Thread.sleep(1000);
    }

    @And("I push Create New Quiz button")
    public void pushCreateNewQuizButton() {
        getDriver().findElement(By.xpath("//*[@href='#/quiz-builder']")).click();
    }

    @And("I enter Quiz name {string}")
    public void iEnterQuizName(String quizName) throws InterruptedException {
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//input[@placeholder='Title Of The Quiz *']")).sendKeys(quizName);
    }

    @And("I select Single-Choice question type for Q1: new empty question")
    public void iSelectSingleChoiceQuestionTypeForQNewEmptyQuestion() throws InterruptedException {
        getDriver().findElement(By.xpath("//*[text()[contains(.,'Add Question')]]/../.")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//*[text()[contains(.,'Single-Choice')]]/../..")).click();
    }

    @When("I enter {string} into the Q1 question field")
    public void iEnterIntoTheQQuestionField(String questionText) throws InterruptedException {
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).click();
        getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']")).sendKeys(questionText);
    }

    @And("I fill out Option 1 field with {string}")
    public void iFillOutOption1FieldWith(String option1Text) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']")).sendKeys(option1Text);
    }

    @And("I fill out Option 2 field with {string}")
    public void iFillOutOption2FieldWith(String option2Text) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 2*']")).sendKeys(option2Text);
    }

    @And("I select Option 1 as right answer")
    public void iSelectOptionAsRightAnswer() {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']/../../../../../mat-radio-button")).click();
    }

    @And("I push Quiz Save button")
    public void iPushQuizSaveButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]/..")).click();
    }

    @Then("I find created Quiz {string} in the List of Quizzes")
    public void iFindCreatedQuizInTheListOfQuizzes(String quizName) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizName + "')]")).isDisplayed()).isTrue();
    }

    @And("I verify that Q1 of the Quiz {string} equals to {string}")
    public void iVerifyThatQOfTheQuizEqualsTo(String quizName, String questionText) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + quizName + "')]/..")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("(//mat-panel-title[contains(text(),'" + quizName + "')]/../../..//button)[1]")).click();
        String text = getDriver().findElement(By.xpath("//h5[contains(text(),'Question 1')]/../h3")).getText();
        assertThat(text).isEqualTo(questionText);
    }


    @And("I delete the quiz {string}")
    public void iDeleteTheQuiz(String quizName) throws InterruptedException {
        getDriver().findElement(By.xpath("//button[@aria-label='Close dialog']")).click();
        getDriver().findElement(By.xpath("(//mat-panel-title[contains(text(),'" + quizName + "')]/../../..//button)[3]")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("//ac-modal-confirmation[@class='ng-star-inserted']//button[@class='mat-button mat-warn']")).click();
    }

    @Then("I verify that question error message {string} appears")
    public void iVerifyThatQuestionErrorMessageErrorTextAppears(String errorText) {
        String text = getDriver().findElement(By.xpath("//textarea[@formcontrolname='question']/../../..//mat-error")).getText();
        assertThat(text.equals(errorText)).isTrue();
    }

    @And("I verify that option 2 of the Q1 of the Quiz {string} equals to {string}")
    public void iVerifyThatOptionOfTheQOfTheQuizEqualsTo(String quizName, String option1Text) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + quizName + "')]/..")).click();
        Thread.sleep(1000);
        getDriver().findElement(By.xpath("(//mat-panel-title[contains(text(),'" + quizName + "')]/../../..//button)[1]")).click();
        String radioBtnContent = getDriver().findElement(By.xpath("(//mat-radio-button)[2]")).getText();
        System.out.println(radioBtnContent);
        assertThat(radioBtnContent).isEqualTo(option1Text);

    }

    @And("I select Option 2 as right answer")
    public void iSelectOption2AsRightAnswer() {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 2*']/../../../../../mat-radio-button")).click();

    }

    @Then("I verify that option error message {string} appears")
    public void iVerifyThatOptionErrorMessageErrorTextAppears(String errorText) {
        String text = getDriver().findElement(By.xpath("//textarea[@placeholder='Option 2*']/../../..//mat-error")).getText();
        assertThat(text.equals(errorText)).isTrue();
    }

}