package algorithm.lafore.chapter2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HighArrayTest {

    HighArray arr;
    int arrSize = 20;

    @Before
    public void prepare() {           // reference to array
        arr = new HighArray(arrSize); // create the array

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
    // Programming project 2.1
    @Test
    public void getMax() {
        Assert.assertEquals(99, arr.getMax());
    }

    // Programming project 2.2
    @Test
    public void removeMax() {
        Assert.assertEquals(99, arr.removeMax());
    }

    @Test
    // Programming project 2.3
    public void sortedByDesc() {
        HighArray sortedByDesc = new HighArray(arrSize);

        long elem = arr.removeMax();
        while (elem != -1) {
            sortedByDesc.insert(elem);
            elem = arr.removeMax();
        }
        Assert.assertEquals("99 88 77 66 55 44 33 22 11 0 ", sortedByDesc.getContent());
    }

    @Test
    // Programming project 2.6
    public void noDups() {
        arr.insert(11); arr.insert(22); arr.insert(22); arr.insert(33);
        Assert.assertEquals("77 99 44 55 22 88 11 0 66 33 11 22 22 33 ", arr.getContent());
        arr.noDups();
        Assert.assertEquals("77 99 44 55 22 88 11 0 66 33 ", arr.getContent());
    }

    @Test
    // Programing project 2.6 - Test #2
    public void testNoDups() {
        arr = new HighArray(arrSize); // create the array
        arr.insert(11);
        arr.insert(11);
        arr.insert(22);
        arr.insert(33);
        arr.insert(22);
        arr.insert(11);
        arr.insert(44);

        Assert.assertEquals("11 11 22 33 22 11 44 ", arr.getContent());
        arr.noDups();
        Assert.assertEquals("11 22 33 44 ", arr.getContent());

    }
    @Test
    // Programing project 2.6 - Test #3
    public void testNoDups2() {
        arr = new HighArray(arrSize); // create the array
        arr.insert(11);
        arr.insert(11);
        arr.insert(11);

        Assert.assertEquals("11 11 11 ", arr.getContent());
        arr.noDups();
        Assert.assertEquals("11 ", arr.getContent());

    }
}
