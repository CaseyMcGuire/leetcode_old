package SumRootToLeafNumbers.Java;
import Testing.Java.*;
class Solution{

    public static int sumNumbers(TreeNode root){
	if(root == null) return 0;
	int[] total = new int[1];
	if(root.left == null && root.right == null) return root.val;
	if(root.left != null) getRootToLeafSum(total, 10 * root.val, root.left);
	if(root.right != null) getRootToLeafSum(total, 10 * root.val, root.right);
	return total[0];
    }


    public static void getRootToLeafSum(int[] total, int runningTotal, TreeNode curNode){
	if(curNode.right == null && curNode.left == null){
	    total[0] = total[0] + runningTotal + curNode.val;
	}
	else{
	    int curTotal = 10 * (runningTotal + curNode.val);
	    if(curNode.right != null) getRootToLeafSum(total, curTotal, curNode.right);
	    if(curNode.left != null) getRootToLeafSum(total, curTotal, curNode.left);
	}
    }

}
