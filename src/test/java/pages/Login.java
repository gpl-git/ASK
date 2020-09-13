package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    @FindBy(xpath = "//div[@class='info']")
    private WebElement info;

    public void signIn(String email, String password) {
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        btnSignIn.click();
    }

    public void registerNow() {

        registerNow.click();
    }

    public String getUserRole() {
        String infoText;
        infoText = info.getText();
        return infoText;
    }
}

