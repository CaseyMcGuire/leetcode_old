
public class Solution{

    public static void connect(TreeLinkNode root){
	if(root == null){
	    return;
	}
	
	TreeLinkNode head = root;
	TreeLinkNode top = null;
	TreeLinkNode bottom = null;

	while(true){
	    top = head;
	    //find left most node on unconnected level
	    while(bottom == null){
		//if the top is null and the bottom is null, we've reached the end
		if(top == null) return;
		
		//otherwise, walk along the top trying to find the leftmost node
		if(top.left != null)bottom = top.left;
		else if(top.right != null) bottom = top.right;
		else top = top.next;
	    }
	    
	    //the leftmost node for the next level
	    head = bottom;

	    //walk across the top level, connecting the bottom level
	    while(top != null){
		
		//connect left node if it isn't null and isn't the leftmost node
		if(top.left != null && top.left != bottom){
		    bottom.next = top.left;
		    bottom = bottom.next;
		}

		//connect the right node if it isn't null and isn't the leftmost node
		if(top.right != null && top.right != bottom){
		    bottom.next = top.right;
		    bottom = bottom.next;
		}
				
		top = top.next;
	    }
	    
	    bottom = null;
	    
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
