package algorithm.lafore.chapter3;

import algorithm.lafore.chapter2.BaseArray;

// insertSort.java
// demonstrates insertion sort
// to run this program: C>java InsertSortApp
//--------------------------------------------------------------
class ArrayIns extends BaseArray {
      public ArrayIns(int max) {
         super(max);
      }
//--------------------------------------------------------------
   public void insertionSort()
      {
      int in, out, comparision = 0, copies = 0;

      for(out=1; out<nElems; out++)     // out is dividing line
         {
         long temp = a[out];            // remove marked item
         copies++;
         in = out;
            // start shifts at out
         while(in > 0 ) // until one is smaller,
            {
               if (a[in-1] <= temp) {
                  comparision++;
                  break;
               }
            a[in] = a[in-1];            // shift item to right
            copies++;
            --in;                       // go left one position
            }
         a[in] = temp;                  // insert marked item
         copies++;
         }  // end for

         // Programming project 3.5
         System.out.printf("Copies %s, Comparison %s \n \n", copies, comparision);
      }  // end insertionSort()
//--------------------------------------------------------------
//--Programming project 3.6
public void insertionSortNoDups()
{
   int in, out, numDups=0 ;
   for(out=1; out<nElems; out++)     // out is dividing line
   {

      long temp = a[out];            // remove marked item
      in = out;

      // start shifts at out
      while(in > 0 && a[in-1] >= temp) // until one is smaller,
      {
          if(a[in-1] == temp && temp > -1)
          {
              temp = -1;
              numDups++;
          }
         a[in] = a[in-1];            // shift item to right
         --in;
         // go left one position
      }
      a[in] = temp;                  // insert marked item
   }  // end for
    for (int i = 0; i < nElems - numDups; i++) {
        a[i] = a[i+numDups];
    }
    nElems -=numDups;
}
//--------------------------------------------------------------


   // Programming project 3.2
   public long median() {
         ArrayIns arr = new ArrayIns(nElems);
         for (int i = 0; i < nElems; i++) {
            arr.insert(a[i]);
         }
         arr.insertionSort();
         if (arr.nElems % 2 == 0) { //if 2 median numbers
             return (arr.a[nElems/2] + arr.a[nElems/2 + 1]) /2;// get average of 2
         } else {
             return arr.a[nElems/2];
         }
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
