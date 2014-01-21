package sort;

import java.util.Random;

public class Sort {

	//practice 2011-04-28
	public static void selectSort(int [] arr){
		if(arr==null || arr.length==0)
			throw new IllegalArgumentException();
		
		//if(arr.length==1)
			//return ;
		
		for(int i=0; i<arr.length; i++){
			int minPos = i; 
			for( int j= i+1; j<arr.length; j++){
				if(arr[j] < arr[minPos])
					minPos = j;
			}
			if(minPos!=i){
				int temp = arr[i];
				arr[i] = arr[minPos];
				arr[minPos] = temp;
			}
		}
	}
	
	
	/**
	 * in-line sort the array from leftMost to rightMost. 
	 * 
	 * pseudo-code:
	 * for(i=first; i<=last; i++){
	 *     small = i ; 
	 *     
	 *     for(j=i+1; j<=last; j++){
	 *     		if(arr[j]<arr[small]){
	 *     			small = j;
	 *     		}
	 *     }
	 *     
	 *     if(i!=small)
	 *     	 swap(i,small);
	 * }
	 * 
	 * SelectionSort Analysis:
	 * major cost:    for(i=0; i<=last;i++)	
	 * 					swap(arr[i], arr[suitable Index] );					
	 *    cost = (n)* (constant + the cost of finding the suitable index)
	 *    	   = (n)* (constant + 5 + (some other constants)*n)	
	 *         = (n)* (n)
	 *         = O(n^2)
	 *         
	 *  The cost of selectionSort doesn't depend on the inital values of arr.
	 *  average-case, best-case, worst-case are all O(n^2).         
	 *  
	 */
	public static void selectionSort(int[] arr, int first , int last ){
		
		int i, j ;
		int small ;
		int temp;
		for(i=first; i<=last ;i++){ //outer loop, i is the border of the sorted
								    //array
			small = i; //assume the first if the smallest element
			for(j=i+1; j<=last;j++){
				if(arr[j]<arr[small])
					small = j;
			}
			//swap arr[i] with arr[small]
			if(i!=small){
				temp = arr[small];
				arr[small] = arr[i];
				arr[i] = temp;
			}
		}
		
	}//end selectionSort()
	
	/**
	 * for practice 
	 * @param arr
	 * @param first
	 * @param last
	 */
	public static void selectSort(int[] arr, int first, int last){
		int smallestIndex ;
		for(int i=first; i<=last ; i++){
			
			smallestIndex = i;
			
			for(int j=i; j<=last; j++){
				if(arr[j]<arr[smallestIndex])
					smallestIndex = j;
			}
			
			swap(arr, i, smallestIndex);
		}
	}
	
	
	/**
	 * in-line sort, take one number each time, and build a sorted arr in the
	 * front. Inner loop go backwards!
	 * Invirant: keep the sorted array from data[first] to data[first+i]
	 * 
	 * for(j=first+i; (j-1)>=first && arr[j] is the wrong spot for current; j--)
	 * 	 data[j] = data[j-1]; 
	 * 		
	 * Analysis: 
	 *  insertion of onw new item takes O(n) and there are n items to insert. 
	 *  cost = O(n^2)
	 *  worst-case: an array with {10,9,8,7,6 ...}  cost= n(n-1)/2= O(n^2)
	 *  average-case: cost = 1/2 O(n^2) = O(n^2)
	 *  best-case: {1,2,3,4,5,...}, cost = O(n);
	 *
	 */

	public static void insertionSort(int[] arr, int first){
		
		int i, j ; 
		int value ; 
		for(i=first+1; i<arr.length; i++){
			j = i ;
			value = arr[i]; 
			//inner loop, go backwards. 
			while(j>first && arr[j-1]>value){
				arr[j]=arr[j-1];
				j--;
			}
			if(i!=j)
				arr[j]=value;
			
		}
		
	}
	
	/**
	 * for practice 
	 * @param arr
	 * @param first
	 * @param last
	 */
	public static void insertionSort(int[] arr, int first, int last){
		
		for(int i= first+1 ; i<=last ; i++){
			int j = i; 
			int val = arr[i];
			
			while(j-1>=first && arr[j-1]>val){
				arr[j] = arr[j-1];
				j--;
				
			}
			
			arr[j] = val ; 
			
		}
		
	}
	
	
	/**
	 * 
	 * @param arr
	 * @param first
	 * @param last
	 */
	public static void bubbleSort(int[] arr, int first, int last){
		boolean exchanges = false; 
		//int pass = 0;
		
		while(true){
			
			for(int i= first+1 ; i<=last; i++){
				if(arr[i-1]>arr[i]){
					swap(arr,i-1,i);
					exchanges = true ; 
				}	
			} //one pass
		
			if(exchanges==true){
				//pass++;
				exchanges = false;
				continue;
			}
			else
				break;
		
		}
	}
	
	/**
	 * cost = O(nlogn)
	 * 
	 */
	public static void mergeSort(Comparable[] arr, int first, int last){
		
		if(first==last){ //base case
			return ;
		}
		
		int mid = (first+last)/2;
		mergeSort(arr,first,mid);
		mergeSort(arr,mid+1,last);
		merge(arr,first, mid, last);
	}
	
	/**
	 * need a temp array. 
	 * merge method for mergeSort()
	 * 
	 */
	public static void merge(Comparable[] arr, int first, int mid, int last){
		
		Comparable[] tempArr = new Comparable[last-first+1];
		int i=first, j=mid+1, k=0; 
		
		while(k<tempArr.length){
			
			if(i>mid){ //first half is done, copy all of the second 
				//to tempArr
				while(j<=last){
					tempArr[k++] = arr[j++];
				}
				break;
			}
			if(j>last){
				while(i<=mid){
					tempArr[k++] = arr[i++];
				}
				break;
			}
			
			if(arr[i].compareTo(arr[j])==0 || arr[i].compareTo(arr[j])==-1)
				tempArr[k++] = arr[i++];
			else
				tempArr[k++] = arr[j++];
			
		}
	
		//copy the temp back to arr
		for(i=first, k=0; i<=last ; i++){
			arr[i] = tempArr[k++];
		}

	}
	
 
	/**
	 * a different way of implementation of quickSort.
	 * @param arr
	 * @param first
	 * @param last
	 */
	public static void QSort(int[] arr, int first, int last ){
		
		if(first>=last) 
			return ;  //base case
		
		//recursive case
		int pivotIndex ;
 
		pivotIndex = (last+first)/2;
		
		int pivot = arr[pivotIndex];
	
		swap(arr, pivotIndex, last);
	
		int i = first-1 ; 
		int j = last  ;
		
		/*while(i<j){
			
			while(i<=last && arr[i]<pivot) i++;
			while(j>=first && arr[j]>pivot) j--;
			
			if(i<j)
				swap(arr, i, j);
		}//when this loop stops, i will point to the first item in I2.
		 //j will point to the last item in I1.
		*/
		
		do{
			
			do{ i++ ; } while(i<=last && arr[i]<pivot) ;
			do{ j-- ; } while(j>=first && arr[j]>pivot);
				
			if(i<j)
				swap(arr,i,j);
			
		}while(i<j);
		
		
		
		swap(arr,i,last); //move the pivot back.
		
		QSort(arr,first, i-1 );
		QSort(arr, i+1, last );
		
	}
	
	
	
	
	
	/**
	 * in-place sort the array
	 * 
	 */
	
	public static void quickSort(int[] arr, int first, int last){
		
		if(first>=last)
			return ;
		
		int pivotIndex ; 
	
		pivotIndex = partition2(arr,first, last);
			
		quickSort(arr, first, pivotIndex-1); //should not be pivotIndex
		quickSort(arr, pivotIndex+1, last);	
	}
	
	
	public static int partition2(int[] arr, int first, int last ){
		
		int pivot = arr[first];
		
		int i=first, j=last+1;
		
		do{
			do{i++;} while(i<=last && arr[i]<pivot);
			do{j--;} while(j>=first && arr[j]>pivot);
			
			if(i<j)  
				swap(arr,i,j);
			
		}while(i<j);
		
		
		swap(arr,j,first);
		return j;

	}
	

	/**
	 * 
	 */
	public static int partition(int[] arr, int first, int last){
		
	    //int middle = (first + last) / 2;
	    //int pivot = arr[middle];
		
		int pivot = arr[first];
		int i = first + 1 , j = last; 
		
		while(i<=j){
	
			while(i<=last && arr[i]<pivot){ //can't be arr[i]<=pivot, won't work
				i++;
			}
			
			while(j>=first && arr[j]>pivot){
				j--;
			}
			
			if(i<=j){
				swap(arr, i,j);
				i++;
				j--;
			}
		}
		
		arr[first] = arr[j];
		arr[j] = pivot;
		
		return j ;
	}
	
	/**
	 * quick select 
	 * O(n)
	 * @param arr
	 * @param k the kth largest value in the array.
	 * @param first
	 * @param last
	 * @return
	 */
	public static int select(int[] arr, int k, int first, int last){
		
		if(k<first || k>last || first>last)
			throw new IllegalArgumentException();
		
		int pivotIndex = partition2(arr, first, last);
		
		if(k==pivotIndex)
			return arr[k];
		else if(k<pivotIndex)
			return select(arr,k,first,pivotIndex-1);
		else
			return select(arr,k,pivotIndex+1,last);
		
	}
	/**
	 * Iterative implementation of select in an array.
	 * 
	 */
	public static int selectIter(int[] arr, int k, int first, int last){
		if(k<first || k>last || first>last )
			throw new IllegalArgumentException();
		
		while(first<=last){
			int pivotIndex = partition(arr, first, last); 
			
			if(k==pivotIndex) return arr[k];
			
			else if(k<pivotIndex) last = pivotIndex -1 ;
			else first = pivotIndex + 1;
			
		}
		
		return 0x7FFFFFFF;//doesn't matter
		
	}
	

	/**
	 * using partition recursively to select the kth largest element in 
	 * an array. 
	 * 
	 * O(n)
	 * @return
	 */
	public static int selectKth(int[] arr, int first, int last, int k){
		
		int pivotPos = partition(arr, first, last); 
		
		if(k==pivotPos)  //base case
			return arr[pivotPos];
		
		if(k<pivotPos){      //recurisive case (look at the first half)
			//pivotPos = partition(arr, first, pivotPos-1);
			return selectKth(arr, first, pivotPos-1, k);
			
		}
			
		else {
			//pivotPos = partition(arr, pivotPos+1, last);
			return selectKth(arr, pivotPos+1, last, k);
		}	

	}

	
	/**
	 * Helper method to swap two items in the array. 
	 * 	 
	 */
	public static void swap(int[] arr, int a, int b){
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	/**
	 * Inline sort the array
	 * Cost = O(n*log(n)) , worst-case, average-case
	 * 
	 * @param arr
	 * @param first
	 * @param last
	 */
	
	public static void heapSort(int[] arr, int first, int last){
		
		makeHeap(arr, first, last);
		int lastPos = last;
		
		while(lastPos>=first){
			swap(arr, first, lastPos);
			heapify(arr, first, lastPos-1);
			lastPos--;
		}
		
	}
	
	public static void heapify(int[] arr, int first, int last){
		int cursor = first ;
		int childPos;
		
		while(2*cursor+1<=last && arr[cursor]<arr[2*cursor+1]){
			childPos = 2*cursor+1;
			
			if(childPos+1<=last && arr[childPos]<arr[childPos+1] )
				childPos++;
			//now childPos pointing to the large children of i
			swap(arr, cursor, childPos);
			cursor = childPos;
		}
		
	}
	
	/**
	 * 
	 * go through left to right, first assume the left array is a heap, then
	 * increment i by one and fix the heap from right to left(upward).
	 */
	public static void makeHeap(int[] arr, int first, int last){
		
		for(int i=first+1; i<=last; i++ ){
			
			int cursor = i ;
			
			while(parent(cursor)>=first && arr[cursor] > arr[parent(cursor)]){
				swap(arr, cursor, parent(cursor));
				cursor = parent(cursor);
			}
		}
	}
	
	public static int parent(int i){
		return (i-1)/2;
	}
	

	
	/**
	 * 
	 *  
	 */
	public static void countingSort(Comparable[] arr, int range){
		int [] count = new int[range];
		int [] start = new int[range]; 
		Comparable [] result = new Comparable[arr.length];
		
		for(int i=0; i<arr.length; i++){
			Student s = (Student)arr[i];
			count[s.getId()]++;
		}
		
		start[0]=0;
		for(int i=1; i<range;i++){
			start[i] = count[i-1]+start[i-1];
		}
		
		int index ; 
		int value ;
		for(int i = 0; i<arr.length ; i++){
			Student s = (Student) arr[i];
			value = s.getId();
			index = start[value];
			start[value]++;
			result[index] = s;
		}
		
		for(int i = 0; i<arr.length ; i++){
			arr[i] = result[i];
		}

	}

	
	public static void main(String args[]){
		
		int [] a = {4,2,6,8,10,1};
		int[] b = {2};
		//int [] c = {54,53,53,46};
		//int [] c = SortTest.randomArr(10);
		
		
		//SortTest.printArr(b,"");
		//insertionSort(a, 0);
		//insertionSort(a, 0,0);
		selectSort(b);
		//selectionSort(b,0,0);
		//SortTest.printArr(b,"");
		
		//System.out.println(selectIter(a,5,0,a.length-1));
		
		Student [] s = { new Student(1,"s1"), new Student(6,"s6"), 
				new Student(3,"s3"), new Student(6,"s66"), new Student(6,"s666")} ;

		countingSort(s,7);
		//selectSort(a,0,5);
		/*for(int i =0; i<s.length;i++){
			System.out.println(s[i].toString());
		}
		*/
		//SortTest.printArr(a,"");
		
		
		//mergeSort(a, 0, 6);
		//selectionSort(a,0,6);
		//insertionSort2(a,0,4);
		//mergeSort(a,0,5);
		//quickSort(c,0,c.length-1);
		//QSort qc = new QSort(a);
		//qc.sort();
		//System.out.println(selectKth(a,0,5,9));
		System.out.println(select(a,3,0,5));
		//System.out.println(partition2(c,0,c.length-1));
		//heapSort(c,0,6);
		//bubbleSort(c,0,3);
		//insertionSort(c,0);
		//QSort(c,0,c.length-1 );
		//quickSort(c,0,c.length-1);
		//SortTest.printArr(c, "");
		//System.out.println(SortTest.isSorted(c));
		
		//System.out.println(randomPiv(3,7));
		//isSorted(a,0,5);
	
	}//end main
	
}
