package algorithm.lafore.chapter3;

// bubbleSortInTwoWays.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items

    //--------------------------------------------------------------
    public ArrayBub(int max)          // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }

    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }

    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        for (int j = 0; j < nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }

    //--------------------------------------------------------------
    public void bubbleSort() {
        int out, in;

        for (out = nElems - 1; out > 1; out--)   // outer loop (backward)
            for (in = 0; in < out; in++)        // inner loop (forward)
                if (a[in] > a[in + 1])       // out of order?
                    swap(in, in + 1);          // swap them
    }  // end bubbleSort()
    //--------------------------------------------------------------

    /**
     * Bubble sort for programming project 3.1
     */
    public void bubbleSortInTwoWays() {
        // Programming project 3.1
        int rightOut, leftOut, in;

        for (rightOut = nElems - 1, leftOut = 0; rightOut > 1 || leftOut < nElems; rightOut--, leftOut++) {  // outer loop (backward)
            for (in = leftOut; in < rightOut; in++)        // inner loop (forward)
                if (a[in] > a[in + 1])       // rightOut of order?
                    swap(in, in + 1);          // swap them
            for (in = rightOut - 1; in >= leftOut; in--)
                if (a[in] > a[in + 1])       // rightOut of order?
                    swap(in + 1, in);
        }
    }  // end bubbleSortInTwoWays()
    //--------------------------------------------------------------

    /**
     * Bubble sort for programming project 3.4
     */
    // Programming project 3.4
    public void bubbleSortOddEvenLoops() {
        int out, odd, even;

        for (out = nElems - 1; out > 1; out--) {
            for (even = 0; even < out; even = even+2) {
                if (a[even] > a[even + 1])
                    swap(even, even + 1);
                if (even + 2 > nElems) break;
            }
            for (odd = 1;odd < out; odd = odd + 2) {
                if (a[odd] > a[odd + 1])
                    swap(odd, odd + 1);
                if (odd + 2 > nElems) break;
            }

        }
    }
    //--------------------------------------------------------------
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
//--------------------------------------------------------------
}  // end class ArrayBub

////////////////////////////////////////////////////////////////
class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 20;            // array size
        ArrayBub arr;                 // reference to array
        arr = new ArrayBub(maxSize);  // create the array

        arr.insert(77);               // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display();                // display items

        System.out.println("Buble sort in two ways");
        arr.bubbleSortInTwoWays();             // bubble sort them
        arr.display();                // display them again

        arr.insert(41);
        arr.insert(99);
        System.out.println("Buble sort using odd even loops");
        arr.bubbleSortOddEvenLoops();             // bubble sort them
        arr.display();                // display them again
    }  // end main()
}  // end class BubbleSortApp
////////////////////////////////////////////////////////////////
