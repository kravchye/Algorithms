package algorithm.lafore.chapter5;

// linkStack.java
// demonstrates a stack implemented as a list
// to run this program: C>java LinkSStackApp
////////////////////////////////////////////////////////////////
class LinkS
   {
   public long dData;             // data item
   public LinkS next;              // next link in list
// -------------------------------------------------------------
   public LinkS(long dd)           // constructor
      { dData = dd; }
// -------------------------------------------------------------
   public void displayLinkS()      // display ourself
      { System.out.print(dData + " "); }
   }  // end class LinkS

////////////////////////////////////////////////////////////////
class LinkSList
   {
   private LinkS first;            // ref to first item on list
// -------------------------------------------------------------
   public LinkSList()              // constructor
      { first = null; }           // no items on list yet
// -------------------------------------------------------------
   public boolean isEmpty()       // true if list is empty
      { return (first==null); }
// -------------------------------------------------------------
   public void insertFirst(long dd) // insert at start of list
      {                           // make new link
      LinkS newLinkS = new LinkS(dd);
      newLinkS.next = first;       // newLinkS --> old first
      first = newLinkS;            // first --> newLinkS
      }
// -------------------------------------------------------------
   public long deleteFirst()      // delete first item
      {                           // (assumes list not empty)
      LinkS temp = first;          // save reference to link
      first = first.next;         // delete it: first-->old next
      return temp.dData;          // return deleted link
      }
// -------------------------------------------------------------
   public void displayList()
      {
      LinkS current = first;       // start at beginning of list
      while(current != null)      // until end of list,
         {
         current.displayLinkS();   // print data
         current = current.next;  // move to next link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
   }  // end class LinkSList

////////////////////////////////////////////////////////////////
class LinkSStack
   {
   private LinkSList theList;
//--------------------------------------------------------------
   public LinkSStack()             // constructor
      {
      theList = new LinkSList();
      }
//--------------------------------------------------------------
   public void push(long j)     // put item on top of stack
      {
      theList.insertFirst(j);
      }
//--------------------------------------------------------------
   public long pop()            // take item from top of stack
      {
      return theList.deleteFirst();
      }
//--------------------------------------------------------------
   public boolean isEmpty()       // true if stack is empty
      {
      return ( theList.isEmpty() );
      }
//--------------------------------------------------------------
   public void displayStack()
      {
      System.out.print("Stack (top-->bottom): ");
      theList.displayList();
      }
//--------------------------------------------------------------
   }  // end class LinkSStack

////////////////////////////////////////////////////////////////
class LinkSStackApp
   {
   public static void main(String[] args)
      {
      LinkSStack theStack = new LinkSStack(); // make stack

      theStack.push(20);                    // push items
      theStack.push(40);

      theStack.displayStack();              // display stack

      theStack.push(60);                    // push items
      theStack.push(80);

      theStack.displayStack();              // display stack

      theStack.pop();                       // pop items
      theStack.pop();

      theStack.displayStack();              // display stack
      }  // end main()
   }  // end class LinkSStackApp
////////////////////////////////////////////////////////////////
