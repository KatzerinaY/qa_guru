package pages;

import components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
  CalendarComponent calendar = new CalendarComponent();

  public void openPage() {
    open("https://demoqa.com/automation-practice-form");
    $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
  }

  public void fillFirstName(String firstName) {
      $("#firstName").setValue(firstName);
  }

  public void fillLastName(String lastName) {
    $("#lastName").setValue(lastName);
  }

  public void fillUserEmail(String userEmail) {
    $("#userEmail").setValue(userEmail);
  }

  public void fillGender(String gender) {
    $("#genterWrapper").$(byText(gender)).click();
  }

  public void fillUserNumber(String userNumber) {
    $("#userNumber").setValue(userNumber);
  }

  public void fillSubjects(String subjectsInput1, String subjectsInput2) {
    $("#subjectsInput").setValue(subjectsInput1).pressEnter();
    $("#subjectsInput").setValue(subjectsInput2).pressEnter();
  }

  public void fillHobbies() {
    $("[for=hobbies-checkbox-2]").click(); //Reading
    $("[for=hobbies-checkbox-3]").click(); //Music
  }

  public void fillAddress(String currentAddress) {
    $("#currentAddress").setValue(currentAddress);
  }

  public void uploadPicture(String uploadPicture) {
    $("#uploadPicture").uploadFromClasspath(uploadPicture);
  }

  public void fillBirthday(String dateDay,String dateMonth,String dateYear) {
    calendar.DateChange(dateDay,dateMonth,dateYear, "#dateOfBirthInput");
  }

  public void fillStateAndCity(String state, String city) {
    $("#state").click();
    $(byText(state)).click();
    $("#city").click();
    $(byText(city)).click();
  }

  public void submit() {
    $("[id=submit]").click();
  }
}
