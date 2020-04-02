package amazon;

/**
 * Given a number k, the task is to find count of active and inactive cells after k days.
 * After every day, status of i’th cell becomes active if left and right cells are not same and inactive
 * if left and right cell are same (both 0 or both 1).
 * Since there are no cells before leftmost and after rightmost cells,
 * the value cells before leftmost and after rightmost cells is always considered as 0 (or inactive).
 */
public class ActiveCellsInNDays {

    static void activeAndInactive(boolean cells[],
                                  int n, int k)
    {
        // copy cells[] array into temp [] array
        boolean temp[] = new boolean[n];
        for (int i = 0; i < n; i++)
            temp[i] = cells[i];

        // Iterate for k days
        while (k-- > 0) {

            // Finding next values for corner cells
            temp[0] = false ^ cells[1];
            temp[n - 1] = false ^ cells[n - 2];

            // Compute values of intermediate cells
            // If both cells active or inactive, then
            // temp[i]=0 else temp[i] = 1.
            for (int i = 1; i <= n - 2; i++)
                temp[i] = cells[i - 1] ^ cells[i + 1];

            // Copy temp[] to cells[] for next iteration
            for (int i = 0; i < n; i++)
                cells[i] = temp[i];
        }

        // count active and inactive cells
        int active = 0, inactive = 0;
        for (int i = 0; i < n; i++)
            if (cells[i] == true)
                active++;
            else
                inactive++;

        System.out.print("Active Cells = " + active + ", " +
                "Inactive Cells = " + inactive);
    }


    static int[] activeInactiveCells(int[] cells, int days) {

        // temp arrays
        int[] temp = new int[cells.length];
        // while days > 0
        while (days > 0) {
            // for each cells
            for (int i = 0; i < cells.length; i++) {
                if (i == 0) {
                    temp[i] = cells[i+1] ^ 0;
                } else if (i+1 == cells.length) {
                    temp[i] = cells[i-1] ^ 0;
                } else {
                    temp[i] = cells[i-1] ^ cells[i+1];
                }
            }
            // update cells with the temp arrays
            System.out.print("{");
            for(int i = 0; i < cells.length; i++) {
                cells[i] = temp[i];
                System.out.print(cells[i]);
            }
            System.out.println("}");
            days--;
        }
        return cells;
    }


    public static void main(String[] args) {
        System.out.println(activeInactiveCells(new int[] {0, 1, 0, 1, 0, 1, 0, 1}, 3));
        boolean[] cells = {false, true, false, true, false, true, false, true};
//        activeAndInactive(cells,8, 3);
    }
}
