package permscombs;// Java program for the above approach


import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

class PermsCombsOfLetters {


    static Set<String> englishWordsFound = new HashSet<>();

    static Set<String> differentFlagPermutations(String input) {
        Set<String> finalSet = new HashSet<>();

        String[] arr = input.split("");
        Map<String, Long> countOfChars = countNumberOfCharactersInString(input);
        String[] miniArr = arr;
        //add single letters to set
        for (String s : miniArr) {
            finalSet.add(s);
            if (Dictionary.isEnglishWord(s)) {
                englishWordsFound.add(s);
            }
        }
        // each loop generates combinations of j length letters
        for (int j = 0; j < arr.length - 1; j++) {

            // Stores combinations of j length letters
            Set<String> tmp = new HashSet<>();

            // Traverse the array
            for (String s : arr) {
                for (String value : miniArr) {
                    Map<String, Long> countOfCharsTemp = countNumberOfCharactersInString(value);
                    // to avoid duplicating the chars repetition in a string
                    if (countOfCharsTemp.get(s) == null || countOfCharsTemp.get(s) < countOfChars.get(s)) {
                        // Generate all combinations of length j
                        String tempWord = value + s;
                        tmp.add(tempWord);
                        if (Dictionary.isEnglishWord(tempWord)) {
                            englishWordsFound.add(tempWord);
                        }
                    }
                }
            }

            finalSet.addAll(tmp);
            // minArray assigned to tmp array to add append further chars
            miniArr = tmp.toArray(new String[0]);
        }

        return finalSet;
    }


    private static Map<String, Long> countNumberOfCharactersInString(String a) {
        return a.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Object::toString, Collectors.counting()));
    }

}