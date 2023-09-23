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
        Assertions.assertTrue(title.getText().contains(titleValue));
        //Assertions.assertTrue(title.toString().contains(titleValue));
        return this;
    }

    public PastePage checkSyntax(String syntaxValue){
        Assertions.assertTrue(syntax.getText().contains(syntaxValue));
        return this;
    }

    public PastePage checkCode(String codeValue){
        Assertions.assertTrue(code.getText().contains(codeValue));
        return this;
    }
}
