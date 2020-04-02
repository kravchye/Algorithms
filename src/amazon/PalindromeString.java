package amazon;

import java.util.Scanner;

/**
 * Palindrome is a string,
 * which when read in both forward and backward way is same.
 */
public class PalindromeString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String reverse = "";
        for (int i = input.length() - 1; i >=0; i--) {
            reverse += input.charAt(i);
        }
        System.out.println(input.equals(reverse));
    }
}
