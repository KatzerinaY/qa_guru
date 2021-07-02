import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

  @BeforeAll
  public static void setUp() {
    Configuration.browser = "chrome";
    Configuration.startMaximized = true;
  }
}
