package dayFive;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTestsHomework {

    //Ввели основной размер браузера и его домен
    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }


    @Test
    void practicFormTest() {

        //Открыли сайт
        open("/automation-practice-form");

        //Ввели данные в текстовые поля
        $("#firstName").setValue("Ruslan");
        $("#lastName").setValue("Khammatov");
        $("#userEmail").setValue("khamru@mail.com");

        //Выбрали гендер
        $("#gender-radio-1").click();

        //Ввели еще текстовые данные
        $("#firstName").setValue("Ruslan");
        $("#lastName").setValue("Khammatov");
        $("#userEmail").setValue("khamru@mail.com");
        $("#userNumber").setValue("9879867987");
        $("#currentAddress").setValue("Other adress");


        //Нажали на выбор даты рождения и выбрали из списка необходимую дату
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--008").click();

        //Выбрали English
        $("#subjectsInput").setValue("English").pressEnter();

        //Выбрали хобби
        $("#hobbies-checkbox-1").click();

        //Загрузили изображение на сайте
        $("#uploadPicture").uploadFromClasspath("image.png");

        //Выбрали данные из выпадающего списка
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        //Нажали на кнопку submit
        $("#submit").click();

        //Проверили что появилось окно с введенными данными
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));

    }
}
