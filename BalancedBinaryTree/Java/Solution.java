import Testing.Java.*;
class Solution{
    
    
    public static boolean isBalanced(TreeNode root) {
        if(root == null) return true;
	return isSameHeight(getHeight(root.left, 1), getHeight(root.right, 1));
    }
    
    public static int getHeight(TreeNode node, int height){
        if(node == null) return height - 1;
        int left = getHeight(node.left, height + 1);
        int right = getHeight(node.right, height + 1);
        if(!isSameHeight(left, right)) return -1;
        else return left > right ? left : right;
    }
    
    
    private static boolean isSameHeight(int h1, int h2){
        if(h1 < 0 || h2 < 0) return false;
        if(h1 == h2 || h1 - 1 == h2 || h1 + 1 == h2)    return true;
        else                                            return false;
    }
}
