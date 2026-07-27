package dayThree;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearchHomework {

    @Test
    void SelenideSearch() {

        //Открываем необходимый сайт для проверки
        open("https://github.com/selenide/selenide");
        //Открыть wiki в selenide
        $("a[data-tab-item='i5wiki-tab']").click();
        //Проверить наличие в странице Pages страницы SoftAssertions
        $(".js-wiki-more-pages-link").click();
        $("ul[data-filterable-for='wiki-pages-filter']").shouldHave(text("SoftAssertions"));
        //Открыть страницу SoftAssertions и проверить наличие текста для JUnit5
        $("ul[data-filterable-for='wiki-pages-filter']").$(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));
    }

}
