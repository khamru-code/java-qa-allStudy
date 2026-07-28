package dayFore;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class UseHoverComandGitHubHomework {

    @Test
    void UseHoverComand() {

        //Открыли гитхаб
        open("https://github.com/");
        //Навели мышь на Solutions
        $(byText("Solutions")).hover();
        //Кликнули по Enterprises
        $(byText("Enterprises")).click();
        //Проверили что открылась нужная страница
        $(".anim-fade-in fast").$(byText("The AI-powered developer platform"));

    }
}
