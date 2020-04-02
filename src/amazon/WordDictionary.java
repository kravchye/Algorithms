
package amazon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordDictionary {
    private static String[] dictionary = new String[]{"word", "list"};
    private static String[] words = new String[]{"paris", "wordlist"};

    static boolean wordBreak(String word, Set<String> dictionary, int startPos) {
        // base case
        //    startPos == word.length => return true
        if (startPos == word.length()) {
            return true;
        }
        for (String a: dictionary) {
            // get start and end position
            int end = startPos + a.length();
            if (end > word.length()) {
                continue;
            }
            // split the word
            String subWord = word.substring(startPos, end);
            // if the word in the dictionary
            if (a.equals(subWord)) {
                return wordBreak(word, dictionary, end);
            }
        }
        return false;
        // recursive call with the rest part of the word
    }



    static boolean dynamicWordBreak(String s, Set<String> dict) {
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        for (int i = 0; i < s.length(); i ++) {
            if (!result[i]) continue; // calculate from the matched position only
            for (String d: dict) {
                int end = i + d.length();
                if (end > s.length() || result[end]) {
                    continue;
                }
                String subWord = s.substring(i, end);
                if (subWord.equals(d)) {
                    result[end] = true;
                }
            }

        }
        return result[s.length()];
    }

    public static void main(String[] args) {
//        myFirstSolution();
//        wordBreak("wordlist", new HashSet<>(Arrays.asList(dictionary)), 0);
        dynamicWordBreak("wordlist", new HashSet<>(Arrays.asList(dictionary)));
    }

    private static void myFirstSolution() {
        Set<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        Set<String> result = new HashSet<>();
        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                String first = word.substring(0, i+1);
                if (!dictionarySet.contains(first)) {
                    continue;
                }
                String second = word.substring(i+1, word.length());
                if (dictionarySet.contains(second)) {
                    result.add(word);
                }
            }
        }
        result.forEach(System.out::println);
    }
}