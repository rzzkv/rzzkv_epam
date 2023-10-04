package tests.helpers;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.Tab;
import java.time.Duration;

abstract public class CommonConditions {
    protected WebDriver driver;
    protected SoftAssertions softly = new SoftAssertions();
    protected Tab tab = new Tab();

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
