package algorithm.lafore.chapter5;
// Programming project 5.1
public class PriorityQueue {
    private SortedList sortedList;

    public PriorityQueue(SortedList sortedList) {
        this.sortedList = sortedList;
    }

    public void insert(long item) {
        sortedList.insert(new Link(item));
    }

    public long remove() {
        return sortedList.remove().dData;
    }


}
