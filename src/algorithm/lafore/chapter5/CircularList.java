package algorithm.lafore.chapter5;
// Programming project 5.3
public class CircularList {
    private LinkD current;

    public LinkD getCurrent() {
        return current;
    }

    public void insertFirst(long num) {
        LinkD newLink = new LinkD(num);
        if (!isEmpty()) {
            LinkD endLink = current.previous != null ? current.previous : current;

            current.previous = newLink;
            newLink.next = current;

            endLink.next = newLink;
            newLink.previous = endLink;
        }
        this.current = newLink;
    }

    public void insertLast(long num) {
        LinkD newLink = new LinkD(num);
        if (!isEmpty()) {
            LinkD endLink = current.previous != null ? current.previous : current;
            current.previous = newLink;
            newLink.next = current;

            endLink.next = newLink;
            newLink.previous = endLink;
        } else {
            this.current = newLink;
        }
    }

    public LinkD searchForward(long searchKey) {
        return search(searchKey, true);
    }

    public LinkD searchBackward(long searchKey) {
        return search(searchKey, false);
    }

    public LinkD search(long searchKey, boolean forward) {
        LinkD criteria = current;
        while (criteria != null) {
            if (criteria.dData == searchKey) {
                return criteria;
            }
            criteria = forward ? criteria.next : criteria.previous;
        }
        return null;
    }

    public long deleteCurrent() {
        return delete(current.dData);
    }

    public long delete(long toDel) {
        LinkD toDelete = search(toDel, true);
        if (toDelete == null) {return -1;}
        if (toDelete.previous != null) {
            toDelete.previous.next = toDelete.next;
        }
        if (toDelete.next != null) {
            toDelete.next.previous = toDelete.previous;
        }
        if (current.dData == toDel) {
            current = current.next;
        }
        if (toDelete.next == toDelete) {// the last element
            this.current = null;
        }
        return toDelete.dData;
    }

    public boolean isEmpty() {
        return current == null;
    }

    public boolean isLast() {
        return current != null && current.next == current;
    }

    /**
     * Move forward to a number of position
     */
    public void moveForward(int num) {
        for (int i = 1; i <= num; i++) {
            this.current = this.current.next;
        }
    }

    public void dislay() {
        System.out.print("first -> last ");
        if (current == null) {
            System.out.print(" => No item in the list");
            return;
        }
        LinkD end = current.previous;
        LinkD link = current;
        while (link != null && link != end) {
            link.displayLinkD();
            link = link.next;
        }
        end.displayLinkD();
        System.out.println();
    }

    public static void main(String[] args) {
        CircularList list = new CircularList();
        list.insertFirst(33);
        list.insertFirst(22);
        list.insertFirst(11);
        list.insertLast(44);
        list.insertLast(55);
        list.dislay();
        list.delete(22);
        list.delete(11);
        list.dislay();
        list.delete(33);
        list.delete(44);
        list.delete(55);
        list.dislay();
    }
}
