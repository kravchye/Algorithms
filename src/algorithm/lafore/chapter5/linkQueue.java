package algorithm.lafore.chapter5;

// linkQueue.java
// demonstrates queue implemented as double-ended list
// to run this program: C>java LinkQQueueApp
////////////////////////////////////////////////////////////////
class LinkQ
   {
   public long dData;                // data item
   public LinkQ next;                 // next link in list
// -------------------------------------------------------------
   public LinkQ(long d)               // constructor
      { dData = d; }
// -------------------------------------------------------------
   public void displayLinkQ()         // display this link
      { System.out.print(dData + " "); }
// -------------------------------------------------------------
   }  // end class LinkQ

////////////////////////////////////////////////////////////////
class FirstLastListQ
   {
   private LinkQ first;               // ref to first item
   private LinkQ last;                // ref to last item
// -------------------------------------------------------------
   public FirstLastListQ()            // constructor
      {
      first = null;                  // no items on list yet
      last = null;
      }
// -------------------------------------------------------------
   public boolean isEmpty()          // true if no links
      { return first==null; }
// -------------------------------------------------------------
   public void insertLast(long dd) // insert at end of list
      {
      LinkQ newLinkQ = new LinkQ(dd);   // make new link
      if( isEmpty() )                // if empty list,
         first = newLinkQ;            // first --> newLinkQ
      else
         last.next = newLinkQ;        // old last --> newLinkQ
      last = newLinkQ;                // newLinkQ <-- last
      }
// -------------------------------------------------------------
   public long deleteFirst()         // delete first link
      {                              // (assumes non-empty list)
      long temp = first.dData;
      if(first.next == null)         // if only one item
         last = null;                // null <-- last
      first = first.next;            // first --> old next
      return temp;
      }
// -------------------------------------------------------------
   public void displayList()
      {
      LinkQ current = first;          // start at beginning
      while(current != null)         // until end of list,
         {
         current.displayLinkQ();      // print data
         current = current.next;     // move to next link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
   }  // end class FirstLastList

////////////////////////////////////////////////////////////////
class LinkQQueue
   {
   private FirstLastListQ theList;
//--------------------------------------------------------------
   public LinkQQueue()                // constructor
      { theList = new FirstLastListQ(); }  // make a 2-ended list
//--------------------------------------------------------------
   public boolean isEmpty()          // true if queue is empty
      { return theList.isEmpty(); }
//--------------------------------------------------------------
   public void insert(long j)        // insert, rear of queue
      { theList.insertLast(j); }
//--------------------------------------------------------------
   public long remove()              // remove, front of queue
      {  return theList.deleteFirst();  }
//--------------------------------------------------------------
   public void displayQueue()
      {
      System.out.print("Queue (front-->rear): ");
      theList.displayList();
      }
//--------------------------------------------------------------
   }  // end class LinkQQueue

////////////////////////////////////////////////////////////////
class LinkQQueueApp
   {
   public static void main(String[] args)
      {
      LinkQQueue theQueue = new LinkQQueue();
      theQueue.insert(20);                 // insert items
      theQueue.insert(40);

      theQueue.displayQueue();             // display queue

      theQueue.insert(60);                 // insert items
      theQueue.insert(80);

      theQueue.displayQueue();             // display queue

      theQueue.remove();                   // remove items
      theQueue.remove();

      theQueue.displayQueue();             // display queue
      }  // end main()
   }  // end class LinkQQueueApp
////////////////////////////////////////////////////////////////
