package tests.pseudoTests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class SkippedTests {
    @Test(groups = { "smoke", "skipped" })
    void test1() {
        assertTrue(false);
    }

    @Test(groups = { "smoke", "skipped" })
    void test2() {
        assertTrue(false);
    }
}
