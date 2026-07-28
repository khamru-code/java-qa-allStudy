package componentsDaySix;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

// Page Object для страницы регистрации
public class RegistrationPage {

    // Заголовок страницы, который проверяем после открытия
    private final String TITLE_TEXT = "Practice Form";

    // Компоненты страницы
    private CalendarComponent calendarComponent = new CalendarComponent();
    private RegistrationResultsModal registrationResultsModal =
            new RegistrationResultsModal();

    // Элементы формы регистрации
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderChoice = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            userSubjectsInput = $("#subjectsInput"),
            userHobbiesChoice = $("#hobbiesWrapper"),
            pictureUpload = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateDropdown = $("#state"),
            cityDropdown = $("#city"),
            stateAndCityChoice = $("#stateCity-wrapper"),
            submitButton = $("#submit");

    // Открывает страницу и проверяет её заголовок
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".text-center").shouldHave(text(TITLE_TEXT));

        // Удаление элементов, которые могут перекрывать кнопку Submit
        // executeJavaScript("$('#fixedban').remove()");
        // executeJavaScript("$('footer').remove()");

        return this;
    }

    // Заполняет поле имени
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    // Заполняет поле фамилии
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    // Заполняет поле электронной почты
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    // Выбирает пол по переданному тексту
    public RegistrationPage setGender(String value) {
        genderChoice.$(byText(value)).click();
        return this;
    }

    // Заполняет номер телефона
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    // Открывает календарь и выбирает дату рождения
    public RegistrationPage setBirthDate(
            String day,
            String month,
            String year
    ) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    // Вводит предмет и подтверждает выбор клавишей Enter
    public RegistrationPage setSubjects(String value) {
        userSubjectsInput.setValue(value).pressEnter();
        return this;
    }

    // Выбирает увлечение по тексту
    public RegistrationPage setHobbies(String value) {
        userHobbiesChoice.$(byText(value)).click();
        return this;
    }

    // Загружает файл из папки src/test/resources
    public RegistrationPage setPicture(String value) {
        pictureUpload.uploadFromClasspath(value);
        return this;
    }

    // Заполняет поле текущего адреса
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    // Открывает список штатов и выбирает нужное значение
    public RegistrationPage setState(String value) {
        stateDropdown.click();
        stateAndCityChoice.$(byText(value)).click();
        return this;
    }

    // Открывает список городов и выбирает нужное значение
    public RegistrationPage setCity(String value) {
        cityDropdown.click();
        stateAndCityChoice.$(byText(value)).click();
        return this;
    }

    // Отправляет заполненную форму
    public RegistrationPage submit() {
        submitButton.click();
        return this;
    }

    // Проверяет появление модального окна с результатами
    public RegistrationPage verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();
        return this;
    }

    // Проверяет конкретное значение в таблице результатов
    public RegistrationPage verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);
        return this;
    }
}