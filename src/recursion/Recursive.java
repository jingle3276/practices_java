package recursion;

import java.util.ArrayList;

import linkedlist.LinkedList;

import dmv_queue.Queue;

/**
 * CSE214 Recitation 5, recursion practices.
 * 
 * @author Ying
 *
 */

public class Recursive {

	
	/**
	 * n! = n*(n-1)(n-2)...1
	 * 
	 * @param n
	 * @return
	 */
	public static int factorial(int n){
		
		if(n==1){
			return 1; //base case
		}
		
		else{
			return n*factorial(n-1);
		}
	}
	
	public static int factorialIter(int n){
		int result = 1; 
		for(int i=1; i<=n; i++){
			result = i*result; 
		}
		return result ;
	}
	
	/**
	 * recursive version of fib
	 * fib(n) =   1   (n==0) 
	 *        =   1   (n==1)
	 *        =   fib(n-1) + fib(n-2) ;    
	 *            
	 * @param n
	 * @return
	 */
	
	public static int fib(int n){
		
		if(n==0 || n==1)
			return 1 ; 
		else 
			return fib(n-1) + fib(n-2);
	}
	
	/**
	 * solve the problem in a bottom-up fashion. Dynamic programming. 
	 * 
	 * @param n
	 * @return	
	 */
	public static int fibIter(int n){
		int f0 = 1; 
		int f1 = 1; 
		int result = 1 ;
		int temp ; 
		
		while(n>1){
			result = f0 + f1 ; 
			temp = f0;
			f0 = f1 ; 
			f1 = temp + f1;
			
			n--;
		}
		
		return result ;
	}
	/**
	 * second time practice, from a white paper
	 */
	public static int fibIter2(int n){
		int f0=1; 
		int f1 = 1; 
		int temp =0;
		while(n>1){
			temp = f1; 
			f1=f0+f1;
			f0=temp;
			n--;
		}
		
		return f1;
	}
		
	public static int fibIter3(int n){
		int f0 =1 ; 
		int f1 =1 ;
		int temp;
		
		for(int i=1; i<n; i++){
			temp = f1; 
			f1 = f0+f1; 
			f0 = temp;
		}
		
		return f1;
		
	}
	
	
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public static int fibDP ( int n ){
		int[] arr = new int[n];
		return fibDPHelper(arr, n);
	}
	
	public static int fibDPHelper(int[] arr, int n){
		if(n==0 || n==1 )
			return 1;
 	
		if(arr[n-2]==0)
			arr[n-2] = fibDPHelper(arr,n-2);
		 
		if(arr[n-1]==0)
			arr[n-1] = fibDPHelper(arr,n-1);
		
		return arr[n-2]+arr[n-1]; 
	}
	
	/**
	 * permutation of str. Programing interview exposed P97.
	 */
	public static void permuteStr(String str){
		int len = str.length();
		boolean [] hasBeenUsed = new boolean[len];
		StringBuffer out = new StringBuffer();
		doPermuteStr(str, out, hasBeenUsed,0);
		
	}
	
	public static void doPermuteStr(String in, StringBuffer out, 
			boolean[] hasBeenUsed , int level ){
		//base case
		if(level==in.length())
			System.out.println(out.toString());
		
		//recursive case
		for(int i= 0 ; i<in.length() ; i++){
			
			if(hasBeenUsed[i]) continue;
			
			out.append(in.charAt(i));
			hasBeenUsed[i] = true;
			doPermuteStr(in,out,hasBeenUsed,level+1);
			hasBeenUsed[i] = false;
			out.setLength(out.length()-1);
		}
		
		
	}
	

	/** 
	 * CSE214 rec
	 * Write a recursive function that takes integer value 'num' as a parameter 
	 * and prints out the values num to 1 in descending order. 
	 * 
	 * @param num
	 */
	
	public static void desendingToOne(int num){
		
		if(num==0){
			return ;
		}
		
		System.out.println(num);
		desendingToOne(num-1);
	}
	
	/**
	 * CSE214
	 * Modify your answer from question 1 to print out the numbers from num to 
	 * 1 and then from 1 back to num. Your function must use a maximum of num 
	 * recursive calls. (TA: Please trace through teh values of the stack trace 
	 * for num=5.)
	 * 
	 * @param args
	 */
	
	public static void backToOne(int num){
		
		if(num==0){
			return ;
		}
		
		System.out.println(num);
		backToOne(num-1);
		System.out.println(num);
		
	}
	
	/**
	 * CSE214
	 * Write a recursive method that reverse the order of the characters in a 
	 * string. Show the stack of activation records for the function with initial 
	 * input "Hello".  
	 * output "olleH"
	 * @param args
	 */
	
	public static String revStr(String old){
		if(old.equals("")) //base case
			return "";
		
		return revStr(old.substring(1)) + old.charAt(0);
		
	}
	

	/**
	 * You are given 2 strings. Write a recursive function to check if one is 
	 * a substring of another. Hint: start from comparing the first two characters
	 * of both strings. Then, depending on the result, decide what recursive call 
	 * to make. 
	 * 
	 * str1="abc"   str2="ac" return false, 
	 * str2="abc"   str2="bc" return true;
 	 * @throws Exception 
	 */
	
	public static boolean isSubStrIter(String str1, String str2) throws Exception{
		if(str1.length()<str2.length())
			throw new Exception("The first string should be the long one.");
		
		int i=0, j = 0;
		
		while(i<str1.length()&& j<str2.length()){ //iterate through the long String
				
			if(j>0 && str1.charAt(i)!=str2.charAt(j)  )
				return false;
	
			if(str1.charAt(i)==str2.charAt(j)){
				i++;
				j++;
			}
			else 
				i++;
		}

		if(j==str2.length())
			return true;
		else 
			return false;
	}
	
	/**
	 * recursive implemenation 
	 * @return
	 */
	public static boolean isSubStr(String str1, String str2){
		
		if(str2.length()==0)
			return true;
		
		if(str1.length()==0)
			return false;
		
		if(str1.charAt(0)==str2.charAt(0)  
				&& isSubStr(str1.substring(1), str2.substring(1)) )
			return true;
		
		else{
			return isSubStr(str1.substring(1), str2);
		}
		
	}
	
	 /**
	 * recursive implementation
	 * @param str1
	 * @param str2
	 * @return
	 */
	
	public static boolean isSubStringRecursive(String str1, String str2, int i , int j){
		
		if(j == str2.length())  //str2 reached the end, found
			return true; 
		
		if(i == str1.length())  //str1 reached the end, not found.
			return false;
			
			
		if(str1.charAt(i)!=str2.charAt(j)){
			return isSubStringRecursive(str1, str2, i+1,j);
			
		}
		else{
			return isSubStringRecursive(str1,str2,i+1, j+1);
		}
		
		
	}
	
	
	/**
	 * Write a recursive function to add two numbers. The only operation allowed
	 * is adding or subtracting 1. For simplicity assume both numbers are 
	 * positive.
	 *
	 * Idea: a+b = a + b*1 (add b times 1 to a.)
	 *
	 * b) Now modify the function to work with negative numbers. 
	 */
	
	public static int addRecursive(int a, int b){
		
		if(b==1)
			return a+1; 
		
		if(b==-1)
			return a - 1;

		if(b<0) 
			return addRecursive(a, b+1) - 1;
		else 
			return addRecursive(a, b-1) + 1;
		
	}
	
	/**
	 * The following function performas an ITERATIVE binary search on a sorted
	 * array: 
	 * 
	 */ 
	public static int bSearchIter(int[] arr, int first, int last, int target){
		int mid ; 
		
		while(first<=last){
			mid = (first+last)/2;
			
			if(arr[mid]==target) 
				return mid; 
			else if(target<arr[mid]){
				last = mid-1;
			}
			else{
				first = mid+1; 
			}
		}
		return -1 ;	
	}
	 
	/**
	 * implementation of sequelcial search 
	 * 
	 * */
	public static int sSearch (int[] arr, int index, int target){
		
		while(index<arr.length){
			if(arr[index]==target)
				return index;
			
			else 
				index++ ;
		}
		
		return -1 ;
	}
	 
   /**
	* a) rewrite is as a RECURSIVE function. 
    * b) is it tail recursion. Yes.
    */
	public static int bSearch(int[] arr, int target, int first, int last){
		
		if(first>last)  //base case is important 
			return -1;
		
		int mid = (first+last)/2;
		if(target==arr[mid])
			return mid;
		
		else if(target < arr[mid])
			return bSearch(arr, target, first, mid-1);
		else
			return bSearch (arr, target, mid+1, last);
		
	} 
	 

	/**
	 * CSE214- Sample Midterm 2, question 1.
	 * reverses the elements of  an integer queue recursively. 
	 * 
	 */
	public static void reverseQueue(Queue<Integer> q ){
		
		//base case
		
		if(q.isEmpty())
			return ;
		
		//recursive case
		
		Integer temp = q.dequeue();
		reverseQueue(q);
		q.enqueue(temp);
		
	}
	
	/**
	 * 
	 * @param arr
	 * @param last
	 * @return
	 */
	
	public static int maxSum(int[] arr, int last){
		int [] count = new int[last+1]; 
		
		maxSumHelper(arr,count,last);
		
		int max = 0;
		
		for(int i = 0; i<count.length; i++){
			if(count[i]>max)
				max=count[i];
		}
		return max;
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static int maxSumHelper(int[] arr, int[] count, int last){
		if(last==0) {
			count[last] = arr[0];
			return count[last];
		}
	
		else {
			
			
			int prevMaxSum = maxSumHelper(arr, count, last-1);
			count[last]=
				(prevMaxSum+arr[last]>arr[last]? prevMaxSum+arr[last]:arr[last]);
		
			return count[last];
		}
		
	}
	
	/**
	 * Iterative implementation of the maxSum 
	 * @param arr
	 * @param last
	 * @return
	 */
	public static int maxSumIter(int[] arr, int last){
		int[] maxSums = new int[last+1];
		maxSums[0] = arr[0];
		for(int i=1; i<=last; i++){
			maxSums[i] = maxSums[i-1] > (maxSums[i-1]+arr[i])? 
					maxSums[i-1]:(maxSums[i-1]+arr[i]) ;
		}
		
		int maxSum = maxSums[0];
		
		for(int i =0; i<=last; i++){
			if(maxSums[i]>maxSum)
				maxSum = maxSums[i];
		}
		
		return maxSum;
	}
	
	/**
	 * print out all the powerSet of s
	 * eg: s=abc, then powerSet={ "", "a", "b", "c", "ab", "ac", "bc", "abc"}
	 * @param s
	 */

	
	public static LinkedList<String> powerSet( String s){
		//check for illegalArgument
		LinkedList<String> list = new LinkedList<String>();
		
		if(s.length()==1){
			//list.appendToTail(s);
			//list.appendToTail("");
			list.addToHead("");
			list.addToHead(s);
			return list;
		}
		
		char c = s.charAt(0);
		LinkedList<String> list2 = powerSet(s.substring(1));
		
		for(String str:list2){
			list2.addToHead( c+str);
			
		}
		return list2;
	}
	
	
	/**
	 * Driver program.
	 * @param args
	 */
	public static void main(String args[]){
		
		//int[] arr = {2, 3, 4, 5, 8, 9};
		int [] arr = {-3,5,2,-10,1};
		

		//System.out.println(fibIter(10));
		//System.out.println(fibIter3(5));
		
		//System.out.println(fibDP(10));
		//ArrayList<String> list = powerSet("abc");
		
		//System.out.println(powerSet("abc").toString());
		
		
		//permuteStr("abcd");
		//System.out.println(maxSum(arr,4));
		//System.out.println(maxSumIter(arr,4));
		//System.out.println(NRbsearch(2, intArr, 0,5));
		//System.out.println(NRbsearchRecursive(1,intArr, 0 , 5));
		//System.out.println(addRecursive(5,-3));s
		
		//System.out.println(fibNonRecursive(7));
		//System.out.println(fib(6));
		//System.out.println(fibIter(6));
		
		//System.out.println(revStr("Ying"));
		
		
		/*Queue<Integer> intQ = new Queue<Integer>();
		intQ.enqueue(2);
		intQ.enqueue(5);
		intQ.enqueue(8);
		intQ.enqueue(10);
		intQ.enqueue(1);
		*/
		//reverseQueue(intQ);
		
		//while(!intQ.isEmpty()){
			//System.out.println(intQ.dequeue());
		//}
		
		
		try {
		//	System.out.println(isSubStr("abcde","de"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println(isSubStr("abc", "ac"));
		//System.out.println(bSearch(arr,8,0,5));
		
		permuteStr("abcde");
		
	}
	
}
