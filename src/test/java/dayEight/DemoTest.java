package dayEight;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Демонстрационный класс с простым JUnit-тестом
public class DemoTest {

    // Аннотация @Test указывает JUnit,
    // что данный метод является тестом
    @Test
    void demo() {

        // Выводит сообщение в консоль при запуске теста
        System.out.println("DEMO TEST!");

        // Проверяет, что условие является истинным
        // Здесь 3 < 2 — false, поэтому тест специально упадёт
        Assertions.assertTrue(3 < 2);
    }
}