package tree;

import binarytree.BTNode;
import dmv_queue.Queue;

public class TreeProblems {

	/**
	 * Google phone interview (second one). 
	 * Nov-2-2010
	 * 
	 * given an integer array of the the prorder traversal of BST, 
	 * reconstruct the BST. Using recursive method. 
	 * 
	 * trick: the reconBST returns the new constructed node to the caller.
	 * 		  construct the tree in an bottom-up fasion.
	 * 
	 * 		8
	 *     / \ 
	 *    3  10 
	 *   / \    \ 
	 *  1   6    14
 	 *     / \   /
 	 *    4   7 13   
	 * 	            preOrder: 8 3 1 6 4 7 10 14 13  
	 * 
	 * @return
	 */
	
	public static BTNode reconBST(int[] arr, int first, int last){
		int boundary;
		
		//base case, construct a leaf
				
		if(first==last) //I figured this out at interview
			return new BTNode(arr[first], null, null); //construct a leaf
		
		BTNode node = new BTNode(arr[first]);
		boundary = boundary(arr, first, last); //mentioned this 
		
		if(first+1<=boundary-1)
			node.setLeft(reconBST(arr,first+1, boundary-1)); //with the help of him
		
		if(boundary<=last)
			node.setRight(reconBST(arr, boundary, last));
		
		return node ; //with the help of him
		
	}
	/**
	 * I mentioned this implementation to the interview and he approved.
	 */
	private static int boundary(int[] arr, int first, int last){
		
		int rootVal = arr[first]; 
		
		for(int i=first; i<=last; i++){
			if(arr[i] > rootVal)
				return i;
			
		}
		//must be last+1. not -1.
		return last+1;
	}
	
	
	public static BTNode reconPre(int[] arr, int first, int last ){
		if(first==last)
			return new BTNode(arr[first]);
		
		BTNode leftSubTree=null, rightSubTree=null; 
		int boundary = getBundary(arr, first, last);
		if(first+1<=boundary-1)
			leftSubTree = reconPre(arr, first+1, boundary-1);
		if(boundary<=last)
			rightSubTree = reconPre(arr, boundary, last);
		
		return new BTNode(arr[first], leftSubTree, rightSubTree);
	}
	
	
	
	private static int getBundary (int [] arr, int first, int last){
		
		int rootVal = arr[first]; 
		for(int i=first; i<=last ; i++){
			if(arr[i]>rootVal)
				return i;
			
		}
		
		return last+1;
		
	}
	
	
	/**
	 * Take a tree (binary or otherwise), write a method in any language that, 
	 * when given the root node, will print out the tree in level order. 
	 * With a new line after the end of every level.
	 * Helper methods are ok, big O run time efficiency doesn't matter 
	 * (though obviously a quicker solution is better). Do not destroy original 
	 * tree.
	 * 
	 * Idea: BST traversal. use a queue.
	 * 
	 */
	
	public static void BFS(BTNode root){
		Queue<BTNode> queue = new Queue<BTNode>();
		queue.enqueue(root);
		BTNode marker = new BTNode(-1);
		queue.enqueue(marker);
		
		while(!queue.isEmpty()){
			//queue.enqueue(marker);
			BTNode current = queue.dequeue();
			
			//current is marker 
			if(current.getData()==-1){
				System.out.println();
				continue;
			}
			//current is a node
			System.out.print(current.getData()+" ");
			if(current.getLeft()!=null)
				queue.enqueue(current.getLeft());
			if(current.getRight()!=null)
				queue.enqueue(current.getRight());
			
			queue.enqueue(marker);
		}
		
	}
	
	
	/**
	 * Version 1, corret but not efficient.because using of getRightMost() 
	 * and getleftMost, every time run this, will look at its desendents one 
	 * time 
	 * 
	 * @param root
	 * @return
	 */
	
	public static boolean isBST(BTNode root){
		
		/* false if the max of the left is > than root */
		if(root.getLeft()!=null && root.getLeft().getRightMost().getData() > root.getData())
			return false;
		/* false if the min of the right is <= than us */	
		if(root.getRight()!=null && root.getRight().getLeftMost().getData() < root.getData())
			return false;
		
		/* false if, recursively, the left or right is not a BST */
		if( root.getLeft()!=null && !isBST(root.getLeft()))
			return false;
		if( root.getRight()!=null && !isBST(root.getRight()))
			return false;
 
		/* passing all that, it's a BST */
		else 
			return true;

	}
	
	/**
	 * an better implementation fo the isBST()
	 * 
	 * @param root
	 * @return
	 */
	public static boolean isBST2(BTNode root){
		return isBSTHelper(root,0,200);
	}
	
	/**
	 * helper method for isBST2()
	 * trick: keep min, and max, as paremeters. norrowing down min or max,
	 * as going down one level for revursion.
	 * 
	 * @param root
	 * @param min
	 * @param max
	 * @return
	 */
	
	private static boolean isBSTHelper(BTNode root, int min, int max){
		
		if(root.getData() < min || root.getData() > max)
			return false ;
		
		if(root.getLeft()!=null && !isBSTHelper(root.getLeft(), min, root.getData()) )
			  return false ; 
		if(root.getRight()!=null && !isBSTHelper(root.getRight(), root.getData(), max))
			return false;
 
		return true;
		
	}
	
	public static boolean isBST(BTNode root, int MAX, int MIN){
		//base cases
		if(root==null) return true;
		
		else if(root.getData()>MAX || root.getData()<MIN){
			return false;
		}
		
		//recursive case
		else{
			
			return isBST(root.getLeft(),root.getData(),MIN) 
				  && isBST(root.getRight(), MAX, root.getData());
		}
		
	}
	

	public static int getDepth(BTNode cursor){
		int left=0, right=0 ;
		
		if(cursor.isLeaf())
			return 0;
		
		if(cursor.getLeft()!=null)
			left = getDepth(cursor.getLeft()); 
		
		if(cursor.getRight()!=null)
			right = getDepth(cursor.getRight());
		
		if(left>=right)
			return left+1; 
		else
			return right+1;
	}
	
	/**
	 * 
	 * @param root
	 */
	public static int getDepth2(BTNode root){
		if(root==null) return -1;
		
		if(root.getLeft()==null && root.getRight()==null)
			return 0;
		
		return Math.max(getDepth2(root.getLeft()), getDepth2(root.getRight()))+1;
		
	}
	
	
	/**
	 * 
	 * @param n1
	 * @param n2
	 * @return
	 */
	
	public static boolean isMirror(BTNode n1, BTNode n2){
		
		//base case, if one left is null, the other is not null, not mirror
		if(n1!=null && n2==null || n1==null && n2!=null)
			return false;
		//base case, if both are nulls, mirror.
		else if(n1==null && n2==null)
			return true;
		
		else{
			return  n1.getData()==n2.getData() 
				&& isMirror(n1.getLeft(),n2.getRight()) 
				&& isMirror(n1.getRight(),n2.getLeft());
		}
	}

	/**
	 * 					83
	 * 				   /  \ 	
	 *                65  98
	 *                    / \ 
 	 *                   90  99    
	 * @param args
	 */

	public static void main(String[] args){
  		BTNode root = new BTNode(53);
		root.setLeft(new BTNode(27));
		root.setRight(new BTNode(83));
		root.getLeft().setLeft( new BTNode(16));
		root.getLeft().setRight( new BTNode(34));
		root.getRight().setRight( new BTNode(91));
		
		root.getLeft().getRight().setRight( new BTNode(40));
		root.getRight().getRight().setLeft(new BTNode(89));
		
		BFS(root);
		
/*		BFS(root);

		BTNode root2 = new BTNode(10);
		root2.setRight(new BTNode(8));
		root2.setLeft(new BTNode(20));
		root2.getRight().setRight( new BTNode(6));
		root2.getRight().setLeft( new BTNode(9));
		root2.getLeft().setRight( new BTNode(14));  */
		 
		//System.out.println(isMirror(root,root2));	
		
/*		int [] arr = {8,3,1,6,4,7,10,14,13};
		//int [] arr = {83,41,56,103,91,100};
		BTNode rootR = reconPre(arr, 0, 8);
		
		try {
			rootR.preorderIter();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(rootR.getData());
		*/
		
		//System.out.println(isBST(new BTNode(10),20,0));
		
		//System.out.println(getDepth2(null));
		
	}
	
}
