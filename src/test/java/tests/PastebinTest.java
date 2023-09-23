package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.PastePage;

import static java.lang.Thread.sleep;

public class PastebinTest extends TestBase {

    @Test
    public void checkNewPaste() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        PastePage pastePage = new PastePage(driver);

        mainPage
                .open()
                .removeAdd()
                .createNewPaste(data.pasteValue, data.nameValue);
        pastePage
                .checkTitle(data.nameValue)
                .checkSyntax(data.syntaxBash)
                .checkCode(data.pasteValue);

    }
}
