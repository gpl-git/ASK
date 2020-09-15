package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Home;
import pages.Login;
import pages.Register;

import java.util.EventObject;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginStepDefs {
    public String pageURL = "http://ask-qa.portnov.com/#/";
    @Given("I navigate to {string} page")
    public void iNavigateToPage(String site) {
        switch (site) {
            case "google":
                getDriver().get("https://www.google.com/");
                break;
            case "ask":
                getDriver().get("http://ask-qa.portnov.com/#/login");
                break;
            case "ask_prod":
                getDriver().get("http://ask.portnov.com/#/login");
                break;
            case "quote":
                getDriver().get("https://skryabin.com/market/quote.html");
                break;
            default:
                System.out.println("Unsupported site");
        }
    }

    @And("I login as a teacher")
    public void iLoginAsATeacher() {
        Login login = new Login();
        login.signIn("ask_instr@aol.com", "12345");
    }

    @And("I go to Register page")
    public void iGoToRegisterPage() {
        new Login().registerNow();
        assertThat(getDriver().getCurrentUrl().contains("registration")).isTrue();
    }

    @And("I return to Login Page")
    public void iReturnToLoginPage() {
        new Register().goBackToLogin();
        assertThat(getDriver().getCurrentUrl().contains("login")).isTrue();
    }

    @Then("I logout")
    public void iLogout() throws InterruptedException {
        new Home().logOut();
    }


    @Then("I verify user role as {string}")
    public void iVerifyUserRoleAs(String userRole) {
        assertThat(new Home().getUserRole().contains(userRole)).isTrue();
    }

    @When("I login as a {string}")
    public void iLoginAsA(String userRole) {
        Login login = new Login();
        if (userRole.equals("teacher")) {
            login.signIn("ask_instr@aol.com", "12345");
        } else if (userRole.equals("student")) {
            login.signIn("test@abc.com", "12345");
        } else {
            System.out.println("User " + userRole + " is not authorized");
        }
    }

    @Then("I verify current page {string}")
    public void iVerifyCurrentPage(String page) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.urlContains(page));
        assertThat(getDriver().getCurrentUrl().contains(page)).isTrue();
    }

       @When("I login with {string} and {string} as {string}")
    public void iLoginWithAndAs(String email, String password, String userRole) {
        Login login = new Login();
        login.enterEmail(email);
        login.enterPassword(password);
        login.clickSignIn();



    }

    @When("I login with {string} and {string}")
    public void iLoginWithAnd(String email, String password) {
        Login login = new Login();
        login.enterEmail(email);
        login.enterPassword(password);
        login.clickSignIn();
    }

    @Then("login error {string} should be displayed")
    public void loginErrorShouldBeDisplayed(String message) {
        new Login().checkError(message);
    }

    @Then("I verify authentication error message {string}")
    public void iVerifyAuthenticationErrorMessage(String message) {
        assertThat(new Login().getAuthenticationErrorMessage().contains(message)).isTrue();
    }
}
