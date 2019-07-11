package ibm;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

public class WordCounter {
    public static void main(String[] args) throws IOException {
        if (args[0] == null) {
            throw new RuntimeException("Please define file path");
        }
        WordUtilities wordUtils = new WordUtilities();
        JSONObject wordCounter = wordUtils.getUniqueWordCountFrom(new File(args[0]));
        wordUtils.printJSONObject(wordCounter);
    }
}
