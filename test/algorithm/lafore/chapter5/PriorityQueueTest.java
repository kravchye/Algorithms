package algorithm.lafore.chapter5;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PriorityQueueTest {
    private PriorityQueue queue;

    @Before
    public void prepareData() {
        queue = new PriorityQueue(new SortedList());
    }

    @Test
    public void testAsc() {
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
        Assert.assertEquals(1, queue.remove());
        Assert.assertEquals(2, queue.remove());
        Assert.assertEquals(3, queue.remove());
    }


    @Test
    public void testDesc() {
        queue.insert(3);
        queue.insert(2);
        queue.insert(1);
        Assert.assertEquals(1, queue.remove());
        Assert.assertEquals(2, queue.remove());
        Assert.assertEquals(3, queue.remove());
    }
}
