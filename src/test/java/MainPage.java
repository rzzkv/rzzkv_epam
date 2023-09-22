import core.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends PageBase {

    @FindBy(id="postform-text")
    private WebElement pasteArea;

    @FindBy(className="newPaste")
    private WebElement pasteExpiration;

    @FindBy(id="select2-postform-expiration-result-3ha6-10M")
    private WebElement pasteExpirationSet;

    @FindBy(id="postform-name")
    private WebElement pasteName;

    @FindBy(className="btn -big")
    private WebElement createPasteBtn;

    public MainPage createNewPaste(String pasteValue, String nameValue){
        driver.get("https://pastebin.com/");
        pasteArea.click();
        pasteArea.sendKeys(pasteValue);
        pasteExpiration.click();
        pasteExpirationSet.click();
        pasteName.click();
        pasteName.sendKeys(nameValue);
        createPasteBtn.click();

        return this;
    }
}
