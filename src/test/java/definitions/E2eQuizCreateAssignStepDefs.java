package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class E2eQuizCreateAssignStepDefs {
    @And("I click Create New Assignment button")
    public void iClickCreateNewAssignmentButton() {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-primary']")).click();
    }

    @And("I click Select Quiz To Assign")
    public void iClickSelectQuizToAssign() {
        getDriver().findElement(By.xpath("//*[@placeholder='Select Quiz To Assign']")).click();
    }

    @And("I select desired quiz {string}")
    public void iSelectDesiredQuiz(String quizName) {
        getDriver().findElement(By.xpath("//span[contains(text(),'"+quizName+"')]")).click();
    }


    @When("I click on a Group Filter")
    public void iClickOnAGroupFilter() {
        getDriver().findElement(By.xpath("//mat-select[@placeholder='Group Filter']//div[@class='mat-select-value']")).click();
    }

    @And("I select desired group {string} from the drop down list")
    public void iSelectDesiredGroupFromTheDropDownList(String groupCode) {
        getDriver().findElement(By.xpath("//*[@class='mat-option-text'][contains(text(),'"+groupCode+"')]")).click();
    }

    @And("I select students to assign them a quiz")
    public void iSelectStudentsToAssignThemAQuiz() {
        List<WebElement> checkboxes = getDriver().findElements(By.xpath("//mat-list-option"));
        int i;
        for(i=0; i<5; i++){checkboxes.get(i).click();}
    }

    @And("I click on Give Assignment button")
    public void iClickOnGiveAssignmentButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Give Assignment')]")).click();
    }

    @When("I expand {string} on the List Of Assignments")
    public void iExpandOnTheListOfAssignments(String quizName) {
        getDriver().findElement(By.xpath("//mat-expansion-panel//mat-expansion-panel-header//*[contains(text(),'Quiz: "+quizName+"')]")).click();
    }

    @Then("I should see {int} new assignments for students from group {string}")
    public void iShouldSeeNewAssignmentsForStudentsFromGroup(int count, String groupCode) {
        List<WebElement> group = getDriver().findElements(By.xpath("//*[contains(text(),'"+groupCode+"')]"));
        int i;
        for(i=0; i<5; i++){group.get(i).getText();}
        System.out.println(i);
        String grCode=getDriver().findElement(By.xpath("//tr//td[contains(text(),'"+groupCode+"')]")).getText();
        assertThat(grCode.contains(groupCode)).isTrue();

        if (grCode.contains(groupCode)){
            System.out.println("There IS an assignment for Group F547");
        }else{
            System.out.println("There is NO assignment for Group F547");
        }


    }

    @And("I click on Assignment menu button for quiz {string}")
    public void iClickOnAssignmentMenuButtonForQuiz(String quizName) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+quizName+"')]/../..//button")).click();
    }


    @And("I click on Delete Assignment button")
    public void iClickOnDeleteAssignmentButton() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Delete Assignment')]")).click();
    }

    @And("I confirm deletion")
    public void iConfirmDeletion() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Delete')]")).click();
    }


    @And("I select {string} quiz")
    public void iSelectQuiz(String quizName) {
        getDriver().findElement(By.xpath("//*[contains(text(),'textual1char')]")).click();
    }
}
