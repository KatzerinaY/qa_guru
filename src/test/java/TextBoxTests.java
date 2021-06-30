import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {


  @BeforeAll
  static void setUpConfig() {
    Configuration.browser = "chrome";
    Configuration.startMaximized = true;

  }

  @Test
  void selenideSearchTest() {
    open("https://demoqa.com/automation-practice-form");

    $("[id=firstName]").setValue("firstName");
    $("[id=lastName]").setValue("lastName");
    $("[id=userEmail]").setValue("userEmail@m.ru");
    $("[id=userNumber]").setValue("70563145665");
    $("[id=subjectsInput]").setValue("subjectsInput");
    $("[id=currentAddress]").setValue("currentAddress");
    $("[for=gender-radio-2]").click();
    $("[for=hobbies-checkbox-2]").click();

//    $x("//div[@id='state']/div/div/div").click();
//    $x("react-select-3-option-0").click();
//
//    $x("//div[@id='city']/div/div").click();
//    $x("react-select-4-option-0").click();

    $("[id=submit]").click();
    $("[id=closeLargeModal]").click();
  }





}
