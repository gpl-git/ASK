package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.Keys.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;
import static org.assertj.core.api.Assertions.assertThat;

public class Register extends Page {
    public Register() {
    }

    String email;
    @FindBy(xpath = "//input[@formcontrolname ='firstName']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@formcontrolname ='lastName']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@formcontrolname ='email']")
    private WebElement regEmail;
    @FindBy(xpath = "//input[@formcontrolname ='group']")
    private WebElement groupCode;
    @FindBy(xpath = "//input[@formcontrolname ='password']")
    private WebElement regPassword;
    @FindBy(xpath = "//input[@formcontrolname ='confirmPassword']")
    private WebElement regConfirmPassword;
    @FindBy(xpath = "//span[contains(text(),'Register Me')]")
    private WebElement btnRegisterMe;
    @FindBy(xpath = "//span[contains(text(),'Back to Login')]")
    private WebElement btnBackToLogin;
    @FindBy(xpath = "//mat-card/h4")
    private WebElement confirmationCard;
    @FindBy(xpath = "//span[@class='mat-button-wrapper']")
    private WebElement btnBackToLoginPage;
    @FindBy(xpath = "//mat-error")
    private WebElement registrationError;




    List<WebElement> allErrors = getDriver().findElements(By.xpath("//mat-error"));
    public void checkError(String message){
        for ( WebElement error: allErrors) {
            String actualError = error.getText();
            if ( error.getText().contains( actualError ) ) {
                assertThat(actualError.equals( message ) ).isTrue();
            }
        }
    }

    public void clickRegisterBtn(){
        btnRegisterMe.click();
    }

    public void goBackToLogin() {
        btnBackToLogin.click();
    }

    public static String getCurrentDateTimeMS() {
        Date dNow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyMMddhhmmssMs");
        String datetime;
        datetime = ft.format(dNow);
        return datetime;
    }

    public void fillOutFirstName(String firstName){
        this.firstName.sendKeys(firstName);
    }

    public void fillOutLastName(String lastName){
        this.lastName.sendKeys(lastName);
    }
    public void fillOutEmail(String email) {
        regEmail.sendKeys(email);
    }
    public void fillOutGroupCode(String group) {
       groupCode.sendKeys(group);
    }

    public void fillOutPassword(String password){
        regPassword.sendKeys(password);
    }
    public void fillOutConfirmPassword(String password){
        regConfirmPassword.sendKeys(password);
    }

    public void fillOutRegistrationForm(String firstName, String lastName, String groupCode, String password) throws InterruptedException, AWTException {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.regEmail.sendKeys(getCurrentDateTimeMS()+"@test.com");
        this.groupCode.sendKeys(groupCode);
        regPassword.sendKeys(password);
        regConfirmPassword.sendKeys(password);
        btnRegisterMe.click();
    }

        public String getconfirmRegistration() {
            new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(confirmationCard));
            return confirmationCard.getText();
        }

    public String getErrorMessage() {
        return registrationError.getText();

    }


}
