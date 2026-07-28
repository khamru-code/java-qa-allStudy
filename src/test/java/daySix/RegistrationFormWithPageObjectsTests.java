package daySix;

import componentsDaySix.RegistrationPage;
import org.junit.jupiter.api.Test;

// Тест заполнения формы регистрации с использованием Page Object
public class RegistrationFormWithPageObjectsTests extends TestBase {

    // Объект страницы регистрации
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillPracticeFormTest() {

        // Тестовые данные пользователя
        String firstName = "Ruslan";
        String lastName = "Khammatov";
        String fullName = firstName + " " + lastName;

        String userEmail = "khamru@gmail.com";
        String gender = "Male";
        String userNumber = "9873321535";

        // Данные для даты рождения
        String birthYear = "2002";
        String birthMonth = "July";
        String birthDay = "03";

        // Формат даты, который ожидается в таблице результатов
        String birthDate = birthDay + " " + birthMonth + "," + birthYear;

        // Выбранные предметы
        String subject1 = "English";
        String subject2 = "Physics";
        String subjects = subject1 + ", " + subject2;

        // Выбранные увлечения
        String hobby1 = "Music";
        String hobby2 = "Reading";
        String hobbies = hobby1 + ", " + hobby2;

        // Имя загружаемого файла
        String img = "image.png";

        String currentAddress = "Test address";
        String state = "Uttar Pradesh";
        String city = "Agra";

        // Формат штата и города в таблице результатов
        String stateAndCity = state + " " + city;

        // Открываем страницу и заполняем форму
        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate(birthDay, birthMonth, birthYear)
                .setSubjects(subject1)
                .setSubjects(subject2)
                .setHobbies(hobby1)
                .setHobbies(hobby2)
                .setPicture(img)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit();

        // Проверяем появление модального окна
        // и значения в таблице результатов
        registrationPage.verifyResultsModalAppears()
                .verifyResult("Student Name", fullName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", gender)
                .verifyResult("Mobile", userNumber)
                .verifyResult("Date of Birth", birthDate)
                .verifyResult("Subjects", subjects)
                .verifyResult("Hobbies", hobbies)
                .verifyResult("Picture", img)
                .verifyResult("Address", currentAddress)
                .verifyResult("State and City", stateAndCity);
    }
}