package array;

import stack_evaluation.ListStack;
import stack_evaluation.Stack;
import table.Table;

public class ArrayPractice {
	
	/**
	 * UBS interview question 
	 * Given two sorted int array,(could be null), create a new array that contains 
	 * all elements of the two, and is sorted. 
	 * 
	 * Requirements: 
	 * 		Check cases
	 * 		Efficiency run-time 
	 * 		Make if generic for all types 
	 * 
	 * Date: Oct-5-2010
	 * OCR Stony Brook 
	 * @author Ying
	 * @throws Exception 
	 *
	 */
	
	public static int[] mergeArray(int[] a, int[]b) throws Exception  {
		
		if(a.length==0 && b.length==0){
			throw new Exception("Illegal Argument of the input array.");
		}
		
		int newLength = a.length + b.length;
		int [] newArray = new int[newLength];
		int i = 0, j = 0, k = 0 ;
		
		while(k<newLength){

			if(i==a.length){ //finished array a, just move all b to 
				for(; j<b.length;j++){
					newArray[k]=b[j];
					k++;
				}
			}
			
			else if(j==b.length){ //finished b, just move all to b
				for(; i<a.length;i++){
					newArray[k++]=a[i];
				}
			}
			
			else if(a[i]<b[j]){
				newArray[k]=a[i];
				k++; 
				i++;
			}
			
			else if(a[i]>=b[j]){
				newArray[k]=b[j];
				k++;
				j++;
			}
			
		}
		
		return newArray;
		
	}
	
	/**
	 * practice merge two sorted arrays. 
	 *
	 */
	public static int[] mergeArr(int[] a, int[]b){
		if(a==null||b==null||a.length==0||b.length==0)
			throw new IllegalArgumentException();
		
		int[] arr = new int[a.length+b.length];
		int i=0, j=0, k=0;
	
		while(i<a.length || j<b.length){
			if(i==a.length){
				while(j<b.length)
					arr[k++] = b[j++];
				break;
			}
			if(j==b.length){
				while(i<a.length)
					arr[k++] = a[i++];
				break;
			}
			if(a[i]<=b[j]){
				arr[k++] = a[i++];
			}
			else{
				arr[k++] = b[j++];
			}
			
		}
		
		return arr;
	}
	
	
	
	
	/**
	 * A code question RiverBed asked during the Oct-8-2010 Job Fair at Stony Brook. 
	 * 
	 * Given a String "qaqiaoo". A duplicate is defined in that, whenever a character is 
	 * repeated second time, then it is a duplicates. e.g. the second char 'q'in the 
	 * string is a duplicate. give a code to output the duplicates of the string. e.g.
	 * "qao", the result could be any permutation. 
	 * 
	 * @author Ying
	 *
	 */
	
	public static char[] getDulicate(char [] old){
		int counter[] = new int [26]; 
		char newStr[] = new char[old.length];
		
		//String s = "abc"; 
	
		
		for(int i=0;i<old.length;i++ ){
			int c = old[i];
			int k = c - 'a';
			counter[k]++;
		}
		
		int newStrIndex = 0;
		
		int newlen = 0 ;
		
		for(int i =0; i<26; i++){
			if(counter[i]==2){
				int c = 'a' + i;
				newStr[newStrIndex++] = (char) c  ;
				newlen++;
			}
		}
		
		char [] newStr2 = new char[newlen];
		for(int i = 0; i<newlen; i++){
			newStr2[i] = newStr[i];
		}
		
		return newStr2;
	}
	
	/**
	 * Programming interview exposed Chapter 6, Arrays practice 
	 * 
	 * Given a array of String, fin first the first non-repeated 
	 * char and return it. e.g. given "ababec", return e. 
	 * use O(n) efficiency. 
	 * 
	 * Idea: use an array counter or hashtable to count the occurrence. 
	 *
	 * First, build the character count hash table:
	 * 		for each character
	 * 			if no value is stored for the character, store 1
	 * 			else, increment the value 
	 * Second, scan the string,
	 * 		for each character
	 * 			Return character if count in the hash table is 1
	 * 		If no character have the count 1, return null
	 */
	
	public static Character firstNonRepeated(String str){
		//Hashtable<Character, Integer> charHash = new Hashtable<Character, Integer>();
		Table charHash = new Table(5);//my own hashTable
	
		Character c ; 
		Integer intgr ; 
		
		int i , length ; 
		length = str.length();
		
		for(i=0; i<length;i++){ //build the count hashtable 
			c = str.charAt(i);
			intgr = (Integer)charHash.get(c);
			if(intgr==null) //first time
				charHash.put(c, new Integer(1));
			else{
				charHash.put(c, new Integer(intgr.intValue()+1));
			}
		}
		
		i = 0; 
		while(i<str.length()){
			int count = (Integer)charHash.get(str.charAt(i));
			if(count==1){
				return str.charAt(i);
			}
			i++;
		}
		
		
		return null;
		
	}
	
	/**
	 * Facebook phone interview 
	 * Oct-21-2010 
	 * input: "Today is thursday."
	 * output: "thursday. is Today"
	 * @author Ying
	 *
	 */
    public static String reverseStringStack(String old){
 
   	 Stack<String> stack = new Stack<String>();
   	 Tokenizer tokenizer = new Tokenizer(old); 
     String token = null; 
     String newString = null ; 
           
        while(tokenizer.hasNext()){

           token = tokenizer.next() ;

           try {
				stack.push(token);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

        }  
        while(!stack.isEmpty()){ 

       	 try {
				newString += stack.pop();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
        }   

        return newString ;  

   }
   
   public static String reverseSentence(String str){
	   if(str==null || str.length()==0)
		   throw new IllegalArgumentException();
	   
	   char[] arr = str.toCharArray();
	   
	   int i=0, j=0; 
	   
	   while(j<arr.length){
		   //encounter an space and not the last char
		   if(j==arr.length-1){
			   reverseStr(arr,i,j);
			   break;
		   }
		   if(arr[j]!=' '){
			   j++;
		   }
		   else{
			   reverseStr(arr,i,j-1);
			   j++;
			   i=j;
		   }
		   
	   }
	   return new String(arr);
   }
    
   public static char[] reverseStr(char[] arr, int first, int last){
	   char c = 0 ; 
	   while(first<last){
		   c = arr[last];
		   arr[last] = arr[first];
		   arr[first] = c;
		   first++;
		   last--;
	   }
	   return arr;
	   
   }
   
    
       
   /**
   * pure array implementation. first step, reverse the array. second step, 
   * reverse each word back. 
   * 
   * @param old
   * @return
   */	
   public static String reverseStr(String old){
	   char[] arr = old.toCharArray();
	   
	   reverseStrHelper(arr,0, arr.length-1);
	   int head, tail; 
	   
	   for(head=0,tail=0; head<arr.length ; ){
		   
		   if(arr[head]!=' '){ //none-space char
			   head++;
		   }
		   
		   else{ // space, do reverse
			   reverseStrHelper(arr,tail, head-1);
			   head++;
			   tail = head;
		   }
		   
		   if(head==arr.length-1){ //the last char 
			 reverseStrHelper(arr,tail, head);  
		   }
		   
	   }
	   return new String(arr, 0, arr.length);
	   
   }

   
   public static void reverseStrHelper(char[] arr, int first, int last){
	   
	   char temp;
	   
	   while(first<last){
		   temp = arr[first];
		   arr[first] = arr[last];
		   arr[last] = temp;
		   first++; 
		   last--;
	   }
	   
   }
 
   
	/**
	 * CSE214, sample midterm practice, Evaluates the given postfix 
	 * string using a stack.
       Preconditions: 
		- The operands in the postfix string are single-digit integers.
		- The postfix string contains only operands and operators +,-,*, and /.
	      (No spaces.)
	   
	   Postconditions: 
		- Returns the integer value of the given postfix string if the string 
		is a valid postfix string.
      
       Notes:
        - Integer division is used.
        - You may assume the input string is a valid postfix expression.
	 * 
	 * @param postfix
	 * @return
	 * @throws Exception
	 */
	
	public static int evaluate(String postfix) throws Exception {

		ListStack<Integer> stack = new ListStack<Integer>();
		char ch ;
		int operand1, operand2; 
		
		for(int i=0; i<postfix.length();i++){
			
			ch = postfix.charAt(i);
			
			if(Character.isDigit(ch)){ //an operand, push to stack
				stack.push( (int) ch-'0');
			}
			
			else{ //an operator, evaluate and push
				operand2 = stack.pop(); 
				operand1 = stack.pop();
				
				if(ch=='+'){
					stack.push(operand1 + operand2);
				}
				
				else if(ch=='-'){
					stack.push(operand1 - operand2);

				}
				
				else if(ch=='*'){
					stack.push(operand1 * operand2);
					
				}
				
				else{  // '/'
					if(operand2==0){
						throw new Exception("divide by 0.");
					}
					stack.push(operand1 / operand2);
				}
			}	
		}//end for 
 
		return stack.pop();
 
	}
	
	/**
	 * Question from programing exposed, p.78
	 * Desc: Given String "Today is Friday." remove ="aeiou"; return 
	 * "Tdy s Frdy."
	 * 
	 * Algorithms: 
	 * 1. create a array of boolean of 128 ASII chars. 
	 * 2. interate through the remove array and build the boolean array. 
	 * 3. loop through the str. use int readPosition, and writePosition, in the original string, 
	 * remove the chars. 
	 * 
	 * @param str
	 * @param remove
	 * @return
	 */
	
	public static String removeChars(String str, String remove){
		char[] strArr = str.toCharArray();
		boolean[] flags = new boolean[128];//assume ascii
		int p;
		//build the boolean flags array
		for(int i=0; i<remove.length();i++){
			p = remove.charAt(i);
			flags[p] = true;
		}
		char temp;
		int i, writePosition=0;
		for( i=0; i<strArr.length; i++){
			p = strArr[i] ; 
			if(flags[p]){ //found in the flags 
				//readPosition++; 
			}
			else{//not found, do swap
				strArr[writePosition] = strArr[i];
				writePosition++;
				//readPosition++;
			}	
			
		}
		
		return new String(strArr, 0, writePosition);
	}
	
	/**
	 * question from programming exposed. p.83
	 * input: "-356" 
	 * output: -365
	 * 
	 * @param str
	 * @return the integer of the str
	 */
	
	public static int atoi(String str)
	{
		if(str==null || str.length()==0)
			throw new IllegalArgumentException();
		int length = str.length();
		int result = 0;
		
		for(int i=0; i<length; i++){
			char c = str.charAt(i);
			result += (int)(c-'0') * Math.pow(10, length-i-1);  
			
		}
	
		return result ;
		
	}
	
	/**
	 * Sumeet MicroSoft interview. 
	 * Given two strings, return true if the second one is sub sequence of 
	 * the first one. e.g.: abcde, ce, should return true. 
	 * @param args
	 */
	
	public static boolean isSubSeq(String str1, String str2){
		if(str1==null || str2==null || str1.length()==0 || str2.length()==0)
			throw new IllegalArgumentException();
		
		//suppose str2.length() is less than or equal than str1
		int i=0, j = 0; 
		
		while(i<str1.length()){
			
			if(str1.charAt(i)==str2.charAt(j)){
				i++;
				j++;
			}
				
			else{
				i++;
			}
			
			if(j==str2.length())
				return true;
			
		}
		
		return false;
	}

	
	public static void main(String args[]){
		
		int [] a = {2,5,7,9,10};
		int [] b = {1,4,7};
		
		//SortTest.printArr( mergeArr(a,b) , " ");
		
/*		char ch = '5';
		int value = ch - '0';

		try {
			System.out.println(evaluate("35+65-/"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
/*		int a[] = {1,3,4,6};64-
		int b[] = {1,2,4,7,9};
		int c[] = new int [a.length+b.length] ; 
		try {
			c = s.mergeArray(a, b);
			
			int i = 0;
			while(i<c.length){
				//System.out.println("s");
				System.out.print(c[i]);
				i++;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/
		
		//String s = "abc"; 
		 
		//char [] old = {'q','a','q','a','o','o','i','i'};
		
		//System.out.println(isSubSeq("abcde","ce"));
		
		//System.out.println(removeChars("Today is Thursday.", "aeiou"));
		
		//reverseStrHelper(old,0,7);
		//System.out.println(reverseStr("Today is Monday."));
		
		String s = "Today is Monday." ; 
		//System.out.println(reverseStr(s.toCharArray(),0,s.length()-1));
		//System.out.println(reverseStr(s));
		System.out.println(atoi("3710"));
	}
	

/**
 * Input:
String A, B

|A| == |B|

At each step, change one letter in A to any other letter, until we get B.
Each intermediate word must be a dictionary word (from D = {d1, d2, d3, ..})
Are not given D as input.

bool is_in_dictionary(String x) - returns true if x is in D


Output:

shortest list of intermediate words, starting at A and ending at B



Examples:

A=dog, B=let
D={dog, let, log, leg}
dog => log => leg => let


A=small
B=smile
D={small, smile, stile, stall, still}
small -> stall -> still -> stile -> smile



ArrayList<String> changeWord(String strA, String strB){
    Quene<String> queue = new Queue<String>();
    
    queue.enqueue(strA);
    
    while(!queue.isEmpty){
        String str = queue.dequeue();
        String valid = helper(str);    
    
        if(valid==null){
            reuturn null ;     
        }    
        
        if(valid.equals(strB))
            return queue ; 
        
        else{
            queue.enqueue(valid);
        }    
        
        
    }
    
}

//change one letter and result a valid word in dictionay.
String wordHelper(String word){
    char [] arr = word.toCharArray();
    
    for(int i=0; i<arr.lenght; i++){
        
        char c= 'a'; 
        while(c<= (int)'z'){
            arr[i] = c ;
            if(is_in_dictionary(new String(arr) ) )
                return new String(arr); 
            
            c++; 
        }
        
        
            
        
    }
    
    return null ;
    
}

 * 
 */

	
	
}
