package componentsDaySix;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

// Компонент для работы с модальным окном результатов регистрации
public class RegistrationResultsModal {

    // Проверяет, что модальное окно появилось
    // и содержит ожидаемый заголовок
    public void verifyModalAppears() {

        // Ожидает появления модального окна
        $(".modal-dialog")
                .should(appear);

        // Проверяет текст заголовка модального окна
        $("#example-modal-sizes-title-lg")
                .shouldHave(text("Thanks for submitting the form"));
    }

    // Проверяет значение в строке таблицы результатов
    public void verifyResult(String key, String value) {

        // Находит ячейку по названию поля, например "Student Name"
        // Поднимается к родительской строке таблицы
        // и проверяет, что строка содержит ожидаемое значение
        $(".table-responsive")
                .$(byText(key))
                .parent()
                .shouldHave(text(value));
    }
}