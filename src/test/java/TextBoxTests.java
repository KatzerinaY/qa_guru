import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.ModalRegistrationForm;
import pages.RegistrationPage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.sleep;

public class TextBoxTests extends TestBase{

  RegistrationPage regPage = new RegistrationPage();
  ModalRegistrationForm regModForm = new ModalRegistrationForm();

  SimpleDateFormat formatterMonth = new SimpleDateFormat("MMMM", Locale.ENGLISH);
  SimpleDateFormat formatterDay = new SimpleDateFormat("dd", Locale.ENGLISH);
  SimpleDateFormat formatterYear = new SimpleDateFormat("yyyy", Locale.ENGLISH);

  Faker faker = new Faker();
  Date birthday = faker.date().birthday(16, 20);

  String  firstName = faker.name().firstName(),
          lastName = faker.name().lastName(),
          gender = "Other",
          userEmail = faker.internet().emailAddress(),
          userNumber = faker.number().digits(10),

          dateMonth = formatterMonth.format(birthday),
          dateYear = formatterYear.format(birthday),
          dateDay = formatterDay.format(birthday), //"19"

          subjectsInput1 = "Biology",
          subjectsInput2 = "Physics",
          currentAddress = faker.address().fullAddress(),
          uploadPicture = "kater.jpg",
          state = "NCR",
          city = "Delhi";

  @Test
  void selenideSearchTest() {

    regPage.openPage();
    regPage.fillFirstName(firstName);
    regPage.fillLastName(lastName);
    regPage.fillUserEmail(userEmail);
    regPage.fillGender(gender);
    regPage.fillUserNumber(userNumber);
    regPage.fillSubjects(subjectsInput1,subjectsInput2);
    regPage.fillHobbies();
    regPage.fillAddress(currentAddress);
    regPage.uploadPicture(uploadPicture);
    regPage.fillBirthday(dateDay,dateMonth,dateYear);
    regPage.fillStateAndCity(state,city);
    sleep(3000);
    regPage.submit();

    regModForm.checkResults(firstName,lastName,
            gender,userEmail,userNumber,
            dateDay,dateMonth,dateYear,
            subjectsInput1,subjectsInput2,
            "Reading, Music",
            uploadPicture,currentAddress,
            state,city);
    sleep(3000);
  }
}
