package stud.anna;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    @Test
    void dragAndDropActions() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        SelenideElement aElement= $("#column-a");
        SelenideElement bElement= $("#column-b");

        actions().clickAndHold(aElement)
                .moveToElement(bElement)
                .release()
                .build().perform();
        $("#column-a header").shouldHave(Condition.text("B"));
        $("#column-b header").shouldHave(Condition.text("A"));
    }

    @Test
    void dragAndDropCommand() {
        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo("#column-b");
        $("#column-a header").shouldHave(Condition.text("B"));
        $("#column-b header").shouldHave(Condition.text("A"));
    }

}
