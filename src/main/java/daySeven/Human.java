package daySeven;

// Класс описывает человека и хранит его основные данные
public class Human {

    // Имя человека
    String name;

    // Возраст человека
    int age;

    // Пол человека
    String sex;

    // Конструктор создаёт объект Human
    // и записывает переданные значения в его поля
    public Human(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    // Возвращает имя человека
    public String getName() {
        return name;
    }

    // Возвращает возраст человека
    public int getAge() {
        return age;
    }

    // Возвращает пол человека
    public String getSex() {
        return sex;
    }
}