package ibm;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WordUtilities {

    public JSONObject getUniqueWordCountFrom(File inputfile) throws FileNotFoundException {
        Scanner input = new Scanner(inputfile);

        Map<String, Integer> wordCountMap = new HashMap<>();
        while (input.hasNext()) {
            String word  = input.next();
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }
        return new JSONObject(wordCountMap);
    }

    public void printJSONObject(JSONObject json) {
        System.out.println(json);
    }

}
