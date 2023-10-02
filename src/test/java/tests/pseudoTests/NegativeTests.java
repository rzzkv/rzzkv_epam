package tests.pseudoTests;

import org.testng.annotations.Test;
import static org.testng.AssertJUnit.assertTrue;

public class NegativeTests {
    @Test(groups = { "smoke", "negative" })
    void test1() {
        assertTrue(false);
    }

    @Test(groups = { "smoke", "negative" })
    void test2() {
        assertTrue(false);
    }

    @Test(groups = { "smoke", "negative" })
    void test3() {
        assertTrue(false);
    }

    @Test(groups = { "smoke", "negative" })
    void test4() {
        assertTrue(false);
    }

}