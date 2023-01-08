package stud.anna;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SoftAssertionsTest {

    @Test
    void softAssertionsShouldHaveJunit5() {
        step("Открыть страницу selenide/selenide", () -> {
            open("https://github.com/selenide/selenide");
        });
        step("Перейти в раздел Wiki проекта", () -> {
            $("#wiki-tab").click();
        });
        step("Убедиться, что в списке страниц (Pages) есть страница SoftAssertions", () -> {
            $(".js-wiki-more-pages-link").click();
            $("#wiki-pages-box").shouldHave(text("SoftAssertions"));
        });
        step("Открыть страницу SoftAssertions, проверить что внутри есть пример кода для JUnit5", () -> {
            $$(byText("SoftAssertions")).find(visible).click();
            $("#wiki-body").shouldHave(text("3. Using JUnit5 extend test class:"));
        });

    }
}
