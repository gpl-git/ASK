package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static support.TestContext.getDriver;

public class Assignment extends TeacherHome{
    @FindBy(xpath = "//span[contains(text(),'Create New Assignment')]")
    private WebElement btnCreateNewAssignment;

    @FindBy(xpath = "//span[text()='Select All']")
    private WebElement selectAll;

    @FindBy(xpath = "//span[text()='Give Assignment']")
    private WebElement btnGiveAssignment;
    List<WebElement> checkboxes = getDriver().findElements(By.xpath("//mat-list-option"));
    List<WebElement> students = getDriver().findElements(By.cssSelector(".mat-card .mat-list-text"));



    public void createNewAssignment(){
        new WebDriverWait(getDriver(),5).until(ExpectedConditions.elementToBeClickable(btnCreateNewAssignment));
        btnCreateNewAssignment.click();
    }
    public void selectAllStudents(){
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", selectAll);

    }

    public void giveAssignment(){
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", btnGiveAssignment);
    }
    public void selectStudents(int num) {
        int selectedStudents = 0;
        int sizeOfList = checkboxes.size();
        int i = 0;
        while (i < sizeOfList && selectedStudents < num) {
//            WebElement student = students.get(i);
            checkboxes.get(i).click();
            selectedStudents++;
            i++;
        }
    }


}
