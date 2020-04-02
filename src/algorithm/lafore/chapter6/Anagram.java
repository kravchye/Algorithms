package algorithm.lafore.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Anagram {
    private static char[] arr;

    public static void main(String[] args) throws IOException {
        String input = readStrings();
        System.out.println(input);
        arr = new char[input.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.charAt(i);
        }
        doAnagram(arr.length);
    }



    private static void doAnagram(int size) {
        if (size == 1) return;
        for (int i = 0; i < size; i++) {
            doAnagram(size - 1);
            if (size == 2) {
                displayWord();
            }
            rotate(size);
        }
    }

    private static void rotate(int size) {
        int position = arr.length - size;
        int i;
        char temp = arr[position];
        for (i = position + 1; i < arr.length; i ++) {
            arr[i-1] = arr[i];
        }
        arr[i - 1] = temp;
    }

    private static void displayWord() {
        System.out.println(new String(arr));
    }

    private static String readStrings() throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        return br.readLine();
    }
}
