package algorithm.lafore.chapter3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InsertSortTest {
    ArrayIns arr;
    @Before
    public void prepareData() {
        arr = new ArrayIns(15);
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
    }

    @Test
    // Programming project 3.2
    public void median() {
        Assert.assertEquals(60, arr.median());
        arr.insert(123);
        Assert.assertEquals(55, arr.median());
    }

    @Test
    // Programming project 3.3
    public void noDups() {
        arr.insert(0);
        arr.insert(99);
        arr.insert(55);
        arr.noDups();
        Assert.assertEquals("0 11 22 33 44 55 66 77 88 99 ", arr.getContent());
    }
    @Test
    // Programming project 3.6
    public void insertionSortnoDups() {
        arr.insert(0);
        arr.insert(99);
        arr.insert(55);
        arr.insertionSortNoDups();
        Assert.assertEquals("0 11 22 33 44 55 66 77 88 99 ", arr.getContent());
    }

}
