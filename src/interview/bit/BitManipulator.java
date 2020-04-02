package interview.bit;

import java.util.Stack;

public class BitManipulator {
    public static void main(String[] args) {
//        demo();
//
//        // 5.1
        System.out.println("Exercise 5.1");
        updateBits(1000000, 10101,2, 14);
//
//        // 5.2
//        printDecimal("10.12");
        printIntBinary(128);
        printIntBinaryViaStack(128);


    }

    private static void demo() {
        int bitmask = 0x000F;
        int val = 0x2222;
        // prints "2"
        System.out.println(val & bitmask);

        int one = 1;
        System.out.println(~one);
    }

    private static void printIntBinary(final int number) {
        int num = number;
        int[] array = new int[32];
        int idx = 0;
        while (num > 0) {
            int b = num % 2;
            array[idx++] = b;
            num /= 2;
        }
        System.out.print("Java Bit representation of num=" + number + " is ");
        for (int i = idx - 1; i >= 0; i--) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

    private static void printIntBinaryViaStack(final int number) {
        int num = number;
        Stack<Integer> stack = new Stack<>();
        while (num > 0) {
            stack.push(num % 2);
            num /= 2;
        }
        System.out.print("Binary representation(via Stack) of number " + number + " is ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    /**
     * 5.1 You are given two 32-bit numbers, N and M, and two bit positions, i and j.
     * Write a method to set all bits between i and j in N equal to M
     * (e.g., M becomes a substring of N located at i and starting at j).
     * EXAMPLE:
     * Input: N = 10000000000, M = 10101, i = 2, j = 14
     * Output: N = 10001010100
     */
    public static int updateBits(int n, int m, int i, int j) {
        // number with all 1's
        int  allOnes = ~0;
        System.out.println("allOnes = " + Integer.toBinaryString(allOnes));

        // Set all the bits in the left of j
        int left = allOnes << (j + 1);
        System.out.println("left = " + Integer.toBinaryString(left) + " int=" + left);

        // Set all the bits in the right of j
        int right = ((1 << i) - 1);
        System.out.println("right = " + Integer.toBinaryString(right) + " int=" + right);

        // Do Bitwise OR to get all the bits
        // set except in the range from i to j
        int mask = left | right;
        System.out.println("mask = " + Integer.toBinaryString(mask) + " int=" + mask);

        // clear bits j through i
        System.out.println("n = " + Integer.toBinaryString(n) + " int=" + n);
        int masked_n = n & mask;
        System.out.println("masked_n = " + Integer.toBinaryString(masked_n) + " int=" + masked_n);

        // move m into the correct position
        int m_shifted = m << i;
        System.out.println("m = " + Integer.toBinaryString(m) + " int=" + m);
        System.out.println("m_shifted = " + Integer.toBinaryString(m_shifted) + " int=" + m_shifted);

        // return the Bitwise OR of masked_n
        // and shifted_m
        int result = masked_n | m_shifted;
        System.out.println("result = " + Integer.toBinaryString(result) + " int=" + result);
        return result;
    }

    /**
     * Given a (decimal - e.g. 3.72) number that is passed in as a string, print the binary representation.
     * If the number can not be represented accurately in binary, print “ERROR”
     */
    static void printDecimal(String number) {
        int intPart = Integer.parseInt(number.substring(0, number.indexOf(".")));
        System.out.println("intPart =" + Integer.toBinaryString(intPart));
        String intStr = "";
        while (intPart > 0) {
            int r = intPart % 2;
            intPart >>= 1;

            intStr = r + intStr ;
        }
        System.out.println(intStr);

        double decPart = Double.parseDouble(number.substring(number.indexOf(".")));
        StringBuffer dec_string = new StringBuffer();
        while (decPart > 0) {
            if (dec_string.length() > 32) {
                System.out.println("ERROR"); // if too long, return error.
            }
            if (decPart == 1) { // if decimal part is 1, then append 1 to string and break loop.
                dec_string.append((int)decPart);
                break; // == 1 is the only time will break.
            }
            double r = decPart * 2; // doubles decimal part.
            if (r >= 1) { // if after*2, >=1 , then append 1 to string, at the back
                dec_string.append(1);
                decPart = r - 1; //after append, assign doubled decpart-1 to decpart.
            } else {      // if after*2, < 1 then append 0 to string a
                dec_string.append(0);
                decPart = r; // decPart is doubled without -1.
            }
        }
        String result = intStr + "." + dec_string.toString(); // concatenate  2 strings together.
        System.out.println(result);
    }
}
