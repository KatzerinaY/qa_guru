import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends TestBase{

  String firstName = "firstName",
         lastName = "lastName",
         gender = "Other",
         userEmail = "userEmail@m.ru",
         userNumber = "7056314566",
         subjectsInput1 = "Biology",
         subjectsInput2 = "Physics",
         currentAddress = "Delhi 215",
         uploadPicture = "kater.jpg",
         state = "NCR",
         city  = "Delhi",

         dateMonth = "August",
         dateYear = "1970",
         dateDay = "19";

  @Test
  void selenideSearchTest() {
    open("https://demoqa.com/automation-practice-form");
    $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));

    $("#firstName").setValue(firstName);
    $("#lastName").setValue(lastName);
    $("#userEmail").setValue(userEmail);
    $("#genterWrapper").$(byText(gender)).click();
    $("#userNumber").setValue(userNumber);
    $("#subjectsInput").setValue(subjectsInput1).pressEnter();
    $("#subjectsInput").setValue(subjectsInput2).pressEnter();
    $("[for=hobbies-checkbox-2]").click(); //Reading
    $("[for=hobbies-checkbox-3]").click(); //Music
    $("#currentAddress").setValue(currentAddress);
    $("#uploadPicture").uploadFromClasspath(uploadPicture);

    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOption(dateMonth);
    $(".react-datepicker__year-select").selectOption(dateYear);
    $(".react-datepicker__month").$(byText(dateDay)).click();
  // CSS [attribute*=value]

    $("#state").click();
    $(byText(state)).click();
    $("#city").click();
    $(byText(city)).click();

    $("[id=submit]").click();

    $x("//td[text()='Student Name']").parent().shouldHave(text(firstName+" "+lastName));
    $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text(userEmail));
    $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text(gender));
    $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text(userNumber));
    $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text(dateDay+" "+dateMonth+","+dateYear));
    $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text(subjectsInput1+", "+subjectsInput2));
    $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text("Reading, Music"));
    $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text(uploadPicture));
    $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text(currentAddress));
    $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text(state+" "+city));

//    $("[id=closeLargeModal]").click();
  }
}
