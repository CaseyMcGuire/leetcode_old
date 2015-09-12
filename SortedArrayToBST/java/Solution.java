import java.util.*;

public class Solution {

    //Solution is O(n) time and O(lg n) space where n is the length of the input array

    /* 
       Returns root to balanced binary tree containg all elements in the passed sorted array.
     */
    public TreeNode sortedArrayToBST(final int[] nums) {
	if(nums == null || nums.length == 0) return null;
	final TreeNode root = new TreeNode(nums[nums.length/2]);
	root.left = sortedSubarrayToBST(nums, 0, nums.length/2 - 1);
	root.right = sortedSubarrayToBST(nums, nums.length/2 + 1, nums.length - 1);
	return root;
    }

    /*
      Returns the root to a balanced binary search tree containing all elements between the indices
      start and end in the input array.
     */
    public TreeNode sortedSubarrayToBST(final int[] nums, final int start, final int end) {
	if(start > end) return null;
	final int median = (start + end) >>> 1;
	final TreeNode curNode = new TreeNode(nums[median]);
	curNode.left = sortedSubarrayToBST(nums, start, median - 1);
	curNode.right = sortedSubarrayToBST(nums, median + 1, end);
	return curNode;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	TreeNode node = s.sortedArrayToBST(new int[]{1,2,3,4,5});
	System.out.println(TreeNode.getTreeAsString(node));
	node = s.sortedArrayToBST(new int[]{1,2,3,4,5,6,7});
	System.out.println(TreeNode.getTreeAsString(node));
    }
}
