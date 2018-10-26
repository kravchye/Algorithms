package algorithm.lafore.chapter3;

// insertSort.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
//--------------------------------------------------------------
class ArrayIns
   {
   private long[] a;                 // ref to array a
   private int nElems;               // number of data items
//--------------------------------------------------------------
   public ArrayIns(int max)          // constructor
      {
      a = new long[max];                 // create the array
      nElems = 0;                        // no items yet
      }
//--------------------------------------------------------------
   public void insert(long value)    // put element into array
      {
      a[nElems] = value;             // insert it
      nElems++;                      // increment size
      }
//--------------------------------------------------------------
   public void display()             // displays array contents
      {
      for(int j=0; j<nElems; j++)       // for each element,
         System.out.print(a[j] + " ");  // display it
      System.out.println("");
      }
//--------------------------------------------------------------
   public void insertionSort()
      {
      int in, out, comparision = 0, copies = 0;

      for(out=1; out<nElems; out++)     // out is dividing line
         {
         long temp = a[out];            // remove marked item
         in = out;
         comparision++; // comparison in while
            // start shifts at out
         while(in > 0 ) // until one is smaller,
            {
               comparision++;
               if (a[in-1] <= temp) {
                  comparision++;
                  break;
               } else {
                  comparision++;
               }
            a[in] = a[in-1];            // shift item to right
            copies++;
            --in;                       // go left one position
            }
         a[in] = temp;                  // insert marked item
         }  // end for

         // Programming project 3.5
         System.out.printf("Copies %s, Comparison %s \n \n", copies, comparision);
      }  // end insertionSort()
//--------------------------------------------------------------
//--Programming project 3.6
public void insertionSortNoDups()
{
   // TODO
   int in, out;
   for(out=1; out<nElems; out++)     // out is dividing line
   {

      long temp = a[out];            // remove marked item
      in = out;

      // start shifts at out
      while(in > 0 && a[in-1] >= temp) // until one is smaller,
      {
         a[in] = a[in-1];            // shift item to right
         --in;
         // go left one position
      }
      a[in] = temp;                  // insert marked item
   }  // end for
}
//--------------------------------------------------------------


   // Programming project 3.2
   public long median() {
      return a[nElems / 2];
   }
   //--------------------------------------------------------------
   // Programming project 3.3
   public void noDups() {
      insertionSort();
      long currentElem = Long.MIN_VALUE;
      int shiftCounter = 0;
      int total = nElems;
      for (int i = 0; i < nElems; i++) {
         if (a[i] == currentElem) {
            shiftCounter++;
            total--;
         } else {
            a[i - shiftCounter] = a[i];
            currentElem = a[i];
         }
      }
      nElems = total;
   }

//--------------------------------------------------------------
   }  // end class ArrayIns
////////////////////////////////////////////////////////////////
class InsertSortApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      ArrayIns arr;                 // reference to array
      arr = new ArrayIns(maxSize);  // create the array

      arr.insert(77);               // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(22);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(66);

      arr.display();                // display items

      arr.insertionSort();          // insertion-sort them

      arr.display();                // display them again

      System.out.println("median = " + arr.median());

      System.out.println("removing duplicates");
      arr.noDups();
      arr.display();

         programmingProject3_5(maxSize);

         programmingProject3_6(maxSize);
      }  // end main()

      private static void programmingProject3_5(int maxSize) {
         ArrayIns arr;
         arr = new ArrayIns(maxSize);  // create the array
         arr.insert(99);
         arr.insert(66);
         arr.insert(55);
         arr.insert(44);
         arr.insert(33);
         arr.insert(22);
         arr.insert(11);
         arr.insertionSort(); // Programming project 3.5 test
      }

      private static void programmingProject3_6(int maxSize) {
         ArrayIns arr;
         arr = new ArrayIns(maxSize);  // create the array
         arr.insert(99);               // insert 10 items
         arr.insert(88);
         arr.insert(88);
         arr.insert(66);
         arr.insert(55);
         arr.insert(55);
         arr.insert(11);
         arr.insert(33);
         arr.insert(33);
         System.out.println("Programming project 3.6 test");
         arr.insertionSortNoDups(); // Programming project 3.6 test
         arr.display();
      }
   }  // end class InsertSortApp
