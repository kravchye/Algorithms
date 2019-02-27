package algorithm.lafore.chapter4;

// Programming project 4.2
public class Deque extends Queue {
    public Deque(int s) {
        super(s);
    }

    public void insertLeft(long elem) {
        insert(elem);
        restrictNumEl();
    }

    public void insertRight(long elem) {
        queArray[rear--] = elem;
        if (rear == -1) {
            rear = maxSize;
        }
        nItems++;
        restrictNumEl();
    }

    public long removeLeft() {
        return  remove();
    }

    public long removeRight() {
        long removed = queArray[rear--];
        if (rear == -1) {
            rear = maxSize;
        }
        nItems--;
        return removed;
    }
    private void restrictNumEl() {
        if (nItems > maxSize)
            nItems = maxSize;
    }
}
