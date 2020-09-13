package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import static support.TestContext.getDriver;
import static support.TestContext.getExecutor;

public class Page {
    protected String url;

    public Page() {
        PageFactory.initElements(getDriver(), this);
    }

    public void open() {
        getDriver().get(url);
    }

    protected void clickWithJS(WebElement element) {
        getExecutor().executeScript("arguments[0]", "click()", element);
    }
}
