package algorithm.lafore.chapter3;

import algorithm.lafore.chapter2.BaseArray;

// bubbleSortInTwoWays.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub extends BaseArray {
    public ArrayBub(int max) {
        super(max);
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
        boolean wasSwap;
        do {
            wasSwap=false;
            for(int in=1; in<nElems-1; in+=2) {
                if( a[in] > a[in+1] ) {
                    swap(in, in+1);
                    wasSwap=true;
                }
            }

            for(int in=0; in<nElems-1; in+=2) {
                if( a[in] > a[in+1] ) {
                    swap(in, in+1);
                    wasSwap=true;
                }
            }

        } while (wasSwap);

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
