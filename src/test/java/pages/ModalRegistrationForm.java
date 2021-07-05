package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ModalRegistrationForm {

  public void checkResults(String firstName, String lastName, 
                           String gender, String userEmail, String userNumber,
                           String dateDay, String dateMonth, String dateYear,
                           String subjectsInput1, String subjectsInput2,
                           String hobbies, String uploadPicture, String currentAddress,
                           String state, String city) {

    SelenideElement table =  $(".table-responsive");
    table.$(byText("Student Name")).sibling(0).shouldHave(text(firstName+" "+lastName));
    table.$(byText("Student Email")).sibling(0).shouldHave(text(userEmail));
    table.$(byText("Gender")).sibling(0).shouldHave(text(gender));
    table.$(byText("Mobile")).sibling(0).shouldHave(text(userNumber));
    table.$(byText("Date of Birth")).sibling(0).shouldHave(text(dateDay+" "+dateMonth+","+dateYear));
    table.$(byText("Subjects")).sibling(0).shouldHave(text(subjectsInput1+", "+subjectsInput2));
    table.$(byText("Hobbies")).sibling(0).shouldHave(text(hobbies));
    table.$(byText("Picture")).sibling(0).shouldHave(text(uploadPicture));
    table.$(byText("Address")).sibling(0).shouldHave(text(currentAddress));
    table.$(byText("State and City")).sibling(0).shouldHave(text(state+" "+city));
  }
}
