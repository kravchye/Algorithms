package interview.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrayTask {
    // Task 1
    public boolean hasUniqueCharacters(String str) {
        if (str == null) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return true;
                }
            }
        }
        return true;
    }

    public boolean hasUniqueCharacters2(String str) {
        if (str == null) {
            return false;
        }
        Set<Character> charSet = new HashSet<>(str.length());
        for (char ch : str.toCharArray()) {
            if (charSet.contains(ch)) {
                return true;
            } else {
                charSet.add(ch);
            }
        }
        return true;
    }

    public static boolean hasUniqueCharacters3(String str) {
        boolean[] charset = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charset[val] == true) {
                return false;
            } else {
                charset[val] = true;
            }
        }
        return true;
    }

    // Task 2 - Reverse string
    public static String reverse(String str) {
        int begin = 0;
        int end = str.length() - 1;
        char[] arr = str.toCharArray();
        while (end > begin) {
            char temp = arr[begin];
            arr[begin] = arr[end];
            arr[end] = temp;
            end--;
            begin++;
        }
        return new String(arr);
    }

    // Task 3
    public static String removeDups(String str) {
        if (str == null) return "";
        char[] a = str.toCharArray();
        int nElems = a.length;
        if (nElems < 2) return str;
        for (int i = 0; i < nElems; i++) {
            for (int j = i + 1; j < nElems; j++) {
                if (a[i] == a[j]) {
                    for (int k = j; k < nElems - 1; k++) {
                        a[k] = a[k + 1];
                    }
                    j--;
                    nElems--;
                }
            }
        }

        return new String(a, 0, nElems);
    }

    // Task 4 - anagrams
    public static boolean isAnagram(String first, String second) {
        String positive = first.toLowerCase();
        String negative = second.toLowerCase();

        if (positive.length() != negative.length()) {
            return false;
        }
        int diff = 0;
        int counts[] = new int[26];
        //  go through first array
        for (int i = 0; i < positive.length(); i++) {
            // get char id by String.charAt(ch) method
            int cId = positive.charAt(i) - 97;
            if (counts[cId] >= 0) {
                // if already exist increment
                counts[cId]++;
                diff++;
            } else {
                // else decrement
                counts[cId]--;
                diff--;
            }
        }
        for (int i = 0; i < negative.length(); i++) {
            // get char id by String.charAt(ch) method
            int cId = negative.charAt(i) - 97;
            if (counts[cId] <= 0) {
                // if already exist decrement
                counts[cId]++;
                diff++;
            } else {
                // else increment
                counts[cId]--;
                diff--;
            }
        }
//        for (int counter : counts) {
//            if (counter != 0) {
//                return false;
//            }
//        }


        // TODO Optimization can we do it in O(N) by in/de-crementing some variable

        return diff == 0;
    }

    public static boolean isAnagram2(String first, String second) {
        if ((first == null && second == null)
                || first.length() != second.length()
                || first.length() == 0) {
            return false;
        }
        String fLowercase = first.toLowerCase();
        String sLowercase = second.toLowerCase();

        Map<Character, Integer> map = new HashMap<>(first.length() + second.length());
        // a->2, e.g. the value is incremented twice
        // b->-2, e.g. the value is decremented twice
        for (char ch : fLowercase.toCharArray()) {
            Integer num = map.get(ch);
            map.put(ch, num != null ? ++num : 1);
        }
        for (char ch : sLowercase.toCharArray()) {
            Integer num = map.get(ch);
            map.put(ch, num != null ? --num : -1);
        }
        for (Map.Entry<Character, Integer> entries : map.entrySet()) {
            if (entries.getValue() != 0) {
                return false;
            }
        }
        // return true if all entry values equal to 0
        return true;
    }

    public static boolean isAnagram3(String first, String second) {
        if ((first == null && second == null)
                || first.length() != second.length()
                || first.length() == 0) {
            return false;
        }
        String fLowercase = first.toLowerCase();
        String sLowercase = second.toLowerCase();
        int[] arr = new int[26];
        int diff = 0;
        // if character present in the array increment diff
        for (int i = 0; i < fLowercase.length(); i++) {
            int num = fLowercase.charAt(i) - 97;
            if (arr[num] >= 0) {
                diff++;
                arr[num]++;
            } else {
                diff--;
                int value = arr[num];
                arr[num] = ++value;
            }
        }
        // otherwise decrement it

        // for the second array do the opposite operation
        for (int i = 0; i < sLowercase.length(); i++) {
            int num = sLowercase.charAt(i) - 97;
            if (arr[num] <= 0) {
                diff++;
                arr[num]++;
            } else {
                diff--;
                int value = arr[num];
                arr[num] = ++value;
            }
        }
        return diff == 0;

    }

    private static char[] replaceSpaceInString(char[] str) {
        int spaceCounter = 0;
        int length = str.length;

        //First lets calculate number of spaces
        for (int i = 0; i < length; i++) {
            if (str[i] == ' ')
                spaceCounter++;
        }

        //calculate new size
        int newLength = length + 2 * spaceCounter;

        char[] newArray = new char[newLength + 1];
        newArray[newLength] = '\0';


        for (int i = 0, newArrayPosition = 0; i < length; i++) {
            if (str[i] == ' ') {
                newArray[newArrayPosition] = '%';
                newArray[newArrayPosition + 1] = '2';
                newArray[newArrayPosition + 2] = '0';
                newArrayPosition = newArrayPosition + 3;
            } else {
                newArray[newArrayPosition] = str[i];
                newArrayPosition++;
            }
        }
        return newArray;
    }

    private static char[] replaceSpaceInString2(char[] str) {
        if (str == null) return new char[]{};
        // calculate spaces
        int spaces = 0;
        for (char ch : str) {
            if (ch == ' ') spaces++;
        }
        // define new array = origArr.length + spaces
        char[] newArr = new char[str.length + 2 * spaces];
        int newArrayIdx = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                newArr[newArrayIdx++] = '%';
                newArr[newArrayIdx++] = '2';
                newArr[newArrayIdx++] = '0';
            } else {
                newArr[newArrayIdx++] = str[i];
            }
        }
        return newArr;
    }

    private static int[][] rotateMatrix(int matrix[][], int n) {
        int[][] rotatedMatrix = new int[n][n];
        for (int r = 0; r < matrix.length; r++) {
            for (int c = matrix[r].length - 1; c >= 0; c--) {
                rotatedMatrix[r][n - c - 1] = matrix[c][r];
            }
        }
        return rotatedMatrix;
    }

    static void displayMatrix(int mat[][], int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public static void setZeros(int[][] matrix) {
       int row[] = new int[matrix.length];
       int col[] = new int[matrix[0].length];
       // mark 0 ro2 or columns
       for (int i=0; i < matrix.length; i++) {
           for (int j=0; j < matrix[i].length; j++) {
               if (matrix[i][j] == 0) {
                   row[i] = 1;
                   col[j] = 1;
               }
           }
       }
        for (int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix[i].length; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static boolean isRotated(String s1, String s2) {
        if (s1 == null && s2 == null
        || s1.length() == 0 || s2.length() == 0) {
            return false;
        }
        String s3 = s1.concat(s2);
        return s3.contains(s2);
    }

    public static void main(String[] args) {
        // Task 1
        System.out.println(hasUniqueCharacters3("abca"));
        // Task 2
        System.out.println(reverse("abcdef"));
        // Task 3
        System.out.println(removeDups("abcba"));
        // Task 4
        System.out.println(isAnagram("abcdeA", "edcaba"));
        System.out.println(isAnagram2("abcdeA", "edcaba"));
        System.out.println(isAnagram3("abcdeA", "edcaba"));
        // Task 5
        System.out.println(replaceSpaceInString("I am".toCharArray()));
        System.out.println(replaceSpaceInString2("I am".toCharArray()));
        // Task 6
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        displayMatrix(rotateMatrix(matrix, 3), 3);

        // Task 7
        int[][] zeroMatrix = new int[][]{{0, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        setZeros(zeroMatrix);
        displayMatrix(zeroMatrix, 3);
        // Task 8
        System.out.println(isRotated("abcde", "cdeab"));
    }
}
