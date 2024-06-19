package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Indexpage {
    WebDriver driver;
    @FindBy(xpath = "//a[@href='customised.html']")
    WebElement custom;

    public Indexpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public Custompage clickOnCustom() {
        custom.click();

        return new Custompage(driver);
    }
}
