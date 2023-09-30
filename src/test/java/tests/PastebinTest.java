package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.PastePage;

import static java.lang.Thread.sleep;

public class PastebinTest extends TestBase {

    @Test
    public void checkNewPaste(){
        MainPage mainPage = new MainPage(driver);
        PastePage pastePage = new PastePage(driver);

        mainPage
                .open(data.URL)
                .writeInPaste(data.pasteValue)
                .setSyntaxHighlighting()
                .setPasteExpiration()
                .setPasteName(data.nameValue)
                .createPaste();
        pastePage
                .checkTitle(data.nameValue)
                .checkSyntax(data.syntaxBash)
                .checkCode(data.pasteValue);

    }
}
