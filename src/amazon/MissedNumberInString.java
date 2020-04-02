package amazon;

/**
 * Here’s a string with numbers from 1-250
 * but it’s missing one number. How will you find the missed number
 */
public class MissedNumberInString {

    static int sum(int first, int last) {
        int sum = 0;
        for (int i = first; i <= last; i++) {
            sum += i ;
        }
        return sum;
    }


    public static void main(String[] args) {
        System.out.println(missedNumber("123457"));
        System.out.println(missedNumber("1314161718"));
        System.out.println(missedNumber("998999909992"));
    }

    static int missedNumber(String s) {
        int firstNum = -1;
        for (int i = 5; i > 0; i--) {
            firstNum = findFirstNumber(s, i);
            if (firstNum != -1) break; // found it
        }
        if (firstNum == -1) {
            throw new IllegalArgumentException("Input string is invalid");
        }
        String numStr = firstNum + "";
        int sum = 0;
        sum += firstNum;
        int lastNum = -1;
        for (int i = 0; i < s.length(); i++) {
            int beginIndex = numStr.length() + (numStr.length() * i);
            int endIndex = beginIndex + numStr.length();
            if (endIndex > s.length()) {
                endIndex = s.length();
            }
            if (beginIndex == endIndex) {
                break;
            }
            numStr = s.substring(beginIndex, endIndex);
            lastNum = Integer.parseInt(numStr);
            sum+= lastNum;
        }

        return sum(firstNum, lastNum) - sum;
    }

    static int findFirstNumber(String s, int digits) {
        int first = Integer.parseInt(s.substring(0, digits));
        int endIndex = digits * 2;
        if (endIndex > s.length()) {
            return -1;
        }
        int second = Integer.parseInt(s.substring(digits, endIndex));
        if (first + 1 != second) {
            return findFirstNumber(s, digits + 1);
        } else {
            return first;
        }
    }
}
