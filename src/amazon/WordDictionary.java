
package amazon;

import java.util.HashSet;
import java.util.Set;

public class WordDictionary {
    private static String[] dictionary = new String[]{"word", "list"};
    private static String[] words = new String[]{"paris", "wordlist"};

    public static void main(String[] args) {
        Set<String> dictionarySet = Set.of(dictionary);
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