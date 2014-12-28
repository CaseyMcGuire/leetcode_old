package Testing.Java;

import java.util.*;

public class TreeNode{

    public int val;
    public TreeNode right;
    public TreeNode left;

    public TreeNode(int val){
	this.val = val;
	right = null;
	left = null;
    }

  public String toString(){
      return val + "";
  }

    /*
     Creates a tree from the Integer array and returns the root of the tree.
     */
    public static TreeNode createTreeFromArray(Integer[] array){
	if(array == null || array.length == 0){
	    return null;
	}

	TreeNode root = new TreeNode(array[0]);
	Deque<TreeNode> oldStack = new ArrayDeque<>();
	Deque<TreeNode> newStack = new ArrayDeque<>();
	oldStack.push(root);

	int i = 1;
	while(true){
	    TreeNode curNode = oldStack.pop();
	    if(curNode == null) continue;
	    
	    TreeNode left;
	    TreeNode right;
	    
	    //get our left node
	    if(array[i] != null){
		left = new TreeNode(array[i]);
	    }else{
		left = null;
	    }

	    //break if this is our last node
	    i++;
	    if(i >= array.length) break;
	   	    
	    //get our right node
	    if(array[i + 1] != null){
		right = new TreeNode(array[i + 1]);
	    }else{
		right = null;
	    }
	    

	    curNode.right = right;
	    curNode.left = left;
	    newStack.push(left);
	    newStack.push(right);
	    i++;

	    if(i >= array.length) break;
	    else if(oldStack.isEmpty()){
		//if we're done with this level
		oldStack = newStack;
		newStack = new ArrayDeque<>();
	    }
	}

	return root;
    }


    public static String getTreeAsString(TreeNode root){
	if(root == null) return "";
	
	StringBuilder str = new StringBuilder();
	
	Deque<TreeNode> oldStack = new ArrayDeque<>();
	Deque<TreeNode> newStack = new ArrayDeque<>();
	
	
	
	return str.toString();
    }

    public static void main(String[] args){
	System.out.println("Hello world");
	
    }

}
