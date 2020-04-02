package amazon;

import java.util.ArrayList;
import java.util.List;

/**
 * bc
 * ab
 * ca
 * lexicographically 2 > 1, 3 > 2
 * bc < ab, ab < ca
 * relations = b < a, a < c
 *
 *
 * b, a, c
 */
public class Alphabet {
    static List<Character> parseAlphabet(String[] dictionary) {
        List<Character> alphabet = new ArrayList<>();
        for (int i = 0; i < dictionary.length - 1; i++) {
            String word1 = dictionary[i];
            String word2 = dictionary[i + 1];
            // how may words ?
            // We know word1 < word2, aaax < aaay => x < y
            for (int j = 0; j < word1.length() - 1; j++) {
                Character ch1 = word1.charAt(j);
                if (! alphabet.contains(ch1))
                alphabet.add(ch1);
                Character ch2 = word2.charAt(j);
                if (! alphabet.contains(ch2))
                    alphabet.add(ch2);
            }

        }
        return alphabet;
    }

    public static void main(String[] args) {
        System.out.println(parseAlphabet(new String[]{"bc","ab","ca"}));
    }
}
