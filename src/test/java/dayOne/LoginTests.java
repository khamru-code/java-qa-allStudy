package dayOne;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class LoginTests {

    @Test
    void successfulLoginWithCommentsTest() {
//        Открыть форму авторизации
//        https://qa.guru/cms/system/login
//        Ввести адрес электронной почты
//        Ввести пароль
//        Нажать кнопку "Войти"
//        Нажать на кнопку "Личный кабинет"
//        Проверить успешную авторизацию

//        Открыть форму авторизации
        open("https://school.qa.guru/cms/system/login");

//        Ввести адрес электронной почты
        $("[name=email]").setValue("test@mail.ru");
//        Ввести пароль
        $("[name=password]").setValue("VashTest");
//        Нажать кнопку "Войти"
        $(".btn-success").click();
//        Нажать на кнопку "Личный кабинет"
        $(".with-link").click();

//        Проверить успешную авторизацию
        $("#remake-right-panel").shouldHave(text("Полезные ссылки"));
    }
}
