package components;

import com.codeborne.selenide.Selenide;

public class CalendarComponent {

  public void DateChange(String dateDay,String dateMonth,String dateYear, String dataLocator){
    //$("#dateOfBirthInput").click();
    Selenide.$(dataLocator).click();
    Selenide.$(".react-datepicker__month-select").selectOption(dateMonth);
    Selenide.$(".react-datepicker__year-select").selectOption(dateYear);
    Selenide.$(String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", dateDay)).click();
  }

}
