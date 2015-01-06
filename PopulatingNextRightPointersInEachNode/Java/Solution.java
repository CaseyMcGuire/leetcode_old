import java.util.*;


public class Solution{

    public static void connect(TreeLinkNode root){
	if(root == null) return;
	

	Deque<TreeLinkNode> oldQueue = new LinkedList<>();
	Deque<TreeLinkNode> newQueue = new LinkedList<>();

	oldQueue.push(root);

	while(true){
	    TreeLinkNode cur = oldQueue.removeFirst();
	    if(cur == null) return;
	    newQueue.addLast(cur.left);
	    newQueue.addLast(cur.right);

	    cur.next = oldQueue.peekFirst();
	    if(oldQueue.isEmpty()){
		oldQueue = newQueue;
		newQueue = new LinkedList<>();
	    }
	}
    }


    public class TreeLinkNode{

	int val;
	TreeLinkNode left, right, next;
	public TreeLinkNode(int x){
	    val = x;
	}

    }

}
