package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class TeacherHome extends Page {
    public TeacherHome() {
    }

    @FindBy(xpath = "//h5[contains(text(),'Home')]")
    private WebElement home;
    @FindBy(xpath = "//h5[contains(text(),'Submissions')]")
    private WebElement submissions;
    @FindBy(xpath = "//h5[contains(text(),'Assignments')]")
    private WebElement assignments;
    @FindBy(xpath = "//h5[contains(text(),'Quizzes')]")
    private WebElement quizzes;
    @FindBy(xpath = "//h5[contains(text(),'Management')]")
    private WebElement userManagement;
    @FindBy(xpath = "//h5[contains(text(),'Settings')]")
    private WebElement settings;
    @FindBy(xpath = "//h5[contains(text(),'Log Out')]")
    private WebElement logOut;
    @FindBy(xpath = "//span[contains(text(),'Log Out')]")
    private WebElement btnLogout;
    @FindBy(xpath = "//span[contains(text(),'Create New Quiz')]")
    private WebElement btnCreateNewQuiz;
    @FindBy(xpath = "//div[@class='info']")
    private WebElement info;

    public void logOut() throws InterruptedException {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(logOut));
        logOut.click();

        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(btnLogout));
        btnLogout.click();
       }

    public void goToQuiz() {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(quizzes));
        quizzes.click();
    }

    public void selectTeacherOption(String element) throws InterruptedException {
        Thread.sleep(2000);
        switch (element) {
            case "Home":
                home.click();
                break;
            case "Submissions":
                submissions.click();
                break;
            case "Assignments":
                assignments.click();
                break;
            case "Quizzes":
                quizzes.click();
                break;
            case "Management":
                userManagement.click();
                break;
            case "Settings":
                settings.click();
                break;
            case "Log Out":
                logOut.click();
                break;
            default:
                System.out.println("Option " + element + " is not available");
                break;
        }
    }

    public String getUserRole() {
        String infoText;
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(info));
        infoText = info.getText();
        return infoText;
    }

}



