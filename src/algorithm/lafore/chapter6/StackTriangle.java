package algorithm.lafore.chapter6;

public class StackTriangle {
    private static class StackX {
        private int size;
        private int arr[];
        private int pointer;

        StackX(int size) {
            this.size = size;
            arr = new int[size];
            pointer = 0;
        }

        void push(int item) {
            arr[pointer++] = item;
        }

        int pop() {
            if (isEmpty()) {
                throw new IllegalArgumentException("Stack is empty");
            }
            return arr[--pointer];
        }

        int peek() {
            return arr[pointer];
        }
        boolean isEmpty() {
            return pointer == 0;
        }
    }

    static int triangle(int num) {
        StackX stack = new StackX(num);
        while (num > 0) {
            stack.push(num--);
        }
        int total = 0;
        while (! stack.isEmpty()) {
            total += stack.pop();
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(triangle(4));
    }
}
