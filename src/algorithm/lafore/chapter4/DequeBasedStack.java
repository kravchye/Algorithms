package algorithm.lafore.chapter4;
// Programming project 4.3
public class DequeBasedStack {

    private Deque deque;
    public DequeBasedStack(Deque deque) {
        this.deque = deque;
    }

    public void push(long item) {
        deque.insertLeft(item);
    }

    public long pop() {
       return deque.removeRight();
    }

    public long peek() {
        return deque.getTopRight();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public boolean isFull() {
        return deque.isFull();
    }
}
