package TestUI;

import PageObjects.MainPage;
import org.junit.Test;

public class ListOfQuestionTest extends GeneralTest {
    @Test
    public void ListOfQuestionEquals() {
        MainPage mainPage = new MainPage(driver);
        mainPage.listEquals();
    }
}
