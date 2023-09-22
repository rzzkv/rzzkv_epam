import core.TestBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PastebinTest extends TestBase {
    @Test
    public void checkNewPaste(){
        MainPage mainPage = new MainPage();
        mainPage.createNewPaste("Hello from WebDriver", "helloweb");
    }
}
