

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    String url="https://nichethyself.com/tourism/home.html";
    WebDriver driverInitialize() throws IOException {
        Properties properties=new Properties();
        FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir")+"/src/main/java/BrowserProperties/browser.properties");
        properties.load(fileInputStream);
        String browser=properties.getProperty("Browser");
        if (browser.contains("chrome")){
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();

        }else if (browser.contains("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver=new FirefoxDriver();
        } else if (browser.contains("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();

        } else
            System.out.println("driver config is not setup");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.manage().window().maximize();
        return driver;
    }

    @BeforeTest(alwaysRun = true)
    void setupBrowser() throws IOException {

        driver=driverInitialize();
        driver.get(url);

    }
    @AfterTest
    void close(){
        driver.quit();
    }
}
