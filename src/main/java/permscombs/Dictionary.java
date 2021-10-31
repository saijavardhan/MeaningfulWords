package permscombs;

import java.util.Arrays;
import java.util.List;

public class Dictionary {
    private static List<String> englishWordsList = Arrays.asList("work", "working", "king", "nik", "gin", "wok", "true", "school");

    public static boolean  isEnglishWord(String word) {
        return englishWordsList.contains(word.toLowerCase());
    }
}
