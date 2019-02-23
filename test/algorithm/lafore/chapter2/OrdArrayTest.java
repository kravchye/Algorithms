package algorithm.lafore.chapter2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrdArrayTest {

    OrdArray arr;
    @Before
    public void prepareData() {
        arr = new OrdArray(10);
        arr.insertViaBinarySearch(77);                // insert 10 items
        arr.insertViaBinarySearch(99);
        arr.insertViaBinarySearch(44);
        arr.insertViaBinarySearch(55);
        arr.insertViaBinarySearch(22);
    }

    @Test
    // Programming project 2.4
    public void insertViaBinarySearch() {
         Assert.assertEquals("22 44 55 77 99 ", arr.getContent());
    }

    @Test
    // Programming project 2.4
    public void deleteViaBinarySearch() {

        arr.deleteViaBinarySearch(22);
        arr.deleteViaBinarySearch(99);
        arr.deleteViaBinarySearch(55);
        Assert.assertEquals("44 77 ", arr.getContent());
    }

    @Test
    // Programming project 2.5
    public void merge() {
        arr.merge(new long[]{1, 2, 12, 13, 88, 100 });
        Assert.assertEquals("1 2 12 13 22 44 55 77 88 99 100 ", arr.getContent());
    }
}
