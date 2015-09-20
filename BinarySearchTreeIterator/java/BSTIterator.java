import java.util.Deque;
import java.util.LinkedList;

class BSTIterator {

    private final Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
	stack = new LinkedList<>();
	TreeNode curNode = root;
	while(curNode != null) {
	    stack.push(curNode);
	    curNode = curNode.left;
	}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
	return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
	TreeNode cur = stack.pop();
	if(cur.right != null) {
	    TreeNode iter = cur.right;
	    while(iter != null) {
		stack.push(iter);
		iter = iter.left;
	    }
	}
	return cur.val;
    }
    
}
