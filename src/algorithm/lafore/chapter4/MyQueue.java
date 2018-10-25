package algorithm.lafore.chapter4;


public class MyQueue {
    int[] nums;
    private int front;
    private int rear;
    private int maxNum;

    public MyQueue(int maxNum) {
        nums = new int[maxNum];
        front = 0;
        rear = 0;
        this.maxNum = maxNum;
    }

    public void offer(int elem) {
        if (rear == maxNum) {
            rear = 0;
        }
        if (rear == front) {
            front = front + 1 > maxNum ? 0 : front ++;
        }
        nums[rear++] = elem;

    }

    public int poll() {
        if (front == rear) {
            throw new IllegalArgumentException("Queue is empty");
        }
        if (front ==  maxNum) {
            front = 0;
        }
        return nums[front++];
    }
}
