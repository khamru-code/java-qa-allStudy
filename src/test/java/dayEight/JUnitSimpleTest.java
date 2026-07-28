package dayEight;

import com.codeborne.selenide.CollectionCondition;
import dayEight.data.Locale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

// Примеры обычных и параметризованных тестов JUnit
public class JUnitSimpleTest {

    // Название теста, которое будет отображаться в отчёте
    @DisplayName("Демонстрационный тест")
    @Test
    void simpleTest() {

        // Проверяет, что переданное условие истинно
        Assertions.assertTrue(3 > 2);
    }

    // Выполняется перед каждым тестовым методом
    @BeforeEach
    void setUp() {

        // Открывает Google перед запуском каждого теста
        open("https://google.com");
    }

    // Передаёт в тест несколько наборов строковых данных
    @CsvSource({
            "Allure TestOps, https://qameta.io",
            "Selenide, https://selenide.org"
    })

    /*
     * Альтернативный вариант:
     * загрузка тестовых данных из файла
     * src/test/resources/testData.csv
     */
    // @CsvFileSource(resources = "/testData.csv")

    // Создаёт отдельный запуск теста для каждой строки из CsvSource
    @ParameterizedTest(
            name = "Адрес {1} должен быть в выдаче Google по запросу {0}"
    )

    // Добавляет тесту несколько тегов
    @Tags({
            @Tag("BLOCKER"),
            @Tag("UI_TEST")
    })
    void productSiteUrlShouldBePresentInResultsOfSearchInGoogleByProductNameQuery(
            String productName,
            String productUrl
    ) {

        // Вводит название продукта в строку поиска и нажимает Enter
        $("[name=q]")
                .setValue(productName)
                .pressEnter();

        // Проверяет, что результаты поиска содержат адрес продукта
        $("#search")
                .shouldHave(text(productUrl));
    }

    // Передаёт в тест по одному строковому значению
    @ValueSource(strings = {
            "Allure TestOps",
            "Selenide"
    })

    // Для каждого значения будет создан отдельный запуск теста
    @ParameterizedTest(
            name = "По запросу {0} должно быть найдено больше пяти результатов"
    )

    // Теги позволяют запускать отдельные группы тестов
    @Tags({
            @Tag("BLOCKER"),
            @Tag("UI_TEST")
    })
    void searchResultsCountTest(String productName) {

        // Выполняет поиск по переданному названию продукта
        $("[name=q]")
                .setValue(productName)
                .pressEnter();

        // Проверяет, что найдено больше пяти результатов
        $$("div.g")
                .shouldHave(CollectionCondition.sizeGreaterThan(5));
    }

    /*
     * Заготовка для параметризованного теста.
     * Метод должен получать локаль и ожидаемый список кнопок,
     * после чего проверять содержимое сайта.
     */
    void selenideSiteShouldContainAllOfButtonsForGivenLocale(
            Locale locale,
            List<String> buttons
    ) {
        // Здесь должна находиться логика теста
    }
}