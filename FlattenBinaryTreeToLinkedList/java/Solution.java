
class Solution {

    //O(n) time and O(h) space where h is the height of the tree
    public void flatten(TreeNode root) {
	if(root == null) return;
	TreeNodeWrapper wrapper = new TreeNodeWrapper(root);
	TreeNode tempRight = root.right;

	flatten(root.left, wrapper);
	root.left = null;
	flatten(tempRight, wrapper);
    }

    private void flatten(TreeNode curNode, TreeNodeWrapper list) {
	if(curNode == null) return;

	TreeNode tempRight = curNode.right;
	list.curNode.right = curNode;
	list.curNode = list.curNode.right;
	
	flatten(curNode.left, list);
	curNode.left = null;
	flatten(tempRight, list);
    }

    //Essentially a hack to get a pointer in Java
    private class TreeNodeWrapper {
	public TreeNode curNode;
	public TreeNodeWrapper(TreeNode head) {
	    curNode = head;
	}
    }

}
