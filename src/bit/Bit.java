package bit;

public class Bit {

	
	/**
	 * given a decimal representation
	 * @return number of 1s, in the number's binary representation.
	 */
	public static int numSetbit(int n){
		int count=0;
		
		while(n!=0){
			if((n&1)==1) count++;
			n = n>>1;
		}	
		return count;
	}
	
	
	
	
	
	public static void main(String args[]){
		
		//System.out.println(Integer.toBinaryString(10>>1&1));
		System.out.println(numSetbit(12));
		
	}
}
