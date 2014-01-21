package sort;
 

import junit.framework.*;
/**
 * 
 * @author Ying
 *
 */
public class SortTest extends TestCase{

	private final int SIZE = 8 ;

	
	public void testCountingSort(){
		Student [] arr = randomStu(10);
		printStu(arr,"");
		Sort.countingSort(arr,10);
		//ort.mergeSort(arr, 0, arr.length-1);
		printStu(arr,"");

		assertTrue(isSortedCom(arr));
		
	}
	
	
	public void testQSort(){
		int [] arr = randomArr(SIZE);
		//printArr(arr,"random:");
		Sort.QSort(arr, 0, arr.length-1 );
		//printArr(arr,"sorted:");
		assertTrue(isSorted(arr));
		
	}
	
 
	public void testQuickSort(){
		int [] arr = randomArr(SIZE);
		//printArr(arr,"");
		Sort.quickSort(arr, 0, arr.length-1);
		//printArr(arr,"");
		assertTrue(isSorted(arr));
		
		
		
	}
	
	
	
	public void testSelSort(){
		int[] arr = randomArr(10);
		//printArr(arr,"random:");
		//Sort.selSort(arr, 0, arr.length-1);
		//printArr(arr,"sorted:");
		assertTrue(isSorted(arr));
		
	}
	
	
	public void testSelectionSort(){
		//int[] arr = randomArr(10);
		int[] arr = {};
		//printArr(arr,"random:");
		Sort.selectionSort(arr, 0, arr.length-1);
		//printArr(arr,"sorted:");
		assertTrue("the selection sort failed.",isSorted(arr));
		
	}
	
	//test mergeSort
	public void testMergeSort(){
		//int [] arr = randomArr(SIZE);
		//printArr(arr,"random:");
		
		//Sort.mergeSort(arr,0,arr.length-1);
		//printArr(arr,"sorted:");
		//assertTrue(isSorted(arr));
	}
	
	public static boolean isSortedCom(Comparable[] arr){
		for(int i=1; i<arr.length; i++){
			
			if(arr[i].compareTo(arr[i-1])==-1)
				return false;
			
		}
		return true;
		
	}
	
	
	public static boolean isSorted(int[] arr){
		
		for(int i=1; i<arr.length; i++){
			if(arr[i]<arr[i-1])
				return false;
		}
		return true;
	}
	
	public static int[] randomArr(int size){
		
		int[] arr = new int[size];
		
		for(int i=0; i<arr.length;i++){
			arr[i] = (int)(Math.random()*100);
		}
		
		return arr;
	}
	
	public static Student[] randomStu(int size){
		
		Student[] arr = new Student[size];
		
		for(int i=0; i<arr.length;i++){
			
			String name = "s" + (int)(Math.random()*10);
			arr[i] =  new Student( (int)(Math.random()*10), name );
		}
		
		return arr;
	}
	
	public static void printStu(Student[] arr, String msg){
		
		if(msg.length()!=0)
			System.out.println(msg);
		
		int i = 0;
		while(i!=arr.length){
			System.out.print(arr[i].toString()+ " ");
			
			i++;
		}
		System.out.println();
		 
	}
	

	/**
	 * print out an array
	 * @param arr
	 */
	public static void printArr(int[] arr, String msg){
		
		if(msg.length()!=0)
			System.out.println(msg);
		
		int i = 0;
		while(i!=arr.length){
			System.out.print(arr[i] + " ");
			i++;
		}
		System.out.println();
	}
	
}
