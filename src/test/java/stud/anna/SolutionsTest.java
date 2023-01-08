package stud.anna;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SolutionsTest {
    @Test
    void enterprizeTest() {
        step("Открыть гитхаб", () -> {
            open("https://github.com/");
        });
        step("Выбрать меню Solutions -> Enterprize", () -> {
            $(".header-menu-wrapper").find(byText("Solutions")).hover();
            $(byText("Enterprise")).click();
        });
        step("Убедиться, что загрузилась нужная страница", () -> {
            $(".enterprise-hero").shouldHave(text("Build like the best"));
        });
    }
}
