package algorithm.lafore.chapter3;

import algorithm.lafore.chapter2.BaseArray;

// selectSort.java
// demonstrates selection sort
// to run this program: C>java SelectSortApp
////////////////////////////////////////////////////////////////
class ArraySel extends BaseArray {
   public ArraySel(int max) {
      super(max);
   }

   //--------------------------------------------------------------
   public void selectionSort()
      {
      int out, in, min;

      for(out=0; out<nElems-1; out++)   // outer loop
         {
         min = out;                     // minimum
         for(in=out+1; in<nElems; in++) // inner loop
            if(a[in] < a[min] )         // if min greater,
                min = in;               // we have a new min
         swap(out, min);                // swap them
         }  // end for(out)
      }  // end selectionSort()

//--------------------------------------------------------------
   }  // end class ArraySel
////////////////////////////////////////////////////////////////
class SelectSortApp
   {
   public static void main(String[] args)
      {
      int maxSize = 100;            // array size
      ArraySel arr;                 // reference to array
      arr = new ArraySel(maxSize);  // create the array

      arr.insert(77);               // insert 10 items
      arr.insert(99);
      arr.insert(44);
      arr.insert(55);
      arr.insert(22);
      arr.insert(88);
      arr.insert(11);
      arr.insert(00);
      arr.insert(66);
      arr.insert(33);

      arr.display();                // display items

      arr.selectionSort();          // selection-sort them

      arr.display();                // display them again
      }  // end main()
   }  // end class SelectSortApp
////////////////////////////////////////////////////////////////
