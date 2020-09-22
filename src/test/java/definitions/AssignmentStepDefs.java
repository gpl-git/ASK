package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.Assignment;

import java.util.List;

import static support.TestContext.getDriver;

public class AssignmentStepDefs {
    @When("I click Create New Assignment")
    public void iClickCreateNewAssignment() {
        new Assignment().createNewAssignment();
    }

    @Then("I select all students")
    public void iSelectAllStudents() {
        new Assignment().selectAllStudents();
    }

    @And("I click Give Assignment")
    public void iClickGiveAssignment() {
        new Assignment().giveAssignment();
    }

    @Then("I select {int} students")
    public void iSelectStudents(int num) {
        new Assignment().selectStudents(num);




    }

    @When("I select {string} group")
    public void iSelectGroup(String group) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Group Filter')]/../..")).click();
        WebElement element = getDriver().findElement(By.xpath("//span[@class='mat-option-text' " +
                "and contains(text(),'" + group + "')]"));
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);

        Actions actions = new Actions(getDriver());
        actions.moveToElement(element);
        actions.perform();
        element.click();

    }
}
