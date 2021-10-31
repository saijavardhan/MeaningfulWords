package permscombs;

import java.util.Set;

public class PermsCombsTest {

    public static void main(String[] args) {
        String input = "working";
        // assuming number of chars in string is n. The number of total possibilities =
        // n + n(n-1) + n(n-1)(n-2) ...... + n (n-1) ...(n-n)
        //the above assuming no duplicate chars in string
        Set<String> result = PermsCombsOfLetters.differentFlagPermutations(input);
        System.out.println("total possible words count : " + result.size());
        System.out.println("total possible words are : " + result);
        System.out.println("meaningful words are : "+PermsCombsOfLetters.englishWordsFound);
    }
}
