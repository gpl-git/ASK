package definitions;

import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static support.TestContext.getDriver;

public class MultChoiceStepDefs {
    @When("I click on Option {int} check box")
    public void iClickOnOptionCheckBox(int n) {
        List<WebElement> checkBoxes = getDriver().findElements(By.xpath("//mat-checkbox"));
        WebElement checkBox =checkBoxes.get(n-1);
        checkBox.click();
    }
}
