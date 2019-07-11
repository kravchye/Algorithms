package interview.stack;

public class ArrayFor3Stacks {
    private final static int STACK_SIZE = 10;
    private int STACKS_NUM = 3;
    private int arr[] = new int[STACK_SIZE * 3];
    private int[] stackPos = new int[] {0,0,0};

    public void push(int stackNum, int elem) {
        int pos = stackNum * STACK_SIZE + stackPos[stackNum] + 1;
        stackPos[stackNum]++;
        arr[pos] = elem;
    }

    public int pop(int stackNum) {
        int pos = stackPos[stackNum];
        stackPos[stackNum]--;
        int returnValue = arr[pos + stackNum * STACK_SIZE];
        arr[pos] = 0;
        return returnValue;
    }

    public static void main(String[] args) {
        ArrayFor3Stacks arr43Stacks = new ArrayFor3Stacks();
        arr43Stacks.push(0, 1);
        arr43Stacks.push(0, 2);
        System.out.println(arr43Stacks.pop(0));
        System.out.println(arr43Stacks.pop(0));

        arr43Stacks.push(1, 3);
        arr43Stacks.push(1, 4);
        System.out.println(arr43Stacks.pop(1));
        System.out.println(arr43Stacks.pop(1));
    }
}
