import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void testSolutionsEnterprize() {
        open("https://github.com");
        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        $("[href='/enterprise']").click();
        $(".application-main ").shouldHave(text("Build like the best"));
    }
}
