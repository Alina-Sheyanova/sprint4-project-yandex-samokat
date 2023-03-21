package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentPage {
    private final WebDriver driver;
    //локатор для поля начала аренды
    private final By startDateRent = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    //локатор для поля срока аренды
    private final By periodRent = By.className("Dropdown-control");
    // Локатор списка срока аренды
    private final By selectPeriodRent = By.xpath(".//*[(@role ='option' and text()='трое суток')]");
    // Локатор цвета  "Черный жемчуг"
    private final By checkBoxColourBlackPearl = By.xpath(".//input[@id='black']");
    // Локатор цвета  "Серая безысходность"
    private final By checkBoxColourGreyDespair = By.xpath(".//input[@id='grey']");
    //локатор для поля комментарий
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //локатор для кнопки "Назад"
    private final By previousButton = By.xpath("Button_Button__ra12g Button_Middle__1CSJM Button_Inverted__3IF-i");
    //локатор для кнопки "Заказать"
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Локатор для кнопки "Да"
    private final By acceptOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    //Локатор для модального окна заказа
    private final By modalWindow = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    //Ввод даты начала аренды
    public void inputStartDateRent(String startDate) {
        driver.findElement(startDateRent).sendKeys(startDate);
        driver.findElement(startDateRent).sendKeys(Keys.ENTER);
    }

    //Выбор срока аренды
    public void choicePeriodRent() {
        driver.findElement(periodRent).click();
        driver.findElement(selectPeriodRent).click();
    }

    //Выбор цвета "Черный жемчуг"
    public void choiceColourBlack() {
        driver.findElement(checkBoxColourBlackPearl).click();
    }

    //Выбор цвета "Серая безысходность"
    public void choiceColourGrey() {
        driver.findElement(checkBoxColourGreyDespair).click();
    }

    //ВВод комментария
    public void inputComment(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    //Нажатие на кнопку "Назад"
    public void pushPreviousButton() {
        driver.findElement(previousButton).click();
    }

    //Нажатие на кнопку "Заказать"
    public void pushOrderButton() {
        driver.findElement(orderButton).click();
    }

    //Нажатие на кнопку "Да"
    public void pushAcceptOrderButton() {
        driver.findElement(acceptOrderButton).click();
    }

    //Проверка видимости модального окна
    public boolean checkModalWindowEnabled() {
        return driver.findElement(modalWindow).isEnabled();
    }

    //Заказ самоката
    public void rent(String startDate, String comment) {
        inputStartDateRent(startDate);
        choicePeriodRent();
        choiceColourBlack();
        inputComment(comment);
        pushOrderButton();
        pushAcceptOrderButton();
    }
}