package dayEight;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

// Упрощённый пример того, как тестовый фреймворк
// может находить и запускать методы с аннотацией @Test
public class MiniJUnit {

    // Точка входа в программу
    public static void main(String[] args) throws Exception {

        // Получаем все методы, объявленные в классе DemoTest
        Method[] methods = DemoTest.class.getDeclaredMethods();

        // Перебираем найденные методы
        for (Method method : methods) {

            // Проверяем, есть ли у метода аннотация @Test
            Test annotation = method.getAnnotation(Test.class);

            // Если аннотация @Test найдена, запускаем метод
            if (annotation != null) {

                // Создаём новый объект класса DemoTest
                DemoTest instance = DemoTest.class
                        .getConstructor()
                        .newInstance();

                try {
                    // Вызываем найденный тестовый метод
                    method.invoke(instance);
                } catch (Exception e) {

                    // Если при выполнении произошла ошибка,
                    // считаем тест неуспешным
                    System.out.println("TEST BROKEN!!!");

                    // Завершаем всю программу
                    return;
                }

                // Если исключения не произошло,
                // считаем тест успешно выполненным
                System.out.println("TEST PASSED!!!");
            }
        }
    }
}