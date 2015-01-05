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
	if(array.length == 1){
	    return root;
	}
	Deque<TreeNode> oldStack = new LinkedList<>();
	Deque<TreeNode> newStack = new LinkedList<>();
	oldStack.push(root);

	int i = 1;
	while(true){
	    TreeNode curNode = oldStack.pollLast();
	    System.out.println(curNode);
	    
	    TreeNode left = null;
	    TreeNode right= null;
	    if(curNode != null){
		//get our left node
		if(array[i] != null){
		    left = new TreeNode(array[i]);
		}
		
		
		//get our right node
		if(i + 1 < array.length && array[i + 1] != null){
		    right = new TreeNode(array[i + 1]);
		}
		
		curNode.right = right;
		curNode.left = left;
	    }
	    i += 2;
	    
	    //  System.out.println(left);
	    //System.out.println(right);
	    	   
	    newStack.push(left);
	    newStack.push(right);
	   

	    if(i >= array.length) break;
	    else if(oldStack.isEmpty()){
		//if we're done with this level
		oldStack = newStack;
		newStack = new LinkedList<>();
	    }
	}

	return root;
    }


    public static String getTreeAsString(TreeNode root){
	if(root == null) return "";
	
	StringBuilder str = new StringBuilder();
	
	Deque<TreeNode> oldStack = new LinkedList<>();
	Deque<TreeNode> newStack = new LinkedList<>();
	oldStack.push(root);
	str.append(root + "\n");
	boolean shouldContinue = false;

	while(true){
	    TreeNode cur = oldStack.pollLast();

	    TreeNode right = null;
	    TreeNode left = null;

	    if(cur == null){
		str.append("##");
	    }else{
		
		if(cur.left != null){
		    str.append(cur.left.val);
		    shouldContinue = true;
		    left = cur.left;
		}else{
		    str.append("#");
		}

		//	System.out.println(cur.right);

		if(cur.right != null){
		    str.append(cur.right.val);
		    shouldContinue = true;
		    right = cur.right;
		}else{
		    str.append("#");
		}
	    }
	    
	    newStack.push(left);
	    newStack.push(right);
	    if(oldStack.isEmpty()){
		if(!shouldContinue) break;
		str.append("\n");
		shouldContinue = false;
		oldStack = newStack;
		newStack = new LinkedList<>();
	    }
	}
	
	
	return str.toString();
    }

    public static void main(String[] args){
	TreeNode tree = createTreeFromArray(new Integer[]{1,2,3,4,5,6});
	System.out.println(getTreeAsString(tree));
	
    }

}
