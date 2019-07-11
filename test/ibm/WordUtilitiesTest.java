package ibm;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

public class WordUtilitiesTest {
    private WordUtilities wordUtils;
    private String filePath;

    // Test Plan
    // 1. Make a word File path initialization as Environmental Variable
    // 2. Do word count test

    @Before
    public void setUp() {
        // Initialization block
        wordUtils = new WordUtilities();
        filePath = System.getProperty("word.file.path");
    }

    // Positive scenario
    @Test
    public void testWordCounts() {
        filePath = System.getProperty("word.file.path");
        File file = new File(filePath);
        try {
            JSONObject result = wordUtils.getUniqueWordCountFrom(file);
            Assert.assertEquals(3, result.getInt("is"));
        } catch (FileNotFoundException | JSONException e) {
            Assert.assertFalse(e.getMessage(), true);
        }
    }

}
