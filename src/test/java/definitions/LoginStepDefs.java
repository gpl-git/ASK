package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class LoginStepDefs {
    @Given("I open {string} page")
    public void iOpenPage(String page) {
        if (page.equals("login")) {
            getDriver().get("http://ask-qa.portnov.com/#/login");
        } else if (page.equals("registration")) {
            getDriver().get("http://ask-qa.portnov.com/#/registration");
        } else {
            System.out.println("Unsupported site");
        }
    }

    @And("I wait for {int} sec")
    public void iWaitForSec(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @When("I type {string} into email field")
    public void iTypeIntoEmailField(String email) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
    }

    @And("I type {string} into password field")
    public void iTypeIntoPasswordField(String password) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
    }

    @When("I click SignIn button")
    public void iClickSignInButton() {
        getDriver().findElement(By.xpath("//*[@type='submit']")).click();
    }

    @Then("text {string} is displayed")
    public void textIsDisplayed(String text) {
        String role = getDriver().findElement(By.xpath("//p[contains(text(),'" + text + "')]")).getText();
        assertThat(role.equals(text)).isTrue();
    }


    @And("I navigate to the Settings page")
    public void iNavigateToTheSettingsPage() { getDriver().findElement(By.xpath("//*[contains(text(),'Settings')]")).click();
    }



    @And("I click Change Your Name button")
    public void iClickChangeYourNameButton() {getDriver().findElement(By.xpath("//*[contains(text(),'Change Your Name')]")).click();
    }

    @Then("{string} is displayed")
    public void isDisplayed(String arg0) {
        getDriver().findElement(By.xpath("//*[contains(text(),'Change Your Name')]"));
    }

    @Then("I clear the field")
    public void iClearTheField() {
        getDriver().findElement(By.xpath("//*[@placeholder='Full Name']")).clear();

    }

    @Then("I change Student name to {string}")
    public void iChangeStudentNameTo(String name) {
        getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(name);
        getDriver().findElement(By.xpath("//div[@class='mat-dialog-actions']//span[@class='mat-button-wrapper'][contains(text(),'Change')]")).click();
        getDriver().findElement(By.xpath("//*[contains(text(),'" + name + "')]")).getText();
        assertThat(name.equals(name)).isTrue();
        System.out.println("You changed your student username to " + name + "!");
    }

    @And("I log out")
    public void iLogOut() {
        getDriver().findElement(By.xpath("//*[contains(text(),'Log Out')]")).click();
    }


    @And("I navigate to the User management page")
    public void iNavigateToTheUserManagementPage() {
        getDriver().findElement(By.xpath("//*[contains(text(),'Users Management')]")).click();
    }

    @Then("I click to {string} from mat-card menu")
    public void iClickToFromMatCardMenu(String students) {
        getDriver().findElement(By.xpath("//div[contains(text(),'Students')]")).click();

    }



    @And("I click to student {string}")
    public void iClickToStudent(String number) {
        getDriver().findElement(By.xpath("//a["+3+"]//mat-list-item[1]")).click();
    }

    @And("I click on options button")
    public void iClickOnOptionsButton() {
        getDriver().findElement(By.xpath("//*[@class='mat-button-wrapper']")).click();


    }
}


//    getDriver().findElement(By.xpath("//div[@class='cdk-overlay-container']//button[1]")).click();
//        getDriver().findElement(By.xpath("//*[@placeholder='Full Name']]")).clear();