package algorithm.lafore.chapter2;

// orderedArray.java
// demonstrates ordered array class
// to run this program: C>java OrderedApp
////////////////////////////////////////////////////////////////
class OrdArray extends BaseArray {
    public OrdArray(int max) {
        super(max);
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
    // Programming project 2.4
    public void insertViaBinarySearch(long value)
    {
        int cur = binarySearch(value);
        for (int k = nElems; k > cur; k--){
            a[k] = a[k-1];
        }
        a[cur] = value;
        nElems++;
    }

    public void deleteViaBinarySearch(long value) {
        int pos = binarySearch(value);
        if (pos == nElems) return;
        for (int i = pos; i < nElems; i++) {
            a[i] = a[i+1];
        }
        nElems--;

    }
    /**
     * 
     * @param value
     * @retur the position of the value
     */
    private int binarySearch(long value) {
        int lowerBound = 0;
        int upperBound  = nElems - 1;
        int cur = lowerBound;
        while(true) {
            if (lowerBound > upperBound){
                break;
            }
            cur = (lowerBound + upperBound) / 2;
            if (value > a[cur]) {
                lowerBound = ++cur;
            } else {
                upperBound = cur - 1;
            }
        }
        return cur;
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
        if (arr.find(searchKey) != arr.nElems)
            System.out.println("Found " + searchKey);
        else
            System.out.println("Can't find " + searchKey);

        arr.display();                 // display items

        arr.delete(00);                // delete 3 items
        arr.delete(55);
        arr.delete(99);

        arr.display();                 // display items again

    }  // end main()
}  // end class OrderedApp
