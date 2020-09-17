package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TeacherHome;
import pages.Quiz;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class QuizStepDefs {
//    @And("I go to Quizzes")
//    public void iGoToQuizzes() {
//        new Home().goToQuiz();
//    }

//    @And("I go to {string}")
//    public void iGoTo(String option) {
//        new Home().selectTeacherOption(option);
//    }

    @And("I create a quiz")
    public void iCreateAQuiz() {
        Quiz quiz = new Quiz();
        quiz.createNewQuiz();
    }


    @When("I type {string} as the title")
    public void iTypeAsTheTitle(String title) {
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
        System.out.println("points displayed: " + quiz.getPointsDescription());
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

    @And("I go to {string}")
    public void iGoTo(String text) throws InterruptedException {
        new TeacherHome().selectTeacherOption(text);
    }


    @When("I add {int} textual questions")
    public void iAddTextualQuestions(int number) throws InterruptedException {
        new Quiz().addTextualQuestions(number, "Question " + number);
    }

    @When("I click {string} button")
    public void iClickButton(String btnName) {
        new Quiz().clickQuizButton(btnName);
    }

    @Then("I select {string} from the list of quizzes")
    public void iSelectFromTheListOfQuizzes(String quiz) {
//        new WebDriverWait(getDriver(), 10).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//mat-panel-title")));
        new Quiz().clickQuizTitle(quiz);

    }

    @Then("I validate that quiz {string} has {int} questions")
    public void iValidateThatQuizHasQuestions(String quizTitle, int numQuestions) {
        new Quiz().checkQuizQuestionsNumber(quizTitle, numQuestions);

    }

    @And("I delete quiz {string}")
    public void iDeleteQuiz(String quizTitle) {
        new Quiz().deleteQuiz(quizTitle);
    }
}
