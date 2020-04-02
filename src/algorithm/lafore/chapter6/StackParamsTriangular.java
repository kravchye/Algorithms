package algorithm.lafore.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackParamsTriangular {

    private static class Params {
        int n;
        int returnAdress;

        Params(int nn, int ra) {
            this.n = nn;
            this.returnAdress = ra;
        }
    }
    private static class StackX {
        private int size;
        private Params[] stackArray;
        private int top;

        StackX(int size) {
            this.size = size;
            stackArray = new Params[size];
            top = -1;
        }

        void push(Params p) {
            stackArray[++top] = p;
        }

        Params pop() {
            return stackArray[top--];
        }

        Params peek() {
            return stackArray[top];
        }

    }

    static int theNumber;
    static int theAnswer;
    static StackX theStack;
    static Params theseParams;
    static int codePart;

    public static void main(String[] args) throws IOException {
        System.out.println("Enter a number: ");
        theNumber = getInt();
        recTriangle();
        System.out.println("Triangular=" + theAnswer);
    }

    public static void recTriangle() {
        theStack = new StackX(10000);
        codePart = 1;
        while(step() == true) ;
    }


    static boolean step() {
        switch (codePart) {
            case 1:
                // initiation
                theseParams = new Params(theNumber, 6);
                theStack.push(theseParams);
                codePart = 2;
                return true;
            case 2:
                // stack population
                Params params = theStack.peek();
                if (params.n == 1) {
                    codePart = 4;
                } else {
                    codePart = 3;
                }
                return true;
            case 3:
                params = theStack.peek();
                theStack.push(new Params(params.n - 1, 4));
                codePart = 2;
                return true;
            case 4:
                params = theStack.pop();
                theAnswer += params.n;
                codePart = params.returnAdress;
                return true;
            case 6:
                return false;
        }
        return false;
    }

    public static int getInt() throws IOException {
        return Integer.parseInt(getString());
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
