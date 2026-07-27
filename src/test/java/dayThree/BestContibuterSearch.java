package dayThree;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BestContibuterSearch {

    @Test
    void SolntsevSearch() {

        //Открыть страницу репозитория selenide
        open("https://github.com/selenide/selenide");

        //Подвести мышь к первому аватару
        $("a[href='/asolntsev']").shouldBe(visible).hover();
        //Проверка в сплывающем окне
        //$$(".Popover").findBy(visible).shouldHave(text("Andrei Solntsev"));
        $(".Popover").shouldHave(text("Andrei Solntsev"));
    }
}
