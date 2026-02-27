package StepDefinitions;

import Drivers.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.time.Duration;

public class Hooks {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        //Read headless flag from JVM (-Dheadless=true/false)
        if (Boolean.parseBoolean(System.getProperty("headless"))) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }

        driver = new ChromeDriver(options);
        DriverManager.setDriver(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @AfterStep
    public void afterStep() {
        System.out.println("================ AFTER STEP ================");
        driver = DriverManager.getDriver();
        if (driver == null) return;
        try {
            new WebDriverWait(driver, Duration.ofSeconds(3))
                    .until(d -> ((JavascriptExecutor) d)
                            .executeScript("return document.readyState").equals("complete"));
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Step Screenshot", "image/png",
                    new ByteArrayInputStream(screenshot), ".png");

        } catch (WebDriverException e) {
            System.out.println("Screenshot skipped (browser changing state): " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
