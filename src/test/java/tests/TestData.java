package tests;

public class TestData {

    String pasteValue = """ 
            git config --global user.name  "New Sheriff in Town"
            git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
            git push origin master --force
            """;
    String nameValue = "how to gain dominance among developers";
    String syntaxBash = "Bash";

}
