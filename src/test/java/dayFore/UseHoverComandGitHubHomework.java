package dayFore;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class UseHoverComandGitHubHomework {

    @Test
    void UseHoverComand() {

        open("https://github.com/");
        $(byText("Solutions")).hover();
        $(byText("Enterprises")).click();
        $(".anim-fade-in fast").$(byText("The AI-powered developer platform"));

    }
}
