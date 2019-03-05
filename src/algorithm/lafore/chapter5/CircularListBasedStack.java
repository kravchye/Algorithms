package algorithm.lafore.chapter5;

// Programming project 5.4
public class CircularListBasedStack {
    private CircularList list;

    public CircularListBasedStack(CircularList list) {
        this.list = list;
    }

    public void push(long elem) {
        list.insertFirst(elem);
    }

    public long pop() {
        if (list.isEmpty()) return -1;
        return list.delete(list.getCurrent().dData);
    }

    public static void main(String[] args) {
        CircularList list = new CircularList();
        CircularListBasedStack stack = new CircularListBasedStack(list);
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.push(44);
        stack.push(55);
        stack.list.dislay();
        stack.pop();
        stack.pop();
        stack.list.dislay();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.list.dislay();
    }
}
