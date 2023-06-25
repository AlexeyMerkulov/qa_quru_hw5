import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void testSelenideActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        SelenideElement leftRectangle = $("#column-a");
        SelenideElement rightRectangle = $("#column-b");
        leftRectangle.shouldHave(text("A"));
        rightRectangle.shouldHave(text("B"));
        leftRectangle.dragAndDrop(to(rightRectangle));
        leftRectangle.shouldHave(text("B"));
        rightRectangle.shouldHave(text("A"));
    }
}
