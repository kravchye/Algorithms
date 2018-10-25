package algorithm.lafore.chapter2;

// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items

    //-----------------------------------------------------------
    public OrdArray(int max)          // constructor
    {
        a = new long[max];             // create array
        nElems = 0;
    }

    //-----------------------------------------------------------
    public int size() {
        return nElems;
    }

    //-----------------------------------------------------------
    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = nElems - 1;
        int curIn;

        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (a[curIn] == searchKey)
                return curIn;              // found it
            else if (lowerBound > upperBound)
                return nElems;             // can't find it
            else                          // divide range
            {
                if (a[curIn] < searchKey)
                    lowerBound = curIn + 1; // it's in upper half
                else
                    upperBound = curIn - 1; // it's in lower half
            }  // end else divide range
        }  // end while
    }  // end find()

    //-----------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        int j;
        for (j = 0; j < nElems; j++)        // find where it goes
            if (a[j] > value)            // (linear search)
                break;
        for (int k = nElems; k > j; k--)    // move bigger ones up
            a[k] = a[k - 1];
        a[j] = value;                  // insert it
        nElems++;                      // increment size
    }  // end insert()

    //-----------------------------------------------------------
    public boolean delete(long value) {
        int j = find(value);
        if (j == nElems)                  // can't find it
            return false;
        else                           // found it
        {
            for (int k = j; k < nElems; k++) // move bigger ones down
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
    // Programming project 2.5
    public void merge(long[] arr) {
        if (arr.length == 0 || arr == null || arr.length == 0) return;
        long[] result = new long[a.length + arr.length];
        int i = 0, j = 0, k = 0;
        while (i < nElems && j < arr.length) {
            if (a[i] < arr[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = arr[j++];
            }
        }
        while (i < nElems) {
            result[k++] = a[i++];
        }

        while (j < arr.length) {
            result[k++] = arr[j++];
        }

        a = result;
        nElems = k;
    }
    //-----------------------------------------------------------
}  // end class OrdArray

////////////////////////////////////////////////////////////////
class OrderedApp {
    public static void main(String[] args) {
        int maxSize = 100;             // array size
        OrdArray arr;                  // reference to array
        arr = new OrdArray(maxSize);   // create the array

        arr.insert(77);                // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);

        int searchKey = 55;            // search for item
        if (arr.find(searchKey) != arr.size())
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.display();                 // display items

        arr.delete(00);                // delete 3 items
        arr.delete(55);
        arr.delete(99);

        arr.display();                 // display items again

        // merge sort
        arr.merge(new long[]{22, 99});
        arr.display();

        arr.merge(new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13});
        arr.display();

    }  // end main()
}  // end class OrderedApp
