package TestUI;

import PageObjects.MainPage;
import PageObjects.OrderPage;
import PageObjects.RentPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class OrderTest extends GeneralTest {
    //Заказ через кнопку в хедэре
    @Test
    public void orderHeader() {

        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        mainPage.clickHeaderOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.order("Алина", "Шеянова", "Московская 5", "88005553535");

        RentPage rentPage = new RentPage(driver);
        rentPage.rent("01.01.2023", "12345-привозите быстрее");

        assertTrue(rentPage.checkModalWindowEnabled());
    }

    @Test
    public void orderScrollPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        mainPage.scrollToPushOderButton();
        mainPage.pushOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.order("Алина", "Шеянова", "Московская 5", "88005553535");

        RentPage rentPage = new RentPage(driver);
        rentPage.rent("01.01.2023", "12345-привозите быстрее");

        assertTrue(rentPage.checkModalWindowEnabled());
    }
}
