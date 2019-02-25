package algorithm.lafore.chapter2;

public class BaseArray {
    protected long[] a;                 // ref to array a
    protected int nElems;               // number of data items

    //-----------------------------------------------------------
    public BaseArray(int max)         // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }

    //-----------------------------------------------------------
    public void display()             // displays array contents
    {
        System.out.println(getContent());
    }

    public String getContent() {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < nElems; j++) {      // for each element,
            sb.append(a[j])
                    .append(" ");
        }
        return sb.toString();
    }

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
    //--------------------------------------------------------------
    protected void swap(int one, int two)
    {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}
