package algorithm.lafore.chapter6;

public class RecursiveMergeSort {

    static int[] arr = new int[] {3,1,2,7,4,8,6,5,9};

    public static void main(String[] args) {
        display();
        recSort(arr, 0, arr.length - 1);
        display();
    }

    private static void recSort(int a[], int lowerBound, int upperBound) {
        // base case
        if (lowerBound == upperBound) return;
        // rec call
        int mid = (lowerBound + upperBound) / 2;
        recSort(a, lowerBound, mid);
        recSort(a, mid + 1, upperBound);
        mergeSort(a, lowerBound, mid + 1, upperBound);
    }

    private static void mergeSort(int a[], int lowPtr, int highPtr, int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1; // number of items

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (arr[lowPtr] > arr[highPtr])  {
                a[j++] = arr[lowPtr++];
            } else {
                a[j++] = arr[highPtr++];
            }
        }
        while(lowPtr <= mid) {
            a[j++] = arr[lowPtr++];
        }
        while(highPtr <= upperBound) {
            a[j++] = arr[highPtr++];
        }
        for (j = 0; j < n; j++)
            arr[lowerBound + j] = a[j];

    }

    private static void display() {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
