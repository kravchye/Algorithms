package algorithm.lafore.chapter6;

public class MergeSort2Arrays {

    final static int[] a = new int[]{2, 4, 6, 7};
    final static int[] b = new int[]{1, 3, 5, 8, 9};

    final static int[] arr = new int[a.length + b.length];

    public static void main(String[] args) {
        merge();
        display();
    }

    private static void display() {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private static void merge() {
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                arr[k++] = a[i++];
            } else {
                arr[k++] = b[j++];
            }
        }
        while (i < a.length) {
            arr[k++] = a[i++];
        }
        while (j < b.length) {
            arr[k++] = b[j++];
        }
    }
}
