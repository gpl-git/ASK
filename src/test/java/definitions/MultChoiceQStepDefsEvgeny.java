package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class MultChoiceQStepDefsEvgeny {

    @And("I click on the element by xPath {string}")
    public void iClickOnTheElementByXPath(String myXPath) {
        getDriver().findElement(By.xpath(myXPath)).click();
    }

    @And("I input {string} in to field by xPath {string}")
    public void iInputInToFieldByXPath(String text, String xPath) {
        getDriver().findElement(By.xpath(xPath)).sendKeys(text);
    }

    @Then("I verify that User is able to create a {string} Quiz and Message - You created new Quiz - appears")
    public void iVerifyThatUserIsAbleToCreateAQuizAndMessageYouCreatedNewQuizAppears(String quizeName) {
        assertThat(getDriver().findElement(By.xpath("//mat-panel-title[contains(text()," + quizeName + ")]")).isDisplayed());
        System.out.println("Quize was created.");
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(),'You created new Quiz')]")).isDisplayed());
        System.out.println("Message \"You created new Quiz\" appears.");
    }

    @Then("I verify that User is not able to create a Quiz")
    public void iVerifyThatUserIsNotAbleToCreateAQuiz() {
        getDriver().findElement(By.xpath("//div[contains(@class,'ng-tns-c9')]")).isDisplayed();
        getDriver().findElement(By.xpath("//mat-error[contains(text(),'This field is required')]"));
        getDriver().switchTo().frame("//simple-snack-bar[contains(text(),'Quiz is not completed')]");
    }

    @And("I click on the {string} menu item")
    public void iClickOnTheMenuItem(String item) {
        String[] menuItems = {"Home", "Submissions", "Assignments", "Quizzes", "Users Management", "Settings", "Log Out"};
        if (item.equalsIgnoreCase(menuItems[0])) {
            getDriver().findElement(By.xpath("//*[contains(text(),'" + menuItems[0] + "')]")).click();
        } else if (item.equalsIgnoreCase(menuItems[1])) {
            getDriver().findElement(By.xpath("//*[contains(text(),'" + menuItems[1] + "')]")).click();
        } else if (item.equalsIgnoreCase(menuItems[2])) {
            getDriver().findElement(By.xpath("//*[contains(text(),'" + menuItems[2] + "')]")).click();
        } else if (item.equalsIgnoreCase(menuItems[3])) {
            getDriver().findElement(By.xpath("//*[contains(text(),'" + menuItems[3] + "')]")).click();
        } else if (item.equalsIgnoreCase(menuItems[4])) {
            getDriver().findElement(By.xpath("//*[contains(text(),'" + menuItems[4] + "')]")).click();
        } else if (item.equalsIgnoreCase(menuItems[5])) {
            getDriver().findElement(By.xpath("//*[contains(text(),'" + menuItems[5] + "')]")).click();
        } else if (item.equalsIgnoreCase(menuItems[6])) {
            getDriver().findElement(By.xpath("//*[contains(text(),'" + menuItems[6] + "')]")).click();
        } else System.out.println("No such Menu Item.");
    }

    @And("I click on the {string} button")
    public void iClickOnTheButton(String button) {
        if (button.equalsIgnoreCase("Create New Quiz")) {
            getDriver().findElement(By.xpath("//*[contains(text(),'New Quiz')]")).click(); }
        else if (button.equalsIgnoreCase("Add Question")) {
            getDriver().findElement(By.xpath("//mat-icon[@class='mat-icon material-icons']")).click(); }
        else if (button.equalsIgnoreCase("Save")) {
            getDriver().findElement(By.xpath("//*[contains(text(),'Save')]")).click(); }

        else System.out.println("No such button found.");
    }

    @And("I input {string} in to the {string}")
    public void iInputInToThe(String message, String locator) {
        if (locator.equalsIgnoreCase("Title Of The Quiz")) {
            getDriver().findElement(By.xpath("//input[@placeholder='Title Of The Quiz *']")).sendKeys(message);
        } else System.out.println("No such field found.");
    }

    @And("I choose {string} question as {string}")
    public void iChooseQuestionAs(String questionNumber, String question) {

        if (question.equalsIgnoreCase("textual")) {
            WebElement element = getDriver().findElement(By.xpath("//*[contains(text(),'Q"+questionNumber+"')]/../../..//*[contains(text(),'Textual')]"));
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].click();", element); }
        else if (question.equalsIgnoreCase("single-choice")) {
            WebElement element = getDriver().findElement(By.xpath("//*[contains(text(),'Q"+questionNumber+"')]/../../..//*[contains(text(),'Single-Choice')]"));
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].click();", element); }
        else if (question.equalsIgnoreCase("multiple-choice")) {
            WebElement element = getDriver().findElement(By.xpath("//*[contains(text(),'Q"+questionNumber+"')]/../../..//*[contains(text(),'Multiple-Choice')]"));
            JavascriptExecutor executor = (JavascriptExecutor) getDriver();
            executor.executeScript("arguments[0].click();", element); }
        else System.out.println("No such type of question found.");
    }

    @And("I input {string} in to the answer Option {string} field")
    public void iInputInToTheAnswerOptionField(String answer, String fieldNumber) {
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option "+fieldNumber+"*']")).sendKeys(answer);
    }

    @And("I Include Other text area option in {string} question")
    public void iIncludeOtherTextAreaOptionInQuestion(String question) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Q"+question+"')]/../../..//*[@class='mat-checkbox-inner-container']")).click();
    }

    @And("I input {string} in to Question input field")
    public void iInputInToQuestionInputField(String input) {
        getDriver().findElement(By.xpath("//*[@placeholder='Question *']")).sendKeys(input);
    }
}
