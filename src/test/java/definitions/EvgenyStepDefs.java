package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class EvgenyStepDefs {

    @And("I click on the element by xPath {string}")
    public void iClickOnTheElementByXPath(String myXPath) {
        getDriver().findElement(By.xpath(myXPath)).click(); }

    @And("I input {string} in to field by xPath {string}")
    public void iInputInToFieldByXPath(String text, String xPath) {
        getDriver().findElement(By.xpath(xPath)).sendKeys(text);
    }

    @Then("I verify that User is able to create a {string} Quiz and Message - You created new Quiz - appears")
    public void iVerifyThatUserIsAbleToCreateAQuizAndMessageYouCreatedNewQuizAppears(String quizeName) {
       assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),"+quizeName+")]")).isDisplayed());
       System.out.println("Quize was created.");
       assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'You created new Quiz')]")).isDisplayed());
       System.out.println("Message \"You created new Quiz\" appears.");
       }

    @Then("I verify that User is not able to create a Quiz")
    public void iVerifyThatUserIsNotAbleToCreateAQuiz() {
//        User is not able to create a Quiz
//        Message "Quiz is not completed" appears
//        Required area is highlighted

//        color xPath
        getDriver().findElement(By.xpath("//div[contains(@class,'ng-tns-c9-224')]")).isDisplayed();
        getDriver().findElement(By.xpath("//mat-error[contains(text(),'This field is required')]"));
        getDriver().switchTo().frame("//simple-snack-bar[contains(text(),'Quiz is not completed')]");


    }
}
