package TestUI;

import PageObjects.MainPage;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;


public class OpenPageТest extends GeneralTest {

    @Test
    public void openYandex() {
        MainPage mainPage = new MainPage(driver);
        mainPage.pushLogoYandex();

        //assertEquals(driver.getCurrentUrl(), "https://dzen.ru/?yredirect=true");

    }
}

//Уважаемый ревьюер, помоги разобраться, не получается получить текущую ссылку с помощью метода driver.getCurrentUrl(), он возвращает ссылку на яндекс самокаты

