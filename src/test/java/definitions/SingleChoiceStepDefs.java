package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static support.TestContext.getDriver;

public class SingleChoiceStepDefs {
    @When("I type {string} in the {string} field")
    public void iTypeInTheField(String text, String radioBtn) {
        
    }

    @And("I type {string} into {string} field")
    public void iTypeIntoField(String arg0, String arg1)throws InterruptedException {
        List <WebElement> textareas = getDriver().findElements(By.xpath("//textarea"));
        WebElement textarea = null;

        if(arg1.toLowerCase().compareTo("option 1") == 0) {
            textarea = textareas.get(1);
            System.out.println(arg1.compareToIgnoreCase("option 1"));
        } else if (arg1.toLowerCase().compareTo("option 1") == 1) {
            textarea = textareas.get(2);
            System.out.println(arg1.compareToIgnoreCase("option 1"));
        } else if (arg1.toLowerCase().compareTo("option 1") == 2) {
            textarea = textareas.get(3);
            System.out.println(arg1.compareToIgnoreCase("option 1"));
        }

            textarea.sendKeys(arg0);
            Thread.sleep(2000);
        }

    @When("I click Add Option button {int} times")
    public void iClickAddOptionButtonTimes(int n) {
        for(int i = 1; i <= n; i++){
            getDriver().findElement(By.xpath("//span[contains(text(),'Add Option')]")).click();
        }

    }

    @And("I type {string} into other {int} fields")
    public void iTypeIntoOtherFields(String text, int n) {
        List <WebElement> textareas = getDriver().findElements(By.xpath("//textarea"));
        WebElement textarea = null;

        for(int i = 2; i <= n+2; i++){
           textarea = textareas.get(i);
           textarea.sendKeys(text);
        }
    }

    @When("I click on Option {int} radio button")
    public void iClickOnOptionRadioButton(int n) {
        List<WebElement> radioButtons = getDriver().findElements(By.xpath("//mat-radio-button"));
        WebElement radioButton = radioButtons.get(n+2);
        radioButton.click();
    }
}


