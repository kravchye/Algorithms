package algorithm.lafore.chapter5;

// doublyLinkDed.java
// demonstrates doubly-linked list
// to run this program: C>java DoublyLinkDedApp
////////////////////////////////////////////////////////////////
class LinkD
   {
   public long dData;                 // data item
   public LinkD next;                  // next link in list
   public LinkD previous;              // previous link in list
// -------------------------------------------------------------
   public LinkD(long d)                // constructor
      { dData = d; }
// -------------------------------------------------------------
   public void displayLinkD()          // display this link
      { System.out.print(dData + " "); }
// -------------------------------------------------------------
   }  // end class LinkD

////////////////////////////////////////////////////////////////
class DoublyLinkDedList
   {
   private LinkD first;               // ref to first item
   private LinkD last;                // ref to last item
// -------------------------------------------------------------
   public DoublyLinkDedList()         // constructor
      {
      first = null;                  // no items on list yet
      last = null;
      }
// -------------------------------------------------------------
   public boolean isEmpty()          // true if no links
      { return first==null; }
// -------------------------------------------------------------
   public void insertFirst(long dd)  // insert at front of list
      {
      LinkD newLinkD = new LinkD(dd);   // make new link
      if( isEmpty() )                // if empty list,
         last = newLinkD;             // newLinkD <-- last
      else
         first.previous = newLinkD;   // newLinkD <-- old first
      newLinkD.next = first;          // newLinkD --> old first
      first = newLinkD;               // first --> newLinkD
      }
// -------------------------------------------------------------
   public void insertLast(long dd)   // insert at end of list
      {
      LinkD newLinkD = new LinkD(dd);   // make new link
      if( isEmpty() )                // if empty list,
         first = newLinkD;            // first --> newLinkD
      else
         {
         last.next = newLinkD;        // old last --> newLinkD
         newLinkD.previous = last;    // old last <-- newLinkD
         }
      last = newLinkD;                // newLinkD <-- last
      }
// -------------------------------------------------------------
   public LinkD deleteFirst()         // delete first link
      {                              // (assumes non-empty list)
      LinkD temp = first;
      if(first.next == null)         // if only one item
         last = null;                // null <-- last
      else
         first.next.previous = null; // null <-- old next
      first = first.next;            // first --> old next
      return temp;
      }
// -------------------------------------------------------------
   public LinkD deleteLast()          // delete last link
      {                              // (assumes non-empty list)
      LinkD temp = last;
      if(first.next == null)         // if only one item
         first = null;               // first --> null
      else
         last.previous.next = null;  // old previous --> null
      last = last.previous;          // old previous <-- last
      return temp;
      }
// -------------------------------------------------------------
                                     // insert dd just after key
   public boolean insertAfter(long key, long dd)
      {                              // (assumes non-empty list)
      LinkD current = first;          // start at beginning
      while(current.dData != key)    // until match is found,
         {
         current = current.next;     // move to next link
         if(current == null)
            return false;            // didn't find it
         }
      LinkD newLinkD = new LinkD(dd);   // make new link

      if(current==last)              // if last link,
         {
         newLinkD.next = null;        // newLinkD --> null
         last = newLinkD;             // newLinkD <-- last
         }
      else                           // not last link,
         {
         newLinkD.next = current.next; // newLinkD --> old next
                                      // newLinkD <-- old next
         current.next.previous = newLinkD;
         }
      newLinkD.previous = current;    // old current <-- newLinkD
      current.next = newLinkD;        // old current --> newLinkD
      return true;                   // found it, did insertion
      }
// -------------------------------------------------------------
   public LinkD deleteKey(long key)   // delete item w/ given key
      {                              // (assumes non-empty list)
      LinkD current = first;          // start at beginning
      while(current.dData != key)    // until match is found,
         {
         current = current.next;     // move to next link
         if(current == null)
            return null;             // didn't find it
         }
      if(current==first)             // found it; first item?
         first = current.next;       // first --> old next
      else                           // not first
                                     // old previous --> old next
         current.previous.next = current.next;

      if(current==last)              // last item?
         last = current.previous;    // old previous <-- last
      else                           // not last
                                     // old previous <-- old next
         current.next.previous = current.previous;
      return current;                // return value
      }
// -------------------------------------------------------------
   public void displayForward()
      {
      System.out.print("List (first-->last): ");
      LinkD current = first;          // start at beginning
      while(current != null)         // until end of list,
         {
         current.displayLinkD();      // display data
         current = current.next;     // move to next link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
   public void displayBackward()
      {
      System.out.print("List (last-->first): ");
      LinkD current = last;           // start at end
      while(current != null)         // until start of list,
         {
         current.displayLinkD();      // display data
         current = current.previous; // move to previous link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
   }  // end class DoublyLinkDedList

// Programming project 5.2
class Dequeue {
   LinkD first;
   LinkD last;

   public void insertFirst(long item) {
      LinkD newLink = new LinkD(item);
      newLink.next = first;
      if (!isEmpty())
         first.previous = newLink;
      else
         last = newLink;
      first = newLink;
   }

   boolean isEmpty() {return first == null;}

   public void insertLast(long item) {
      LinkD newLink = new LinkD(item);
      if (!isEmpty())
         last.next = newLink;
      else {
         first = newLink;
      }
      newLink.previous = last;
      last = newLink;
   }

   public void removeFirst() {
      if (isEmpty() || removeTheOnlyElement()) return;
      first.next.previous = null;
      first = first.next;

   }

   public void removeLast() {
      if (isEmpty() || removeTheOnlyElement()) return;
      last.previous.next = null;
      last = last.previous;
   }


   private boolean removeTheOnlyElement() {
      if (first.next == null) {
         first = null;
         last = null;
         return true;
      }
      return false;
   }

   public void dislay(boolean fromHead) {
      System.out.print(fromHead ? "first -> last " : "last -> first ");
      LinkD link = fromHead ? first : last;
      while (link != null) {
         link.displayLinkD();
         if (fromHead)
            link = link.next;
         else
            link = link.previous;
      }
      System.out.println();
   }

}

////////////////////////////////////////////////////////////////
class DoublyLinkDedApp
   {
   public static void main(String[] args)
      {                             // make a new list
//         doublyLinkedLisTest();
         dequeTest();
      }  // end main()

      private static void dequeTest() {
         Dequeue dequeue = new Dequeue();
         dequeue.insertFirst(22);
         dequeue.insertFirst(33);
         dequeue.dislay(true);
         dequeue.dislay(false);

         dequeue.insertLast(55);
         dequeue.insertLast(44);

         dequeue.dislay(true);
         dequeue.dislay(false);

      }

      private static void doublyLinkedLisTest() {
         DoublyLinkDedList theList = new DoublyLinkDedList();

         theList.insertFirst(22);      // insert at front
         theList.insertFirst(44);
         theList.insertFirst(66);

         theList.insertLast(11);       // insert at rear
         theList.insertLast(33);
         theList.insertLast(55);

         theList.displayForward();     // display list forward
         theList.displayBackward();    // display list backward

         theList.deleteFirst();        // delete first item
         theList.deleteLast();         // delete last item
         theList.deleteKey(11);        // delete item with key 11

         theList.displayForward();     // display list forward

         theList.insertAfter(22, 77);  // insert 77 after 22
         theList.insertAfter(33, 88);  // insert 88 after 33

         theList.displayForward();     // display list forward
      }
   }  // end class DoublyLinkDedApp
////////////////////////////////////////////////////////////////
