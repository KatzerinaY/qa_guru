package components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

  public void DateChange(String dateDay,String dateMonth,String dateYear, String dataLocator){
    //$("#dateOfBirthInput").click();
    $(dataLocator).click();
    $(".react-datepicker__month-select").selectOption(dateMonth);
    $(".react-datepicker__year-select").selectOption(dateYear);
    $(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", dateDay)).click();
  }

}
