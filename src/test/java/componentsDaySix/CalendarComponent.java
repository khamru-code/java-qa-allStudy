package componentsDaySix;

import static com.codeborne.selenide.Selenide.$;

// Компонент для работы с календарём выбора даты
public class CalendarComponent {

    // Выбирает месяц, год и день в календаре
    public void setDate(String day, String month, String year) {

        // Выбирает месяц по его названию, например "July"
        $(".react-datepicker__month-select")
                .selectOption(month);

        // Выбирает год, например "2000"
        $(".react-datepicker__year-select")
                .selectOption(year);

        // Выбирает день текущего месяца и исключает дни соседних месяцев
        $(".react-datepicker__day--0" + day
                + ":not(.react-datepicker__day--outside-month)")
                .click();
    }
}