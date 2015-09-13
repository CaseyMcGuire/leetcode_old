public class Solution {
    
    //runtime O(n) where n is the number of nodes in the tree
    //I guess you can assume both nodes are in the tree
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	if(root == null) return null;
	else if(root.val >= p.val && root.val <= q.val ||
		root.val <= p.val && root.val >= q.val) {
	    return root;
	}
	else if(root.val > p.val && root.val > q.val) {
	    return lowestCommonAncestor(root.left, p, q);
	}
	else {
	    return lowestCommonAncestor(root.right, p, q);
	}
    }

    public static void runTest(TreeNode result, TreeNode expected) {
	if(result == null && expected != null) {
	    System.out.println("FAIL. Expected: " + expected.val + " Result: null");
	}
	else if(result != null && expected == null) {
	    System.out.println("FAIL. Expected: null Result: " + result.val);
	}
	else if(result.val  == expected.val) {
	    System.out.println("PASS");
	} else {
	    System.out.println("FAIL. Expected: " + expected + " Result: " + result);
	}
    }

    public static void main(String[] args) {
	TreeNode test1 = TreeNode.createTreeFromArray(new Integer[]{6,2,8,0,4,7,9,null,null,3,5});
	Solution s = new Solution();
	runTest(s.lowestCommonAncestor(test1, new TreeNode(2), new TreeNode(8)), new TreeNode(6));
	runTest(s.lowestCommonAncestor(test1, new TreeNode(3), new TreeNode(5)), new TreeNode(4));

    }
}
