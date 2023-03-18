package uitest;

import pageobjects.MainPage;
import pageobjects.OrderPage;
import pageobjects.RentPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTestParametrized extends BaseTest {
    private final String firstName;
    private final String lastName;
    private final String deliveryAddress;
    private final String phoneNumber;
    private final String startDateRent;
    private final String commentField;

    public OrderTestParametrized(String firstName, String lastName, String deliveryAddress, String phoneNumber, String startDateRent, String commentField) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deliveryAddress = deliveryAddress;
        this.phoneNumber = phoneNumber;
        this.startDateRent = startDateRent;
        this.commentField = commentField;
    }

    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][]{
                {"Алина", "Шеянова", "Московская 5", "88003333311", "16.03.2023", "Вези быстрее самокат-123"},
                {"Анатолий", "Цой", "Ленина 11", "89550038899", "11.04.2023", "Быстреееее"},
        };
    }
    //Заказ через кнопку в хедэре
    @Test
    public void testOrderHeaderButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.pushHeaderOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.order(firstName, lastName, deliveryAddress, phoneNumber);

        RentPage rentPage = new RentPage(driver);
        rentPage.rent(startDateRent, commentField);

        assertTrue(rentPage.checkModalWindowEnabled());
    }

    //Заказ через кнопку в серелине страницы
    @Test
    public void testOrderMiddlePageButton() {
        MainPage mainPage = new MainPage(driver);
        mainPage.scrollToPushOrderButton();
        mainPage.pushOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.order(firstName, lastName, deliveryAddress, phoneNumber);

        RentPage rentPage = new RentPage(driver);
        rentPage.rent(startDateRent, commentField);

        assertTrue(rentPage.checkModalWindowEnabled());
    }
}
