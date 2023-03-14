package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;


public class MainPage {
    private WebDriver driver;

    //локатор лого яндекс
    private final By logoYandex = By.className("Header_LogoYandex__3TSOI");
    //локатор лого самокат
    private final By logoSamokat = By.className("Header_LogoScooter__3lsAR");
    //локатор кнопки "Заказать" в хедере
    private By headerOrderButton = By.className("Button_Button__ra12g");
    //локатор кнопки "Статус заказа"
    private final By headerStatusButton = By.className("Header_Link__1TAG7");
    //локатор кнопки "Заказать"
    private final By orderButton = By.xpath(".//button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    // локатор для кнопки принятия куки
    private final By cookieButton = By.id("rcc-confirm-button");
    // локатор для сбора кнопок списка "Вопросы о важном"
    private final By buttonsListQuestion = By.xpath(".//div[@class='accordion__button']");
    // локатор для сбора текстов кнопок списка "Вопросы о важном"
    private final By textListQuestions = By.xpath(".//div[@class='accordion__panel']/p");
    //массив актуальных текстов
    private final String[] actualResultOfQuestion = {"Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."};

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookieButton() {
        driver.findElement(cookieButton).click();
    }

    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }

    public void pushHeaderStatusButton() {
        driver.findElement(headerStatusButton).click();
    }

    public void pushOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void pushLogoYandex() {
        driver.findElement(logoYandex).click();
    }

    public void scrollToPushOderButton() {
        WebElement element = driver.findElement(orderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void listEquals() {
        clickCookieButton();
        scrollToPushOderButton();
        List<WebElement> buttonsQuestionAboutImportant = driver.findElements(buttonsListQuestion);
        for (int i = 0; i < buttonsQuestionAboutImportant.size(); i++) {
            buttonsQuestionAboutImportant.get(i).click();
            List<String> actualResult = Arrays.asList(actualResultOfQuestion);
            assertEquals("Неправильная строка", driver.findElements(textListQuestions).get(i).getText(), actualResult.get(i));
        }
    }
}