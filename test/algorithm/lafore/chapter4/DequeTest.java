package algorithm.lafore.chapter4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

// Programming project 4.2
public class DequeTest {
    Deque deque;
    @Before
    public void prepareData() {
        deque = new Deque(3);
        deque.insertLeft(1);
        deque.insertLeft(2);
        deque.insertLeft(3);
    }

    @Test
    public void removeLeft() {
        Assert.assertTrue(deque.isFull());
        Assert.assertEquals(1, deque.removeLeft());
        Assert.assertEquals(2, deque.removeLeft());
        Assert.assertEquals(3, deque.removeLeft());
        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void removeLeftWrapAround() {
        Assert.assertTrue(deque.isFull());
        deque.insertLeft(4);
        Assert.assertTrue(deque.isFull());
        Assert.assertEquals(4, deque.removeLeft());
        Assert.assertEquals(2, deque.removeLeft());
        Assert.assertEquals(3, deque.removeLeft());
        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void removeRight() {
        Assert.assertEquals(3, deque.removeRight());
        Assert.assertEquals(2, deque.removeRight());
        Assert.assertEquals(1, deque.removeRight());
        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void insertRight() {
        deque.insertRight(4);
        deque.insertRight(5);
        deque.insertRight(6);
        Assert.assertEquals(6, deque.removeLeft());
        Assert.assertEquals(5, deque.removeLeft());
        Assert.assertEquals(4, deque.removeLeft());
        Assert.assertTrue(deque.isEmpty());
    }
}
