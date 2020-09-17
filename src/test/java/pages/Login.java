package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class Login extends Page {
    public Login() {

    }


    @FindBy(xpath = "//input[@formcontrolname='email']")
    private WebElement userEmail;
    @FindBy(xpath = "//input[@formcontrolname='password']")
    private WebElement userPassword;
    @FindBy(xpath = "//span[contains(text(),'Sign In')]")
    private WebElement btnSignIn;
    @FindBy(xpath = "//span[contains(text(),'Register Now')]")
    private WebElement registerNow;

    @FindBy(xpath = "//simple-snack-bar")
    private WebElement overlayContainer;

    List<WebElement> allErrors = getDriver().findElements(By.xpath("//mat-error"));

    public void checkError(String message){
        for ( WebElement error: allErrors) {
            String actualError = error.getText();
            if ( error.getText().contains( actualError ) ) {
                new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(error));
                assertThat(actualError.equals( message ) ).isTrue();
            }
        }
    }

    public void signIn(String email, String password) {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        btnSignIn.click();
    }

    public void registerNow() {

        registerNow.click();
    }


    public String getAuthenticationErrorMessage() {
        String messageText;
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(overlayContainer));
        messageText = overlayContainer.getText();
        return messageText;
    }




    public void enterEmail(String email){
        userEmail.sendKeys(email);
    }
    public void enterPassword(String password){
        userPassword.sendKeys(password);
    }
    public void clickSignIn(){
        btnSignIn.click();
    }
}

