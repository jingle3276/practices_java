package sort;

/**
02:    This class implements a version of the
03:    quicksort algorithm using a partition
04:    algorithm that does not rely on the
05:    first element of the array being vacant,
06:    nor does it guarantee that the chosen
07:    pivot value is at the split point of
08:    the partition.
09: 
10:    @author Cay Horstmann
11: */
  public class QSort
 {
    public QSort(int[] anArray)
    {
        a = anArray;
    }
  
     /**
       Sorts the array managed by this sorter
     */
     public void sort()
     {
       sort(0, a.length - 1);
     }
  
    public void sort(int low, int high)
     {
       if (low >= high) return;
       int p = partition(low, high);
       sort(low, p);
        sort(p + 1, high);
     }
 
    private int partition(int low, int high)
    {
       // First element
       int pivot = a[low];
 
       // Middle element
       //int middle = (low + high) / 2;
       //int pivot = a[middle];
 
       int i = low - 1;
       int j = high + 1;
        while (i < j)
       {
         i++; 
         
         while (a[i] < pivot) 
        	 i++;
         
         j--;
         
         while (a[j] > pivot) 
        	 j--;
         
         if (i < j) 
        	 swap(i, j);
       }
        return j;
    }
 
    /**
       Swaps two entries of the array.
       @param i the first position to swap
       @param j the second position to swap
     */
    private void swap(int i, int j)
    {
       int temp = a[i];
       a[i] = a[j];
       a[j] = temp;
     }
 
    private int[] a;
 }

