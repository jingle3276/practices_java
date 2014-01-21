package array;

public class StringPractice {
	/**
	 * Given a set of Sentences containing lower case letters only, 
	 * remove common phrases from each sentence. Here a phrase is defined 
	 * by 3 or more consecutive words.
	 * E.g:
	 * S1 = "I my bye good";
	 * S2 = "my bye good boy";
	 * common phrase is: "my bye good"
	 * so the two sentence become
	 * S1 = "I";
	 * s2 ="boy";
	 * 
	 */
	
	/**
	 * The expected answer from the interview is to find all common phrases. Now, since these phrases must be found in the first sentence, simply mapping word index of beginning of phrase in first sentence would do. The trick that I didn't realize is, though it says 3 or more, we actually need to consider 3 length ones only as a 4 length one will implicitly contain two 3 word phrases and the phrases can overlap.
As for the part about finding common phrases, he expected hashing and I proposed that we can map each word as integer and apply the procedure on the integer equivalent. Though this mapping is similar to Hashing, but he wasn't accepting this answer and it got me confused on thinking, how could this be optimized further.
	 */
	
	
}
