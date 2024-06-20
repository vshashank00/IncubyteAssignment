package ResuseMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Resusable {
    public void waitElementForVisibleByLocater(WebDriver driver,String loc){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#days")));

    }
    public void waitElementForVisibleByElement(WebDriver driver, WebElement element){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
                wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitAlert(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public Alert switchAlert(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        return alert;

    }
}
