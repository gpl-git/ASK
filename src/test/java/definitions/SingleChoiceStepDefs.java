package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.Quiz;

import static org.assertj.core.api.Assertions.assertThat;

public class SingleChoiceStepDefs {
    @When("I type {string} as question {string} option {string}")
    public void iTypeAsQuestionOption(String text, String question, String option) {
        new Quiz().addQuestionTitle(text, question, option);
    }

    @Then("I select radio button {string} as correct answer in question {string}")
    public void iSelectRadioButtonAsCorrectAnswerInQuestion(String option, String question) {
        new Quiz().selectRadioButtonCorrectOption(option, question);
    }

    @Then("I validate question error message {string} is displayed")
    public void iValidateQuestionErrorMessageIsDisplayed(String errMessage) {
        Quiz quiz = new Quiz();
        assertThat(quiz.isTitleErrorMessageDisplayed()).isTrue();
        assertThat(quiz.getTitleErrorMessage().equals(errMessage));
    }

    @Then("I add {int} more options to {string}")
    public void iAddMoreOptionsTo(int num, String question) throws InterruptedException {
        Quiz quiz = new Quiz();
        quiz.addOption(num, question);
     }

    @And("I click Show-Stopper checkbox")
    public void iClickShowStopperCheckbox() {
        new Quiz().checkShowStopper();
    }

    @Then("I verify that question is marked as Show_Stopper")
    public void iVerifyThatQuestionIsMarkedAsShow_Stopper(){
       assertThat(new Quiz().getQuestionTitle().contains("Q1*")).isTrue();
    }
}
