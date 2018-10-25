package algorithm.lafore.chapter5;// interIterator.java
// demonstrates iterators on a linked listListIterator
// to run this program: C>java InterIterApp

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

////////////////////////////////////////////////////////////////
class LinkIt
   {
   public long dData;             // data item
   public LinkIt next;              // next link in list
// -------------------------------------------------------------
   public LinkIt(long dd)           // constructor
      { dData = dd; }
// -------------------------------------------------------------
   public void displayLinkIt()      // display ourself
      { System.out.print(dData + " "); }
   }  // end class LinkIt

////////////////////////////////////////////////////////////////
class LinkItList
   {
   private LinkIt first;            // ref to first item on list

// -------------------------------------------------------------
   public LinkItList()              // constructor
      { first = null; }           // no items on list yet
// -------------------------------------------------------------
   public LinkIt getFirst()         // get value of first
      { return first; }
// -------------------------------------------------------------
   public void setFirst(LinkIt f)   // set first to new link
      { first = f; }
// -------------------------------------------------------------
   public boolean isEmpty()       // true if list is empty
      { return first==null; }
// -------------------------------------------------------------
   public ListIterator getIterator()  // return iterator
      {
      return new ListIterator(this);  // initialized with
      }                               //    this list
// -------------------------------------------------------------
   public void displayList()
      {
      LinkIt current = first;       // start at beginning of list
      while(current != null)      // until end of list,
         {
         current.displayLinkIt();   // print data
         current = current.next;  // move to next link
         }
      System.out.println("");
      }
// -------------------------------------------------------------
   }  // end class LinkItList

////////////////////////////////////////////////////////////////
class ListIterator
   {
   private LinkIt current;          // current link
   private LinkIt previous;         // previous link
   private LinkItList ourList;      // our linked list
//--------------------------------------------------------------
   public ListIterator(LinkItList list) // constructor
      {
      ourList = list;
      reset();
      }
//--------------------------------------------------------------
   public void reset()            // start at 'first'
      {
      current = ourList.getFirst();
      previous = null;
      }
//--------------------------------------------------------------
   public boolean atEnd()         // true if last link
      { return (current.next==null); }
//--------------------------------------------------------------
   public void nextLinkIt()         // go to next link
      {
      previous = current;
      current = current.next;
      }
//--------------------------------------------------------------
   public LinkIt getCurrent()       // get current link
      { return current; }
//--------------------------------------------------------------
   public void insertAfter(long dd)     // insert after
      {                                 // current link
      LinkIt newLinkIt = new LinkIt(dd);

      if( ourList.isEmpty() )     // empty list
         {
         ourList.setFirst(newLinkIt);
         current = newLinkIt;
         }
      else                        // not empty
         {
         newLinkIt.next = current.next;
         current.next = newLinkIt;
         nextLinkIt();              // point to new link
         }
      }
//--------------------------------------------------------------
   public void insertBefore(long dd)    // insert before
      {                                 // current link
      LinkIt newLinkIt = new LinkIt(dd);

      if(previous == null)        // beginning of list
         {                        // (or empty list)
         newLinkIt.next = ourList.getFirst();
         ourList.setFirst(newLinkIt);
         reset();
         }
      else                        // not beginning
         {
         newLinkIt.next = previous.next;
         previous.next = newLinkIt;
         current = newLinkIt;
         }
      }
//--------------------------------------------------------------
   public long deleteCurrent()    // delete item at current
      {
      long value = current.dData;
      if(previous == null)        // beginning of list
         {
         ourList.setFirst(current.next);
         reset();
         }
      else                        // not beginning
         {
         previous.next = current.next;
         if( atEnd() )
            reset();
         else
            current = current.next;
         }
      return value;
      }
//--------------------------------------------------------------
   }  // end class ListIterator

////////////////////////////////////////////////////////////////
class InterIterApp
   {
   public static void main(String[] args) throws IOException
      {
      LinkItList theList = new LinkItList();           // new list
      ListIterator iter1 = theList.getIterator();  // new iter
      long value;

      iter1.insertAfter(20);             // insert items
      iter1.insertAfter(40);
      iter1.insertAfter(80);
      iter1.insertBefore(60);

      while(true)
         {
         System.out.print("Enter first letter of show, reset, ");
         System.out.print("next, get, before, after, delete: ");
         System.out.flush();
         int choice = getChar();         // get user's option
         switch(choice)
            {
            case 's':                    // show list
               if( !theList.isEmpty() )
                  theList.displayList();
               else
                  System.out.println("List is empty");
               break;
            case 'r':                    // reset (to first)
               iter1.reset();
               break;
            case 'n':                    // advance to next item
               if( !theList.isEmpty() && !iter1.atEnd() )
                  iter1.nextLinkIt();
               else
                  System.out.println("Can't go to next link");
               break;
            case 'g':                    // get current item
               if( !theList.isEmpty() )
                  {
                  value = iter1.getCurrent().dData;
                  System.out.println("Returned " + value);
                  }
               else
                  System.out.println("List is empty");
               break;
            case 'b':                    // insert before current
               System.out.print("Enter value to insert: ");
               System.out.flush();
               value = getInt();
               iter1.insertBefore(value);
               break;
            case 'a':                    // insert after current
               System.out.print("Enter value to insert: ");
               System.out.flush();
               value = getInt();
               iter1.insertAfter(value);
               break;
            case 'd':                    // delete current item
               if( !theList.isEmpty() )
                  {
                  value = iter1.deleteCurrent();
                  System.out.println("Deleted " + value);
                  }
               else
                  System.out.println("Can't delete");
               break;
            default:
               System.out.println("Invalid entry");
            }  // end switch
         }  // end while
      }  // end main()
//--------------------------------------------------------------
   public static String getString() throws IOException
      {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      String s = br.readLine();
      return s;
      }
//-------------------------------------------------------------
   public static char getChar() throws IOException
      {
      String s = getString();
      return s.charAt(0);
      }

//-------------------------------------------------------------
   public static int getInt() throws IOException
      {
      String s = getString();
      return Integer.parseInt(s);
      }
//-------------------------------------------------------------
   }  // end class InterIterApp
////////////////////////////////////////////////////////////////
