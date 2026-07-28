package daySix;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

// Базовый класс с общими настройками для всех тестов
public class TestBase {

    // Выполняется один раз перед запуском всех тестов в классе
    @BeforeAll
    static void beforeAll() {

        // Устанавливает размер окна браузера
        Configuration.browserSize = "1920x1080";

        // Устанавливает основной адрес сайта
        // Теперь в тестах можно писать open("/automation-practice-form")
        Configuration.baseUrl = "https://demoqa.com";
    }
}