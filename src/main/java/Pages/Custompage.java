package Pages;
import ResuseMethods.Resusable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import java.util.Set;

public class Custompage extends Resusable {
    static String window = "";
    WebDriver driver;
    @FindBy(css = "#days")
    WebElement dropDown;
    @FindBy(xpath = "//div[@class=\"checkbox-inline\"]/child::label[text()='England']")
    WebElement country;
    @FindBy(xpath = "//ul[@class=\"nav navbar-nav navbar-right\"]/child::li/child::button[@class='link']")
    WebElement contactUs;
    @FindBy(xpath = "//div[@class=\"card-header\"]/child::a")
    WebElement contactWindowSearchButton;
    @FindBy(xpath = "(//button[@type=\"submit\"])[1]")
    WebElement submit;

    Custompage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void tabSwitch() {
        Set<String> set = driver.getWindowHandles();
        for (String s : set) {
            driver.switchTo().window(s);
            if (driver.getCurrentUrl().contains("customised.html")) {
                window = s;
                break;
            }
        }
    }

    public void selectPreferdStay() {
        waitElementForVisibleByLocater(driver, "#days");
        Select select = new Select(dropDown);
        select.selectByVisibleText("Home Stay");
    }

    public void selectCountry() {
        country.click();
    }

    public void selectContact() {
        contactUs.click();
    }

    public void contactWindowSwitch() {
        Set<String> set = driver.getWindowHandles();
        for (String s : set) {
            driver.switchTo().window(s);
            if (driver.getCurrentUrl().contains("contact.html")) {
                waitElementForVisibleByElement(driver, contactWindowSearchButton);
                contactWindowSearchButton.click();
                waitAlert(driver);
                Alert alert=switchAlert(driver);
                alert.sendKeys("London");
                alert.accept();
                driver.close();
                break;
            }
        }
    }

    public void clickOnSubmit() {
        driver.switchTo().window(window);
        submit.click();
        Alert alert=switchAlert(driver);
        String message = alert.getText();
        alert.accept();
        Assert.assertEquals(message, "Form is submitted successfully");
    }

}
