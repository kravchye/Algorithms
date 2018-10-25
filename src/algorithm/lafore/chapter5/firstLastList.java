package algorithm.lafore.chapter5;

// firstLastList.java
// demonstrates list with first and last references
// to run this program: C>java FirstLastApp
////////////////////////////////////////////////////////////////
class LinkFL
   {
   public long dData;                 // data item
   public LinkFL next;                  // next link in list
// -------------------------------------------------------------
   public LinkFL(long d)                // constructor
      { dData = d; }
// -------------------------------------------------------------
   public void displayLinkFL()          // display this link
      { System.out.print(dData + " "); }
// -------------------------------------------------------------
   }  // end class LinkFL

////////////////////////////////////////////////////////////////
class FirstLastList
   {
   private LinkFL first;               // ref to first link
   private LinkFL last;                // ref to last link
// -------------------------------------------------------------
   public FirstLastList()            // constructor
      {
      first = null;                  // no links on list yet
      last = null;
      }
// -------------------------------------------------------------
   public boolean isEmpty()          // true if no links
      { return first==null; }
// -------------------------------------------------------------
   public void insertFirst(long dd)  // insert at front of list
      {
      LinkFL newLinkFL = new LinkFL(dd);   // make new link

      if( isEmpty() )                // if empty list,
         last = newLinkFL;             // newLinkFL <-- last
      newLinkFL.next = first;          // newLinkFL --> old first
      first = newLinkFL;               // first --> newLinkFL
      }
// -------------------------------------------------------------
   public void insertLast(long dd)   // insert at end of list
      {
      LinkFL newLinkFL = new LinkFL(dd);   // make new link
      if( isEmpty() )                // if empty list,
         first = newLinkFL;            // first --> newLinkFL
      else
         last.next = newLinkFL;        // old last --> newLinkFL
      last = newLinkFL;                // newLinkFL <-- last
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
      System.out.print("List (first-->last): ");
      LinkFL current = first;          // start at beginning
      while(current != null)         // until end of list,
         {
         current.displayLinkFL();      // print data
         current = current.next;     // move to next link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
   }  // end class FirstLastList

////////////////////////////////////////////////////////////////
class FirstLastApp
   {
   public static void main(String[] args)
      {                              // make a new list
      FirstLastList theList = new FirstLastList();

      theList.insertFirst(22);       // insert at front
      theList.insertFirst(44);
      theList.insertFirst(66);

      theList.insertLast(11);        // insert at rear
      theList.insertLast(33);
      theList.insertLast(55);

      theList.displayList();         // display the list

      theList.deleteFirst();         // delete first two items
      theList.deleteFirst();

      theList.displayList();         // display again
      }  // end main()
   }  // end class FirstLastApp
////////////////////////////////////////////////////////////////
