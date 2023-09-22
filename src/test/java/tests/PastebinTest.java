package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;

public class PastebinTest extends TestBase {

 /* Wasn't sure about @Test annotation and method name, because it is not a test without assertions.
    However, I am putting it in advance so that I can easily add assertions later. */
    @Test
    public void checkNewPaste() {

        mainPage
                .open()
                .removeAdd()
                .createNewPaste(data.pasteValue, data.nameValue);
    }
}
