package interview.stack;

import java.util.Stack;

public class StackInAscendingOrder {

    public static Stack<Integer> ascendingOrder(Stack<Integer> unorderedStack) {
        Stack<Integer> sorted = new Stack<>();
        while (!unorderedStack.isEmpty()) {
            Integer tmp = unorderedStack.pop();
            while (!sorted.isEmpty() && sorted.peek() > tmp) {
                unorderedStack.push(sorted.pop());
            }
            sorted.push(tmp);
            // if unordered elem < sorted => push to sorted stack
            // else removed from sorted and compare with unordered
              // if next ordered elem > unordered elem sorted => push to the unordered elen to sorted stack
              // else keep going


        }
        return sorted;
    }

    public static void main(String[] args) {
        Stack<Integer> unorderedStack = new Stack<>();
        unorderedStack.push(1);
        unorderedStack.push(2);
        unorderedStack.push(4);
        unorderedStack.push(3);
        unorderedStack.push(6);
        unorderedStack.push(5);

        System.out.println(StackInAscendingOrder.ascendingOrder(unorderedStack));


    }
}
