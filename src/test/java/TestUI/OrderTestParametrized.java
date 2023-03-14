package TestUI;

import PageObjects.MainPage;
import PageObjects.OrderPage;
import PageObjects.RentPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTestParametrized extends GeneralTest {
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

    @Test
    public void TestOrder() {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickCookieButton();
        mainPage.scrollToPushOderButton();
        mainPage.pushOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.order(firstName, lastName, deliveryAddress, phoneNumber);

        RentPage rentPage = new RentPage(driver);
        rentPage.rent(startDateRent, commentField);

        assertTrue(rentPage.checkModalWindowEnabled());
    }
}
