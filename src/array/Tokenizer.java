package array;

public class Tokenizer {

    //private String buffer  = null ; 
    private String originalString ; 
    private int readPosition  ; 
    private int stringLen ; 

    public Tokenizer(String s){
        originalString = s; 
        readPosition = 0 ; 
        stringLen = s.length();         
    } 
    /**  
      return true if the string has next word 
    */ 
    public boolean hasNext(){
        if(originalString.substring(readPosition).equals(""))
           return false; 
   
        else 
            return true;     
   }
   
   /**    
    return the next token of the original String
   
   */
   public String next(){
      String buffer = "" ; //efficiency hint! 
      for (int i=readPosition; i<stringLen; i++){ 
         buffer += originalString.charAt(i); 
         if(originalString.charAt(i)==' '){  
        	  readPosition ++ ; // increment hint (the interviewer said
        	                    // should increment by 2, but is not correct! 
        	                    // notice: need to think and challenge the 
        	                    // interviewer if you think he is wrong!  )
              return buffer ;        
         }  
         //else 
         readPosition ++ ;// increment hint!
      }//end for 
      return buffer; //must return buffer
    }   
       
 }//end class Tokenizer  