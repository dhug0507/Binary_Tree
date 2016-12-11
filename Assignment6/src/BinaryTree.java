/**
 * Daniel Hug
 * CSI 213
 * Binary Tree
 *
 */
public class BinaryTree {

	 class Node{
		String value;
		Node left, right;
		/**
		 * Constructor for Node class
		 * @param val value of the Node
		 */
		Node(String val){
			value = val;
			left = null;
			right = null;
					
		}
		/**
		 * Second Constructor
		 * @param val value of the Node
		 * @param left1 The Node to the left of val
		 * @param right1 The Node to the right of val
		 */
		Node(String val, Node left1, Node right1){
			value = val;
			left = left1;
			right = right1;
		}
	}
	 
	 public void inOrder(Node bTree){
		//If empty do nothing
		 if(bTree != null){
			 //Traverse the left subtree
			 inOrder(bTree.left);
			 //Visit the Node
			 System.out.println(bTree.value + " ");
			 //Traverse the right subtree
			 inOrder(bTree.right);
		 }
	 }
	
	public static void search(){
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
