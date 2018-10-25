package algorithm.lafore.chapter5;

// linkList2.java
// demonstrates linked list
// to run this program: C>java Link2List2App
////////////////////////////////////////////////////////////////
class Link2
   {
   public int iData;              // data item (key)
   public double dData;           // data item
   public Link2 next;              // next link in list
// -------------------------------------------------------------
   public Link2(int id, double dd) // constructor
      {
      iData = id;
      dData = dd;
      }
// -------------------------------------------------------------
   public void displayLink2()      // display ourself
      {
      System.out.print("{" + iData + ", " + dData + "} ");
      }
   }  // end class Link2

////////////////////////////////////////////////////////////////
class Link2List
   {
   private Link2 first;            // ref to first link on list

// -------------------------------------------------------------
   public Link2List()              // constructor
      {
      first = null;               // no links on list yet
      }
// -------------------------------------------------------------
   public void insertFirst(int id, double dd)
      {                           // make new link
      Link2 newLink2 = new Link2(id, dd);
      newLink2.next = first;       // it points to old first link
      first = newLink2;            // now first points to this
      }
// -------------------------------------------------------------
   public Link2 find(int key)      // find link with given key
      {                           // (assumes non-empty list)
      Link2 current = first;              // start at 'first'
      while(current.iData != key)        // while no match,
         {
         if(current.next == null)        // if end of list,
            return null;                 // didn't find it
         else                            // not end of list,
            current = current.next;      // go to next link
         }
      return current;                    // found it
      }
// -------------------------------------------------------------
   public Link2 delete(int key)    // delete link with given key
      {                           // (assumes non-empty list)
      Link2 current = first;              // search for link
      Link2 previous = first;
      while(current.iData != key)
         {
         if(current.next == null)
            return null;                 // didn't find it
         else
            {
            previous = current;          // go to next link
            current = current.next;
            }
         }                               // found it
      if(current == first)               // if first link,
         first = first.next;             //    change first
      else                               // otherwise,
         previous.next = current.next;   //    bypass it
      return current;
      }
// -------------------------------------------------------------
   public void displayList()      // display the list
      {
      System.out.print("List (first-->last): ");
      Link2 current = first;       // start at beginning of list
      while(current != null)      // until end of list,
         {
         current.displayLink2();   // print data
         current = current.next;  // move to next link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
   }  // end class Link2List

////////////////////////////////////////////////////////////////
class Link2List2App
   {
   public static void main(String[] args)
      {
      Link2List theList = new Link2List();  // make list

      theList.insertFirst(22, 2.99);      // insert 4 items
      theList.insertFirst(44, 4.99);
      theList.insertFirst(66, 6.99);
      theList.insertFirst(88, 8.99);

      theList.displayList();              // display list

      Link2 f = theList.find(44);          // find item
      if( f != null)
         System.out.println("Found link with key " + f.iData);
      else
         System.out.println("Can't find link");

      Link2 d = theList.delete(66);        // delete item
      if( d != null )
         System.out.println("Deleted link with key " + d.iData);
      else
         System.out.println("Can't delete link");

      theList.displayList();              // display list
      }  // end main()
   }  // end class Link2List2App
////////////////////////////////////////////////////////////////
