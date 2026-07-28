package daySeven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Пример работы с типами данных, условиями, циклами и коллекциями
public class Main {

    // Главный метод программы
    public static void main(String... args) {

        // -------------------- Типы данных --------------------

        // Логический тип: хранит true или false
        boolean varBoolean = false;

        // Целочисленные типы
        byte varByte = 100;       // диапазон: -128 ... 127
        short varShort = 1000;    // диапазон: -32768 ... 32767
        int varInt = 100_000_000;
        long varLong = 0L;

        // Символьный тип
        char varChar = 'f';

        // Числа с плавающей точкой
        float varFloat = 0.0F;
        double varDouble0 = 36.0;

        // Строковые значения
        String varString0 = "Selenide";
        String varString1 = "Selenide";

        // Данные о монете
        int coinNominal = 3;
        String coinCurrency = "RUB";

        // -------------------- Операторы --------------------

        // Математические операторы
        int result = 10;

        // Увеличиваем значение на единицу разными способами
        result = result + 1;
        result += 1;
        ++result;

        // Операторы сравнения:
        // >  <  >=  <=  ==  !=

        // Логические операторы:
        // && — И
        // || — ИЛИ
        // !  — НЕ
        // ^  — исключающее ИЛИ

        // -------------------- Условия --------------------

        // Проверка валюты через if / else if / else
        if (coinCurrency.equals("RUB")) {
            System.out.println("Это рубль!");
        } else if (coinCurrency.equals("USD")) {
            System.out.println("Это доллар!");
        } else {
            System.out.println("Ничего не подошло");
        }

        // Та же проверка через switch
        switch (coinCurrency) {
            case "RUB": {
                System.out.println("Это рубль!");
                break;
            }
            case "USD": {
                System.out.println("Это доллар!");
                break;
            }
            default: {
                System.out.println("Ничего не подошло");
            }
        }

        // -------------------- Массивы --------------------

        // Массив строк
        String[] arrayStr = new String[]{"Dima", "Vasya"};

        // Массив целых чисел
        int[] array = {100, 150, -1, 90, 80, 345, 43534};

        // Ищем значение -1 в массиве
        for (int i = 0; i < array.length; i++) {

            // Если значение не равно -1, переходим к следующей итерации
            if (array[i] != -1) {
                continue;
            }

            // Выполняется, когда найдено значение -1
            System.out.println("Радуемся, нашли: " + array[i]);

            // Завершаем цикл
            break;
        }

        // Выводим массив в обратном порядке
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }

        // Перебираем все значения массива через foreach
        for (int value : array) {
            System.out.println(value);
        }

        // Получаем элементы массива по индексу
        System.out.println(array[0]);
        System.out.println(array[1]);
        System.out.println(array[2]);
        System.out.println(array[3]);

        // -------------------- List --------------------

        // Создаём изменяемый список целых чисел
        List<Integer> integerList = new ArrayList<>();

        // Добавляем один элемент
        // int автоматически преобразуется в Integer — boxing
        integerList.add(12);

        // Добавляем сразу несколько элементов
        integerList.addAll(Arrays.asList(34, 3534));

        // Перебираем элементы списка
        // Integer автоматически преобразуется в int — unboxing
        for (int value : integerList) {
            System.out.println(value);
        }

        // Выводим список в обратном порядке
        for (int i = integerList.size() - 1; i >= 0; i--) {
            System.out.println(integerList.get(i));
        }

        // -------------------- Set --------------------

        // Set хранит только уникальные значения
        Set<Integer> integerSet = new HashSet<>();

        integerSet.add(1);
        integerSet.add(10);

        // -------------------- Map --------------------

        // Ключ — номер паспорта
        // Значение — объект Human
        Map<Integer, Human> humanByPassport = new HashMap<>();

        humanByPassport.put(
                3434343,
                new Human("Dima", 33, "M")
        );

        humanByPassport.put(
                2342323,
                new Human("Petr", 30, "M")
        );

        humanByPassport.put(
                4535355,
                new Human("Ivan", 20, "M")
        );

        // Получаем все ключи Map
        Set<Integer> passportNumbers = humanByPassport.keySet();

        // Получаем все значения Map
        Collection<Human> humans = humanByPassport.values();

        // Получаем пары ключ-значение
        Set<Map.Entry<Integer, Human>> entrySet =
                humanByPassport.entrySet();

        // Перебираем все пары ключ-значение
        for (Map.Entry<Integer, Human> entry : entrySet) {

            // Ищем человека по номеру паспорта
            if (entry.getKey() == 2342323) {
                System.out.println(
                        "Нашли Петра: " + entry.getValue().getName()
                );
            }
        }
    }

    // Метод принимает любое количество строк
    // и возвращает строковое значение
    public static String someMethod(String... args) {
        return "";
    }
}