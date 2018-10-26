package algorithm.lafore.chapter2;

// HighArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items

    //-----------------------------------------------------------
    public HighArray(int max)         // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }

    //-----------------------------------------------------------
    public boolean find(long searchKey) {                              // find specified value
        int j;
        for (j = 0; j < nElems; j++)            // for each element,
            if (a[j] == searchKey)           // found item?
                break;                       // exit loop before end
        if (j == nElems)                    // gone to end?
            return false;                   // yes, can't find it
        else
            return true;                    // no, found it
    }  // end find()

    //-----------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }

    //-----------------------------------------------------------
    public boolean delete(long value) {
        int j;
        for (j = 0; j < nElems; j++)        // look for it
            if (value == a[j])
                break;
        if (j == nElems)                  // can't find it
            return false;
        else                           // found it
        {
            for (int k = j; k < nElems; k++) // move higher ones down
                a[k] = a[k + 1];
            nElems--;                   // decrement size
            return true;
        }
    }  // end delete()

    //-----------------------------------------------------------
    public void display()             // displays array contents
    {
        for (int j = 0; j < nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }

    //-----------------------------------------------------------
    // Programming project 2.1
    public long getMax() {
        if (nElems == 0) return -1;
        long max = a[0];

        for (int el = 1; el < nElems; el++) {
            if (a[el] > max) {
                max = a[el];
            }
        }
        return max;
    }

    //-----------------------------------------------------------
    // Programming project 2.2
    public long removeMax() {
        if (nElems == 0) return -1;
        long max = a[0];
        int maxPosition = 0;

        for (int el = 1; el < nElems; el++) {
            if (a[el] > max) {
                max = a[el];
                maxPosition = el;
            }
        }
        //shift elements to fill the removed element
        for (int j = maxPosition; j < nElems; j++) {
            a[j] = a[j + 1];
        }
        nElems--;

        return max;
    }

    //-----------------------------------------------------------
    // Programming project 2.6
    public void noDups() {
        long[] result = new long[nElems];
        result[0] = a[0];
        for (int i = 0; i < nElems; i++) {
            for (int j = i + 1; j < nElems; j++) {
                if (a[i] == a[j]) {
                    result[j] = a[0]; // it's a duplicate!
                } else {
                    result[j] = a[j];
                }
            }
        }
        int dupCount = 0;
        for (int i = 1; i < nElems; i++) {
            if (result[i] == result[0]) {
                result[i] = result[i+1];
                dupCount++;
            }
        }
        nElems = nElems - dupCount;
        a = result;
    }

    //-----------------------------------------------------------
}  // end class HighArray

////////////////////////////////////////////////////////////////
class HighArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;            // array size
        HighArray arr;                // reference to array
        arr = new HighArray(maxSize); // create the array

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

        int searchKey = 35;           // search for item
        if (arr.find(searchKey))
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.delete(00);               // delete 3 items
        arr.delete(55);
        arr.delete(99);

        arr.display();                // display items again

        System.out.println("Max num is " + arr.getMax());
        System.out.println("Removed max num is " + arr.removeMax());
        arr.display();                // display items again

        // Programming project 2.3
        long[] sortedByDesc = new long[maxSize];

        int pos = 0;
        long elem = arr.removeMax();
        while (elem != -1) {
            sortedByDesc[pos++] = elem;
            elem = arr.removeMax();
        }
        System.out.println("sorted By Desc array ");
        for (int j = 0; j < pos; j++)       // for each element,
            System.out.print(sortedByDesc[j] + " ");  // display it
        System.out.println("");


        // No dups
        System.out.println("No duplicate example");
        arr.insert(11); arr.insert(22); arr.insert(22); arr.insert(33);
        arr.noDups();
        arr.display();                // display items again
    }  // end main()
}  // end class HighArrayApp
