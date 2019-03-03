package algorithm.lafore.chapter4;

// Programming project 4.4
class PriorityQueue
   {
   private int maxSize;
   private long[] queArray;
   private int nItems;
//-------------------------------------------------------------
   public PriorityQueue(int s)          // constructor
      {
      maxSize = s;
      queArray = new long[maxSize];
      nItems = 0;
      }
//-------------------------------------------------------------
//   public void insert(long item)    // insert item
//      {
//      int j;
//
//      if(nItems==0)                         // if no items,
//         queArray[nItems++] = item;         // insert at 0
//      else                                // if items,
//         {
//         for(j=nItems-1; j>=0; j--)         // start at end,
//            {
//            if( item > queArray[j] )      // if new item larger,
//               queArray[j+1] = queArray[j]; // shift upward
//            else                          // if smaller,
//               break;                     // done shifting
//            }  // end for
//         queArray[j+1] = item;            // insert it
//         nItems++;
//         }  // end else (nItems > 0)
//      }  // end insert()

   public void insert(long item) {
      queArray[nItems++] = item;
   }
//-------------------------------------------------------------
   public long remove() {
      int min = getMinPos();
      long removed = queArray[min];
      for (int j =  min; j < queArray.length - 1; j++) {
         queArray[j] = queArray[j + 1];
      }
      nItems--;
      return removed;
   }
//-------------------------------------------------------------
   public long peekMin() {
      return queArray[getMinPos()];
   }

   public int getMinPos() {
      if (isEmpty()) return -1;
      int min = 0;
      for (int i = 1; i < nItems; i++) {
         if (queArray[min] > queArray[i]) {
            min = i;
         }
      }
      return min;
   }
//-------------------------------------------------------------
   public boolean isEmpty()         // true if queue is empty
      { return (nItems==0); }
//-------------------------------------------------------------
   public boolean isFull()          // true if queue is full
      { return (nItems == maxSize); }
//-------------------------------------------------------------
   }  // end class PriorityQueue
////////////////////////////////////////////////////////////////
class PriorityQApp
   {
   public static void main(String[] args)
      {
      PriorityQueue thePQ = new PriorityQueue(5);
      thePQ.insert(30);
      thePQ.insert(50);
      thePQ.insert(10);
      thePQ.insert(40);
      thePQ.insert(20);

      while( !thePQ.isEmpty() )
         {
         long item = thePQ.remove();
         System.out.print(item + " ");  // 10, 20, 30, 40, 50
         }  // end while
      System.out.println("");
      }  // end main()
//-------------------------------------------------------------
   }  // end class PriorityQApp
////////////////////////////////////////////////////////////////
