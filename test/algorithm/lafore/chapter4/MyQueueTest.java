package algorithm.lafore.chapter4;


import static org.junit.Assert.*;
import org.junit.Test;

public class MyQueueTest {

    private MyQueue queue = new MyQueue(3);

    @Test
    public void testOrdinaryQueue() {
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        assertEquals(4, queue.poll());
        assertEquals(5, queue.poll());
        assertEquals(6, queue.poll());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCapacityRestrictedQueue() {
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        assertEquals(4, queue.poll());
        assertEquals(5, queue.poll());
        assertEquals(6, queue.poll());
        queue.poll();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionOnEmptyRemoval() {
        queue.poll();
    }
}
