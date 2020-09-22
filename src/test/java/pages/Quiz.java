package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;

import java.util.List;

import static support.TestContext.getDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class Quiz extends TeacherHome {
    public Quiz() {
    }

    @FindBy(xpath = "//span[contains(text(),'Create New Quiz')]")
    private WebElement btnCreateNewQuiz;
    @FindBy(xpath = "//span[contains(text(),'Back To Quizzes List')]")
    private WebElement btnBackToQuizzesList;
    @FindBy(xpath = "//input[@formcontrolname='name']")
    private WebElement inputQuizTitle;
    @FindBy(xpath = "//mat-error")
    private WebElement errorMessageTitle;
    @FindBy(xpath = "//mat-icon[@class='mat-icon material-icons']")
    private WebElement addQuestion;
    @FindBy(xpath = "//div[contains(text(),'Textual')]")
    private WebElement radioTextual;
    @FindBy(xpath = "//div[contains(text(),'Multiple-Choice')]")
    private WebElement radioMultipleChoice;
    @FindBy(xpath = "//div[contains(text(),'Single-Choice')]")
    private WebElement radioSingleChoice;
    @FindBy(xpath = "//textarea[@formcontrolname='question']")
    private WebElement inputFieldQuestion;
    @FindBy(xpath = "//span[@class='mat-content']")
    private WebElement questionHeader;
    @FindBy(xpath = "//span[@class='mat-checkbox-label']")
    private WebElement showStopper;
    @FindBy(xpath = "//h2[@color='accent']")
    private WebElement labelPoints;
    @FindBy(xpath = "//h1")
    private WebElement labelPassingRate;
    @FindBy(xpath = "//div[@class='wrapper']//div[@class='mat-slider-thumb']")
    private WebElement sliderPointer;
    @FindBy(xpath = "//div[@class='wrapper']//div[@class='mat-slider-track-wrapper']")
    private WebElement sliderTracker;
    @FindBy(xpath = "//span[contains(text(),'Delete Question')]")
    private WebElement deleteQuestion;
    @FindBy(xpath = "//button[@class='mat-button mat-warn']//span[@class='mat-button-wrapper'][contains(text(),'Delete')]")
    private WebElement confirmDelete;
    @FindBy(xpath = "//button[@class='mat-button mat-warn']//span[@class='mat-button-wrapper']//span[contains(text(),'No, Thanks')]")
    private WebElement confirmNo;
    @FindBy(xpath = "//mat-panel-title")
    private WebElement questionTitle;
    @FindBy(xpath = "//span[contains(text(),'Preview')]")
    private WebElement previewQuiz;
    @FindBy(xpath = "//span[contains(text(),'Save')]")
    private WebElement saveQuiz;

    @FindBy(xpath = "//ac-modal-confirmation//span[text()='Delete']")
    private WebElement confirmDeleteBtn;

    @FindBy(xpath = "//span[@class='bold']/../../div")
    private WebElement checkBoxShowStopper;
    @FindBy(xpath = "//*[contains(@class,'choice-error')]")
    private WebElement choiceError;


    @FindBy(xpath = "//mat-panel-description")
    private WebElement pointsDescription;

    public void addQuestion() {
        addQuestion.click();
    }


    public boolean isErrorPresent() {
        errorMessageTitle.isEnabled();
        return false;
    }

    public void createNewQuiz() {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(btnCreateNewQuiz));
        btnCreateNewQuiz.click();
    }

    public void verifyNewQuizPage() {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(inputQuizTitle));
        assertThat(inputQuizTitle.getText().contains("Title Of The Quiz"));
        assertThat(btnBackToQuizzesList.isEnabled());
        assertThat(!addQuestion.isDisplayed());
    }

    public void enterQuizTitle(String text) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.visibilityOf(inputQuizTitle));
        inputQuizTitle.click();
        inputQuizTitle.sendKeys(text);
    }

    public boolean isTitleErrorMessageDisplayed() {
        errorMessageTitle.isDisplayed();
        return true;
    }

    public String getTitleErrorMessage() {
        return errorMessageTitle.getText();
    }

    public void clearTitleField() {
        inputQuizTitle.sendKeys(Keys.BACK_SPACE);
        inputQuizTitle.sendKeys(Keys.ENTER);
    }

    public void deleteQuestion() {
        deleteQuestion.click();
    }

    public void confirmDelete() {
        confirmDelete.click();
    }

    public void selectQuestionType(String text) {
        switch (text) {
            case "Textual":
                radioTextual.click();
                break;
            case "Single-Choice":
                radioSingleChoice.click();
                break;
            case "Multiple-Choice":
                radioMultipleChoice.click();
                break;
        }
    }

    public void addQuestionTextual(String text) {
        addQuestion.click();
        assertThat(questionTitle.getText().contains("Q1: new empty question"));
        radioTextual.click();
        inputFieldQuestion.sendKeys(text);
        assertThat(questionHeader.getText().contains(text));
        assertThat(questionTitle.getText().contains(text));
        showStopper.click();
        assertThat(questionHeader.getText().contains("*"));
        assertThat(labelPoints.getText().equals("5"));
        assertThat(questionHeader.getText().contains("5 Point(s)"));
        assertThat(labelPassingRate.getText().equals("75"));
    }

    public void setPointsPossible(int points) {
        System.out.println("init points" + labelPoints.getText());
        int x = 10;
        int width = sliderTracker.getSize().getWidth();
        Actions act = new Actions(getDriver());
        switch (points) {
            case 1:
                act.moveToElement(sliderTracker, (-(width * 5 * x) / 100), 0).click();
                act.build().perform();
                break;
            case 2:
                act.moveToElement(sliderTracker, (-(width * 4 * x) / 100), 0).click();
                act.build().perform();
                break;
            case 3:
                act.moveToElement(sliderTracker, (-(width * 3 * x) / 100), 0).click();
                act.build().perform();
                break;
            case 4:
                act.moveToElement(sliderTracker, (-(width) * 2 * x / 100), 0).click();
                act.build().perform();
                break;
            case 5:
            default:
                break;
            case 6:
                act.moveToElement(sliderTracker, ((width * x) / 100), 0).click();
                act.build().perform();
                break;
            case 7:
                act.moveToElement(sliderTracker, ((width * 2 * x) / 100), 0).click();
                act.build().perform();
                break;
            case 8:
                act.moveToElement(sliderTracker, ((width * 3 * x) / 100), 0).click();
                act.build().perform();
                break;
            case 9:
                act.moveToElement(sliderTracker, ((width * 4 * x) / 100), 0).click();
                act.build().perform();
                break;
            case 10:
                act.moveToElement(sliderTracker, ((width * 5 * x) / 100), 0).click();
                act.build().perform();
                break;
        }


    }

    public String getPointsPossible() {
        return labelPoints.getText();
    }

    public String getPointsDescription() {
        return pointsDescription.getText();
    }

    public void addTextualQuestions(int number, String text) throws InterruptedException {
        for (int i = 1; i <= number; i++) {
            new WebDriverWait(getDriver(), 10).until(ExpectedConditions.elementToBeClickable(addQuestion));
            addQuestion.click();
            assertThat(questionTitle.getText().contains("Q1: new empty question"));
            Thread.sleep(2000);
            getDriver().findElement(By.xpath("//*[contains(text(),'Q" + i + "')]/../../..//*[contains(text(),'Textual')]")).click();
            String xpath = "//*[contains(text(),'Q" + i + "')]/../../..//*[@placeholder='Question *']";
            getDriver().findElement(By.xpath(xpath)).sendKeys("Test");
            assertThat(questionHeader.getText().contains(text));
            assertThat(questionTitle.getText().contains(text));
            assertThat(labelPoints.getText().equals("5"));
            assertThat(questionHeader.getText().contains("5 Point(s)"));
            assertThat(labelPassingRate.getText().equals("75"));
        }
    }

    public void clickQuizButton(String btnName) {
        switch (btnName) {
            case "Save":
                saveQuiz.click();
                break;
            case "Preview":
                previewQuiz.click();
                break;
            case "Delete":
                deleteQuestion.click();
                break;
            default:
                System.out.println("No such button");
        }
    }

    public void clickQuizTitle(String title) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + title + "')]")).click();

    }

    public String checkQuizQuestionsNumber(String title, int num) {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[@class='mat-content']/mat-panel-title[contains(text(),'"+title+"')]/..")));
        String quizTitleAndDescription = getDriver().findElement(By.xpath("//span[@class='mat-content']/mat-panel-title[contains(text(),'"+title+"')]/..")).getText();
        System.out.println(quizTitleAndDescription);
        return quizTitleAndDescription;

    }

    public void deleteQuiz(String quizTitle) throws InterruptedException {
        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]/../../..//span[contains(text(),'Delete')]")));
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizTitle + "')]/../../..//span[contains(text(),'Delete')]")).click();

        new WebDriverWait(getDriver(), 5).until(ExpectedConditions.elementToBeClickable(confirmDeleteBtn));
        confirmDeleteBtn.click();

    }

    public void addQuestionTitle(String text, String question, String option) {
        String xpath = "//*[contains(text(),'" + question + "')]/../../..//*[@placeholder='" + option + "']";
        getDriver().findElement(By.xpath(xpath)).sendKeys(text);
    }

    public void selectRadioButtonCorrectOption(String option, String question) {
        String xpath = "//*[@placeholder='" + option + "']/../../../../..//*[@class='mat-radio-inner-circle']";
        WebElement correctRadio = getDriver().findElement(By.xpath(xpath));
        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
        executor.executeScript("arguments[0].click();", correctRadio);

    }

    public void addOption(int num, String question) {
        String btnAddOption = "//*[contains(text(),'" + question + "')]/../../..//*[contains(text(), 'Add Option')]";
        for (int i = 3; i <= num + 2; i++) {
            getDriver().findElement(By.xpath(btnAddOption)).click();
            String xpath = "//*[contains(text(),'Q1')]/../../..//*[@placeholder='Option " + i + "*']";
            getDriver().findElement(By.xpath(xpath)).sendKeys("Test Option" + i);
        }

    }

    public void checkShowStopper() {
        checkBoxShowStopper.click();
    }

    public String getQuestionTitle() {
        return questionTitle.getText();
    }
    public void checkCheckBoxCorrectOption(String option, String question) {
        String xpath = "//*[@placeholder='"+option+"']/../../../../../mat-checkbox";
        WebElement correctCheckBox = getDriver().findElement(By.xpath(xpath));
        correctCheckBox.click();
//        JavascriptExecutor executor = (JavascriptExecutor) getDriver();
//        executor.executeScript("arguments[0].click();", correctCheckBox);

    }
    public String getChoiceError(){
        return choiceError.getText();
    }

}



