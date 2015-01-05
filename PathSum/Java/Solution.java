package PathSum.Java;
import Testing.Java.*;
class Solution{

    public static boolean hasPathSum(TreeNode root, int sum){
	if(root == null) return false;
	//	System.out.println(TreeNode.getTreeAsString(root));
	if(root.left == null && root.right == null){
	    if(root.val == sum) return true;
	    else return false;
	}
	if(hasPathSum(root.left, root.val, sum)) return true;
	else return hasPathSum(root.right, root.val, sum);
    }

    private static boolean hasPathSum(TreeNode node, int runningTotal, int target){
	//	System.out.println("node value is " + node);
	//	System.out.println(TreeNode.getTreeAsString(node));

	if(node == null) return false;
	int newRunningTotal = runningTotal + node.val;
	if(node.right == null && node.left == null){
	    if(newRunningTotal == target) return true;
	    else return false;
	}
	//	System.out.println("RunningTotal is " + newRunningTotal);

	boolean leftSubtreeEqualsSum = hasPathSum(node.left, newRunningTotal, target);

	if(leftSubtreeEqualsSum) return true;
	else return hasPathSum(node.right, newRunningTotal, target);
    }
}
