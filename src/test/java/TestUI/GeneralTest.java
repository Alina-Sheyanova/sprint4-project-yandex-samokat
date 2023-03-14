package TestUI;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class GeneralTest {
    protected WebDriver driver;

    @Before
    public void startUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/Alina/Desktop/WebDriver/bin/chromedriver_mac64/chromedriver");
//        driver = new ChromeDriver();

        System.setProperty("webdriver.gecko.driver", "/Users/Alina/Desktop/WebDriver/bin/geckodriver");
        driver = new FirefoxDriver();
//
//         driver = new SafariDriver();
//
        //открыть страницу Яндекс.Самокаты
        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}