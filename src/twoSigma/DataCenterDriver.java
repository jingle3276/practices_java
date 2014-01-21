package twoSigma;

import java.util.Vector;


/**
 * @author Ying
 *
 */

/**
 * Problem Statement #2:
(Version: TwoSigmaCodeTestCopyFile $Revision: 1.10 $)

Oh no! Disaster has struck some of ACME's redundant data centers. The
administrators have managed to restore backups, but some data sets are
still missing from some data centers. Fortunately, every data set can be
found at least once in one or more of the data centers. However, before
ACME can resume normal operations, it needs to ensure that each data
center has a copy of every data set.

Your goal is to help ACME resume normal operations by writing a program
to synchronize data sets between data centers using as few copies as
possible.

Input:

The first line of input will contain an integer between 0 and 999999
inclusive, representing the number of data centers.
Following that will be one line of input for each data center with a
space-separated list of data set ids currently present at that data
center. Data set ids are each an integer between 1 and 999999, inclusive.
Each line will be at most 1000 characters long.
 
A data center with no data sets is represented with a blank line. Data
set ids are not necessarily consecutive. The list of data sets will not
be in any particular order.

Output:
The program must output an optimal data set copy strategy to ensure that
every data center has a copy of every data set. Output one line for every
copy instruction.

A copy instruction is of the form <data-set-id> <from> <to>, where
<data-set-id> is the data set id, <from> is the index of the data center
the data set will be copied from (1 = the first data center), and <to>
is the index of the data center to copy the data set to.
 
When there are no more copy instructions, the program must output the
word "done" on a line by itself.
There is often more than one correct output with minimal number of
operations for a given input, and any output that satisfies the
requirements is valid.

Constraints:

The code you submit must take input from stdin and produce output to
stdout as specified above. No other output is permitted. You can
assume the input will be valid. In the examples below, the text
"Input:" and "Output:" (or "One Possible Correct Output:") are not
part of the output, and neither are the blank lines.

Example 1:
Input:
4
1 3 4
1 2 3
1 3
1 4 2

One Possible Correct Output:
2 2 1
4 1 2
2 2 3
4 4 3
3 1 4
done

Example 2:
Input:
2
1 2
2 1
 
Output:
done

Example 3:
Input:
3
1 3 4 5 7
1 3
2

One Possible Correct Output:
2 3 2
2 3 1
1 1 3
4 1 2
5 1 3
5 3 2
4 2 3
3 1 3
7 1 2
7 1 3
done
 * 
 * 
 */


public class DataCenterDriver {

	private int numOfCenters ;
	private Vector<Integer>[] centers ; 
	private Vector<Integer> dataSets ; 
	
	public DataCenterDriver(int num, String[] lines){
		
		numOfCenters = num ; 
		centers = new Vector[num];
		dataSets = new Vector<Integer>();
		
		for(int i=0; i<num; i++){
			String[] data = lines[i].split(" ");
			centers[i] = new Vector<Integer>();
			
			for(String s : data){
				centers[i].add(Integer.parseInt(s));
				if(!dataSets.contains(Integer.parseInt(s)))
					dataSets.add(Integer.parseInt(s));
			}
		}
		
		
	}

	public void doArrange(){

		for(int centerId=0; centerId<numOfCenters; centerId++ ){
			
			for(Integer d : dataSets){
			if(!centers[centerId].contains(d))
				System.out.println(d +" " + (getData(d)+1) +" " + (centerId+1));
			}
		
		
		}
		
		
		System.out.println("done");
	}
	
	/**
	 * @param centerId
	 * @param dataSetId
	 * @return true if the dataCenter has the dataSet
	 */
	public boolean containsData(int centerId, int dataSetId){
		
		return centers[centerId].contains(dataSetId);
	}
	
	/**
	 *
	 * @param dataSetid
	 * @return dataCenterId which contains the dataSet
	 */
	public int getData(int dataSetId){
		
		for(int i=0; i<numOfCenters; i++){
			if(centers[i].contains(dataSetId))
				return i;
			
		}
		
		return -1;
	}
	

	
	public static void main(String args[]){
		
		InputReader ir = InputReader.getInputReader();
		System.out.println("enter the input:");
		int number = Integer.parseInt(ir.getInput());
		String[] strs = new String[number];
		
		int i=0;
		while(i<number){
			strs[i]= ir.getInput();
			i++;
		}
		
		DataCenterDriver dc = new DataCenterDriver(number, strs);
		dc.doArrange();
		
		
		
		
	}
	
	
	
}
