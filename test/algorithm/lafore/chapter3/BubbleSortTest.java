package algorithm.lafore.chapter3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BubbleSortTest {
    ArrayBub arr;
    @Before
    public void prepareData() {
        arr = new ArrayBub(15);
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
    public void bubbleSort() {
        arr.bubbleSort();
        Assert.assertEquals("0 11 22 33 44 55 66 77 88 99 ", arr.getContent());
    }
    @Test
    // Programming project 3.1
    public void bubbleSort2Ways() {
        arr.bubbleSortInTwoWays();
        Assert.assertEquals("0 11 22 33 44 55 66 77 88 99 ", arr.getContent());
    }
    @Test
    // Programming project 3.4
    public void bubbleEvenOddSort() {
        arr.bubbleSortOddEvenLoops();
        Assert.assertEquals("0 11 22 33 44 55 66 77 88 99 ", arr.getContent());
    }
}
