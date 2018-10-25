package algorithm.lafore.chapter5.doubleEnded;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Maestro on 03.03.2018.
 */
public class FirstLastList {
    Link first;
    Link last;

    boolean isEmpty() {
        return first == null;
    }

    void insertFirst(int data){
        Link newLink = new Link(data);
        if (isEmpty()) {
            last = newLink;
        }
        newLink.next = first;
        first = newLink;
    }

    void insertLast(int data) {
        Link newLastLink = new Link(data);
        if (isEmpty()) {
            first = newLastLink;
        } else {
            last.next = newLastLink;
        }
        last = newLastLink;
    }
    long deleteFirst() {
        if (isEmpty()) return -1;
        long removed = first.iData;
        if (first.next == null)
            last = null;
        first = first.next;
        return removed;

    }

    public void displayList()      // display the list
    {
        System.out.print("List (first-->last): ");
        Link current = first;       // start at beginning of list
        while(current != null)      // until end of list,
        {
            current.displayLink();   // print data
            current = current.next;  // move to next link
        }
        System.out.println("");
    }
    public static void main(String[] args)
    { // make a new list
        FirstLastList theList = new FirstLastList();
        theList.insertFirst(22); // insert at front
        theList.insertFirst(44);
        theList.insertFirst(66);
        theList.insertLast(11); // insert at rear
        theList.insertLast(33);
        theList.insertLast(55);
        theList.displayList(); // display the list
        theList.deleteFirst(); // delete first two items
        theList.deleteFirst();
        theList.displayList(); // display again

        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list.get(2));
    } // end main()
}
