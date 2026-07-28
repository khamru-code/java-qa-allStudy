package dayFore;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class UseDrugAndDropComandGitHubHomework {

    //передача основного URL для работы во всех автотестах
    @BeforeAll
    static void BeforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void UseDrugAndDropComand() {

        //Открытие продолжения основного URL
        open("/drag_and_drop");
        //Поменяли места квадрат А и В
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        //Проверка на удачную смену местами
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }
}
