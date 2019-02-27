package algorithm.lafore.chapter4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class QueueTest {
    private Queue queue;
    @Before
    public void prepare() {
        queue = new Queue(10);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.insert(7);
        queue.insert(8);
        queue.insert(9);
        queue.insert(10);
        queue.insert(11);
    }

    @Test
    // Programming project 4.1
    public void display() {
        Assert.assertEquals("11 2 3 4 5 6 7 8 9 10 ", queue.display());
    }
}
