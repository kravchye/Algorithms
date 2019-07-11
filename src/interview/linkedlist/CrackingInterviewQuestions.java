package interview.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class CrackingInterviewQuestions {

    static class Node<T>
    {
        @Override
        public String toString() {
            return String.valueOf(dData);
        }

        T dData;
         Node next;
           // -------------------------------------------------------------
        Node(T d)
        { dData = d; }
        // -------------------------------------------------------------
        void display() {
            System.out.print(dData + " ");
            Node nextOne = next;
            while(nextOne != null) {
                System.out.print(nextOne.dData + " ");
                nextOne = nextOne.next;
            }
            System.out.println();
        }
        void appendToTail(T d) {
            Node newOne = new Node(d);
            if (this.next == null) {
                this.next = newOne;
            } else {
                Node current = this;
                while(current.next != null) {
                    current = current.next;
                }
                current.next = newOne;
            }

        }
        Node<T> deleteNode(T d) {
            Node<T> previous = this;
            Node<T> current = this;
            while (current.dData != d) {
                if (current.next == null) {
                    return null; // didn't find it
                }
                previous = current;
                current = current.next;
            }
            if (current.next == null) { // last node
                previous.next = null;
            } else {
                previous.next = current.next;
            }
            return current;
        }

        // Task 1. Remove duplicates
        void removeDuplicates() {
            Set<T> set = new HashSet<>();
            Node<T> previous = null;
            Node<T> current = this;
            while (current != null) {
                if (set.contains(current.dData)) {
                    previous.next = current.next;
                } else {
                    set.add(current.dData);
                    previous = current;
                }
                current = current.next;
            }
        }
        void removeDuplicatesNoBuffer() {
            Node<T> current = this;
            while (current != null) {
                Node<T> runner = current.next;
                while (runner != null) {
                    if (runner.dData.equals(current.dData)) {
                        if (runner.next == null) {
                            current.next = null;
                        } else {
                            current.next = runner.next;
                            runner = runner.next;
                        }
                    }
                    runner = runner.next;
                }
                current = current.next;

            }
        }

        // Task 2
        Node getNFromLast(int n) {
            Node<T> first = this;
            Node<T> last = this;
            for(int i = 0; i < n; i++) {
                if (last == null) {
                    return null;
                }
                last = last.next;
            }
            while(last != null) {
                first = first.next;
                last = last.next;
            }
            return first;
        }

        // Task 3
        Node removeMiddle(Node middle) {
            if (middle == null || middle.next == null) {
                return null;
            }
            middle.dData = middle.next.dData;
            middle.next = middle.next.next;
            return this;
        }

        // Task 4
        Node<Integer> add(Node<Integer> one, Node<Integer> two, Node<Integer> result, int carry) {
            if (carry == 1 && one == null) {
                Node<Integer> head = result;
                while(result.next != null) {
                    result = result.next;
                }
                result.next = new Node(carry);
                return head;
            }
            if (one == null || two == null) {
                return result;
            }
            int sum = one.dData + two.dData + carry;
            if (result.dData == 0) {
                result.dData = sum % 10;
            } else {
                while(result.next != null) {
                    result = result.next;
                }
                result.next = new Node(sum % 10);
            }

            return add(one.next, two.next, result, sum >= 10 ?  1 : 0);
        }

        // Task 5 - return first node in circular list
        Node<T> getBeginingOfTheLoop(Node<T> node) {
            // Find meeting point
            Node first = node;
            Node second = node;
            while (second != null) {
                first = first.next;
                second = second.next.next;
                if (first.dData == second.dData) {
                    break;
                }
            }

            // Move first node at the begining
            first = node;
            // They should reach each other
            while (first != second) {
                first = first.next;
                second = second.next;
            }
            return first;
        }
// -------------------------------------------------------------
    }

    // Remove duplicates
//    public static List<Integer> removeDuplicates(Node<Integer> list) {
//        while(list.)
//    }

    public static void main(String[] args) {
        Node<Integer> n = new Node<Integer>(1);
        n.appendToTail(2);
        n.appendToTail(3);
        n.display();
        // Task 1
        n.appendToTail(3);
        n.appendToTail(2);
        n.appendToTail(4);
        n.removeDuplicates();
        n.display();

        n.deleteNode(2);
        n.display();
        n.deleteNode(4);
        n.display();

        // Task 1 - no buffer
        n.appendToTail(3);
        n.appendToTail(2);
        n.appendToTail(4);
        n.removeDuplicatesNoBuffer();
        n.display();

        // Task 2
        System.out.println(n.getNFromLast(2).dData);

        // Task 3
        System.out.println("Remove middle node");
        n.removeMiddle(n.next).display();

        // Task 4
        Node<Integer> one = new Node<>(5);
        one.next =  new Node<>(6);
        Node<Integer> two = new Node<>(7);
        two.next = new Node<>(8);
        one.add(one, two, new Node(0), 0).display();

        // Task 5
        // a -> b -> c -> d -> e -> c
        Node<Character> a = new Node<>('a');
        a.next = new Node<>('b');
        Node<Character> c = new Node<>('c');
        a.next.next = c;
        c.next = new Node<>('d');
        c.next.next = new Node<>('e');
        c.next.next.next = c;
        System.out.println(a.getBeginingOfTheLoop(a).dData);

    }
}
