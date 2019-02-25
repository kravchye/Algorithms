package algorithm.lafore.chapter2;

// HighArray.java
// demonstrates array class with high-level interface
// to run this program: C>java HighArrayApp
////////////////////////////////////////////////////////////////
class HighArray extends BaseArray {
    public HighArray(int max) {
        super(max);
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
        for (int j = maxPosition; j < nElems - 1; j++) {
            a[j] = a[j + 1];
        }
        nElems--;

        return max;
    }

    //-----------------------------------------------------------
    // Programming project 2.6
    public void noDups() {
        int dupCount = 0;
        for (int i = 0; i < nElems; i++) {
            for (int j = i + 1; j < nElems; j++) {
                if (a[i] == a[j] && a[j] != a[0]) {
                    a[j] = a[0];
                    dupCount++;
                }
            }
        }
        nElems = nElems - dupCount;
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
    }  // end main()
}  // end class HighArrayApp
