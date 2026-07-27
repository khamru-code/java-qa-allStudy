package dayFore;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class UseDrugAndDropComandGitHubHomework {

    @BeforeAll
    static void BeforeAll(){Configuration.baseUrl = "https://the-internet.herokuapp.com";}

    @Test
    void UseDrugAndDropComand() {

        open("/drag_and_drop");
        $("#column-a").dragAndDrop(DragAndDropOptions.to("#column-b"));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));

    }
}
