package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class UserManagStepDefs {
    @And("I navigate to the {string} page")
    public void iNavigateToThePage(String menu) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + menu + "')]")).click();
    }


    @Then("I clear the field")
    public void iClearTheField() {
        getDriver().findElement(By.xpath("//*[@placeholder='Full Name']")).clear();
    }


    @And("I log out")
    public void iLogOut() {
        getDriver().findElement(By.xpath("//*[contains(text(),'Log Out')]")).click();
    }

    @Then("I click to {string} from mat-card menu")
    public void iClickToFromMatCardMenu(String students) {
        getDriver().findElement(By.xpath("//div[contains(text(),'Students')]")).click();

    }

    @And("I click to student {string}")
    public void iClickToStudent(String StudentName) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + StudentName + "')]")).click();
    }


    @And("I click on {string} button")
    public void iClickOnButton(String options) {
        getDriver().findElement(By.xpath("//button[@class='mat-raised-button mat-accent']")).click();
    }


    @And("I navigate from {string} to User management page")
    public void iNavigateFromToUserManagementPage(String menu) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + menu + "')]")).click();

    }

    @And("I click {string} link")
    public void iClickLink(String link) {
        getDriver().findElement(By.xpath("//div[@class='cdk-overlay-container']//button[1]")).click();
    }


    @And("I click Change Your {string} button")
    public void iClickChangeYourButton(String arg0) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Change Your Name')]")).click();
    }


    @Then("I change Student {string} to {string}")
    public void iChangeStudentTo(String name, String newName) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='" + name + "']")).sendKeys(newName);
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//span[@class='mat-button-wrapper'][contains(text(),'Change')]")).click();
    }


    @And("I click {string}")
    public void iClick(String arg0) {
        getDriver().findElement(By.xpath("//*[@class='mat-raised-button mat-primary']")).click();
    }

    @When("I type the {string} into email field")
    public void iTypeTheIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type the {string} into password field")
    public void iTypeTheIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click the SignIn button")
    public void iClickTheSignInButton() {
        getDriver().findElement(By.xpath("//*[@type='submit']")).click();
    }


    @And("I wait {int} sec")
    public void iWaitSec(int sec) throws InterruptedException {
        Thread.sleep(1000);
    }

    @Then("the text {string} is displayed")
    public void theTextIsDisplayed(String text) {
        String role = getDriver().findElement(By.xpath("//p[contains(text(),'" + text + "')]")).getText();
        assertThat(role.equals(text)).isTrue();
    }

    @Given("I open the {string} page")
    public void iOpenThePage(String page) {
        if (page.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (page.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("Unsupported site");
        }
    }


    @And("I click the {string} link")
    public void iClickTheLink(String arg0) {
        getDriver().findElement(By.xpath("//body//button[3]")).click();
    }

    @Then("I change Student group to the {string}")
    public void iChangeStudentGroupToThe(String NewGroup) {
        getDriver().findElement(By.xpath("//input[@id='mat-input-2']")).sendKeys(NewGroup);

    }

    @And("I click the {string}")
    public void iClickThe(String arg0) {
        getDriver().findElement(By.xpath("//span[contains(text(),'Change')]")).click();
    }

    @Then("User's group is changed")
    public void userSGroupIsChanged(String NewGroup) {
        getDriver().findElement(By.xpath("//td[contains(text(),'" + NewGroup + "')]")).getText();
        System.out.println("The student group is changed");
    }


    @Then("I change Student Name to the {string}")
    public void iChangeStudentNameToThe(String NewName) {
        getDriver().findElement(By.xpath("//*[@placeholder='Full Name']")).sendKeys(NewName);
    }


    @Then("{string} is changed to the {string}")
    public void isChangedToThe(String StudentName, String NewName) {
        getDriver().findElement(By.xpath("//div[@class='horizontal-group']")).getText();
        assertThat(StudentName.equals(NewName)).isFalse();
        System.out.println("You changed student username to " + NewName + "!");

    }
}











