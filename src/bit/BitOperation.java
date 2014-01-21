package bit;

public class BitOperation {

	public static int numOfSetBit(int n){
		
		int i = 0; 
		
		while(n>0){
			
			if((n&1)==1)
				i++;
			n = n>>1; 
			
		}

		return i ; 
	}
	
	
	public static void main(String[] args){
		
		//System.out.println(0x7FFFFFFF);   //the greatest number int can represent
		//System.out.println((int)Math.pow(2, 31));
		System.out.println(numOfSetBit(7));
		
		
	}
	
	
	
}
