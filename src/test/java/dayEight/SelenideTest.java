package dayEight;

import com.codeborne.selenide.CollectionCondition;
import dayEight.data.Locale;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

// Параметризованный тест для проверки меню сайта Selenide
// на разных языках
public class SelenideTest {

    // Метод-поставщик тестовых данных
    // Возвращает локаль и ожидаемый список пунктов меню
    static Stream<Arguments> selenideLocaleDataProvider() {
        return Stream.of(

                // Данные для английской версии сайта
                Arguments.of(
                        Locale.EN,
                        List.of(
                                "Quick start",
                                "Docs",
                                "FAQ",
                                "Blog",
                                "Javadoc",
                                "Users",
                                "Quotes"
                        )
                ),

                // Данные для русской версии сайта
                Arguments.of(
                        Locale.RU,
                        List.of(
                                "С чего начать?",
                                "Док",
                                "ЧАВО",
                                "Блог",
                                "Javadoc",
                                "Пользователи",
                                "Отзывы"
                        )
                )
        );
    }

    // Указывает, из какого метода брать тестовые данные
    @MethodSource("selenideLocaleDataProvider")

    // Создаёт отдельный запуск теста для каждого набора данных
    @ParameterizedTest(
            name = "Для локали {0} отображаются кнопки {1}"
    )

    // Тег для группировки и отдельного запуска тестов
    @Tag("BLOCKER")
    void selenideSiteShouldContainAllOfButtonsForGivenLocale(
            Locale locale,
            List<String> buttons
    ) {

        // Открывает русскую версию сайта Selenide
        open("https://ru.selenide.org/");

        // Находит в переключателе языков ссылку с названием локали
        // locale.name() вернёт EN или RU
        $$("#languages a")
                .find(text(locale.name()))
                .click();

        // Находит все ссылки основного меню
        $$(".main-menu-pages a")

                // Оставляет только видимые элементы
                .filter(visible)

                // Проверяет, что тексты пунктов меню
                // совпадают с ожидаемым списком
                .shouldHave(texts(buttons));
    }
}