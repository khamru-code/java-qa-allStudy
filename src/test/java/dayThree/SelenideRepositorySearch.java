package dayThree;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @Test
    void shouldFindSelenideRepositoryTheTop() {

        //Открыть главную страницу
        open("https://github.com/");
        //Ввести в поле поиска селенида и нажать энтер
        $$("button[aria-label^='Search or jump to']").findBy(visible).click();
        $("[data-target='query-builder.input']").setValue("selenide").pressEnter();
        //Выбрать первый репозиторий из списка найденных
        $$("div[data-testid='results-list'] div").first().$("a").click();
        //Проверка: заголовок selenide/selenide
        $("a[href='/selenide']").shouldHave(exactText("selenide"));
        $("a[href='/selenide/selenide']").shouldHave(exactText("selenide"));

    }
}
