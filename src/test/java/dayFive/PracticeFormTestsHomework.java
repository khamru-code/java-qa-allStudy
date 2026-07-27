package dayFive;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTestsHomework {


    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }


    @Test
    void practicFormTest() {


        open("/automation-practice-form");

        $("#firstName").setValue("Ruslan");
        $("#lastName").setValue("Khammatov");
        $("#userEmail").setValue("khamru@mail.com");

        $("#gender-radio-1").click();

        $("#firstName").setValue("Ruslan");
        $("#lastName").setValue("Khammatov");
        $("#userEmail").setValue("khamru@mail.com");
        $("#userNumber").setValue("9879867987");
        $("#currentAddress").setValue("Other adress");



        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("October");
        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__day--008").click();

        $("#subjectsInput").setValue("English").pressEnter();

        $("#hobbies-checkbox-1").click();

        $("#uploadPicture").uploadFromClasspath("image.png");


        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        $(".modal-content").shouldHave(text("Thanks for submitting the form"));

    }
}
