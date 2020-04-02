package interview.stack;

import java.util.Stack;

public class QueueVia2Stacks {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;


    QueueVia2Stacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void offer(int elem) {
        while (!stack1.isEmpty() ) {
            stack2.push(stack1.pop());
        }
        stack1.push(elem);
        while (!stack2.isEmpty() ) {
            stack1.push(stack2.pop());
        }
    }

    public Integer poll() {
        if (stack1.isEmpty()) return null;
        Integer elem = stack1.pop();
        while (!stack1.isEmpty() ) {
            stack2.push(stack1.pop());
        }

        while (!stack2.isEmpty() ) {
            stack1.push(stack2.pop());
        }
        return elem;
    }

    public static void main(String[] args) {
        QueueVia2Stacks queue = new QueueVia2Stacks();
        queue.offer(1);
        queue.offer(2);
        System.out.println("" + queue.poll() + queue.poll());
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        System.out.println("" + queue.poll() + queue.poll() + queue.poll());

        System.out.println("" + queue.poll() + queue.poll() + queue.poll());
    }
}
