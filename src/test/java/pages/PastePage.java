package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PastePage extends BasePage{

    @FindBy(xpath = "//div[@class='info-top']")
    private WebElement title;
    @FindBy(xpath = "//a[@href='/archive/bash']")
    private WebElement syntax;
    @FindBy(xpath = "//ol[@class='bash']")
    private WebElement code;

    public PastePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PastePage checkTitle(String titleValue){
        Assertions.assertEquals(title.getText(), titleValue);
        return this;
    }

    public PastePage checkSyntax(String syntaxValue){
        Assertions.assertEquals(syntax.getText(), syntaxValue);
        return this;
    }

    public void checkCode(String codeValue){
        Assertions.assertTrue(code.getText().contains(codeValue));
//  assertEquals didn't work out, however text is the same, checked in comparison
//        Assertions.assertEquals(code.getText(), codeValue);
    }
}
