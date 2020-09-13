package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pages.Home;
import pages.Quiz;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class QuizStepDefs {
    @And("I go to Quizzes")
    public void iGoToQuizzes() {
        new Home().goToQuiz();
    }

    @And("I go to {string}")
    public void iGoTo(String option) {
        new Home().selectTeacherOption(option);
    }

    @And("I create a quiz")
    public void iCreateAQuiz() {
        Quiz quiz = new Quiz();
        quiz.createNewQuiz();
    }


    @When("I provide {string} as the title")
    public void iProvideAsTheTitle(String title) {
        new Quiz().enterQuizTitle(title);
    }

    @Then("I validate quiz title error message is not displayed")
    public void iValidateQuizTitleErrorMessageIsNotDisplayed() {
        Quiz quiz = new Quiz();
        assertThat(quiz.isTitleErrorMessageDisplayed()).isFalse();
    }

    @When("I clean title field")
    public void iCleanTitleField() {
        new Quiz().clearTitleField();
    }

    //    @Then ("I validate quiz title error message is displayed") 
//    public void iValidateQuizTitleErrorMessageIsDisplayed(){ 
//        Quiz quiz = new Quiz(); //
//        assertThat(quiz.isTitleErrorMessageDisplayed()).isTrue(); //
//        assertThat(quiz.getTitleErrorMessage().equals("This field is required")); //    }  
    @And("I add a textual question")
    public void iAddATextualQuestion() {
        Quiz quiz = new Quiz();
        quiz.addQuestionTextual("Test");
    }

    @Then("I set and verify points possible equal to {int}")
    public void iSetAndVerifyPointsPossibleEqualTo(int points) {
        Quiz quiz = new Quiz();
        quiz.setPointsPossible(points);
        System.out.println("points: " + getDriver().findElement(By.xpath("//h2")).getText());
        System.out.println("new points: " + quiz.getPointsPossible());
    }

    @And("I delete the question")
    public void iDeleteTheQuestion() {
        Quiz quiz = new Quiz();
        quiz.deleteQuestion();
        quiz.confirmDelete();
    }

    @Then("I validate quiz title error message {string} is displayed")
    public void iValidateQuizTitleErrorMessageIsDisplayed(String errMessage) {
        Quiz quiz = new Quiz();
        assertThat(quiz.isTitleErrorMessageDisplayed()).isTrue();
        assertThat(quiz.getTitleErrorMessage().equals(errMessage));
    }

    @Then("I verify that error message is not displayed")
    public void iVerifyThatErrorMessageIsNotDisplayed() {
        Quiz quiz = new Quiz();
        assertThat(quiz.isErrorPresent()).isFalse();
    }

    @And("I select question type as {string}")
    public void iSelectQuestionTypeAs(String type) {
        new Quiz().selectQuestionType(type);
    }

    @And("I add a question")
    public void iAddAQuestion() {
        new Quiz().addQuestion();
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(1000*sec);
    }
}
