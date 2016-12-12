import java.util.*;
import java.io.*;
/**
 * Daniel Hug
 * CSI 213
 * Binary Tree
 *
 */
public class BinaryTree {
 static Node root;
    static int preIndex = 0;
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
  Node(String val, Node leftChild, Node rightChild){
   value = val;
   left = leftChild;
   right = rightChild;
  }
  
   public String getValue(){
    return value;
   }
 }
 
  
  
     //tree builder
     Node buildTree(String strArr[], int inStrt, int inEnd) {
  
         if (inStrt > inEnd) {
             return null;
         }
  
         /* Pick current node from preorder traversal using preIndex
          and increment preIndex */
         Node tNode = new Node(strArr[preIndex++]);
  
         /* If this node has no children then return */
         if (inStrt == inEnd) {
             return tNode;
         }
  
         /* Else find the index of this 
          * node in Inorder traversal
          */
         int inIndex = search(strArr, inStrt, inEnd, tNode.value);
  
         /* Using index in Inorder traversal, 
          * construct left and right subtress 
          * 
          */
         tNode.left = buildTree(strArr, inStrt, inIndex - 1);
         tNode.right = buildTree(strArr, inIndex + 1, inEnd);
  
         return tNode;
     }

     int search(String[] strArr, int strt, int end, String value) {
         int i;
         for (i = strt; i <= end; i++) {
             if (strArr[i] == value) {
                 return i;
             }
  
         }
         return i;
     }
  
     //print function
     void printInorder(Node node) {
         if (node == null) {
             return;
         }
  
         /* first recur on left child */
         printInorder(node.left);
  
         /* then print the data of node */
         System.out.print(node.value + " ");
  
         /* now recur on right child */
         printInorder(node.right);
     }
  
     // driver program to test above functions
     public static void main(String args[]) throws IOException{
         BinaryTree tree = new BinaryTree();
         Scanner inFile = new Scanner(new File("testSentence.txt"));
         int i = 0;
         String strArr[] = new String[15];
         
         while(inFile.hasNext()){
           strArr[i] = inFile.next();
           i++;
         }
           
         
         /* Testing ArrayList
          * for(int i = 0; i < strArr.size(); i++){
           System.out.println("Word " + i + " = " + strArr.get(i));
           
         }*/
         
         
         int len = strArr.length;
         Node mynode = tree.buildTree(strArr, 0, len - 1);
  
         // building the tree by printing inorder traversal
         System.out.println("Inorder traversal of constructed tree is : ");
         tree.printInorder(mynode);
         System.out.println();
         
         Map<String, Integer> map = new HashMap<String, Integer> ();
         tree.getStringFreq(mynode, map);
         System.out.println(map);
         
     }
     
     public void getStringFreq (Node node, Map<String, Integer> map) {
       if (node == null) {
         return;
       }

       /* left child */
       getStringFreq(node.left, map);

       /* get the data of node */
       String s = node.value;

       Integer i = map.get(s); // have we mapped it yet

       // not yet
       if (i == null)
         map.put(s, 1);
       // already mapped, increment freq
       else
         map.put(s, i + 1);

       /* right child */
       getStringFreq(node.right, map);
    }    
 }


