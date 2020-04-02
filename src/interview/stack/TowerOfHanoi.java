package interview.stack;

import java.util.Stack;

public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3;
        Tower[] towers = new Tower[n];
        for (int i = 0; i < 3; i++) towers[i] = new Tower(i);
        for (int i = n - 1; i >= 0; i--) towers[0].add(i);

        for (int i = 0; i < 3; i++) towers[i].print();
        towers[0].moveDisks(n, towers[1], towers[2]);
        System.out.println();

        for (int i = 0; i < 3; i++) towers[i].print();
    }

    public static class Tower {
        private Stack<Integer> disks;
        private int index;

        public Tower(int i) {
            disks = new Stack<Integer>();
            index = i;
        }

        public void add(int d) {
            if (!disks.isEmpty() && disks.peek() <= d) {
                System.out.println("Error placing disk " + d);
            } else {
                disks.push(d);
            }
        }

        public void moveTopTo(Tower t) {
            int top = disks.pop();
            t.add(top);
            System.out.println("Move disk " + top + " from "+ index + "to " + t.index);
        }

        public void moveDisks(int n, Tower buffer, Tower destination) {
            if (n > 0) {
                moveDisks(n - 1, destination, buffer);
                moveTopTo(destination);
                buffer.moveDisks(n - 1, this, destination);
            }
        }

        public void print() {
             System.out.println("Contents of Tower " + index);
             for (int i = disks.size() - 1; i >= 0; i--) {
                 System.out.println(" " + disks.get(i));
                 }
             }
    }
}
