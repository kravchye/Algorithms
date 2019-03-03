package algorithm.lafore.chapter4;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DequeBasedStackTest {
    private DequeBasedStack stack;

    @Before
    public void beforeTest() {
        stack = new DequeBasedStack(new Deque(3));
    }

    @Test
    public void stack() {
        Assert.assertTrue(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        Assert.assertTrue(stack.isFull());
        Assert.assertEquals(3, stack.pop());
        Assert.assertEquals(2, stack.pop());
        Assert.assertEquals(1, stack.pop());
        Assert.assertTrue(stack.isEmpty());
    }

    @Test
    public void wrapAroundStack() {
        Assert.assertTrue(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Assert.assertTrue(stack.isFull());
        Assert.assertEquals(5, stack.pop());
        Assert.assertEquals(4, stack.pop());
        Assert.assertEquals(3, stack.pop());
        Assert.assertTrue(stack.isEmpty());
    }


}
