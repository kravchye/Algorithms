package algorithm.lafore.chapter4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
// Programming project 4.4
public class PriorityQueueTest {
    private PriorityQueue queue;

    @Before
    public void before() {
        queue = new PriorityQueue(3);
        queue.insert(1);
        queue.insert(2);
        queue.insert(3);
    }

    @Test
    public void priorityQueueTest() {
        Assert.assertTrue(queue.isFull());
        Assert.assertEquals(1, queue.remove());
        Assert.assertEquals(2, queue.remove());
        Assert.assertEquals(3, queue.remove());
        Assert.assertTrue(queue.isEmpty());
    }
}
