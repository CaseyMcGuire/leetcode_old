package PathSum.Java;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Testing.Java.*;

public class TestCase{
    TreeNode tree1, nullTree, tree2, tree3, tree4, tree5, tree6;
   

    @Before
    public void setUp(){
	tree1 = TreeNode.createTreeFromArray(new Integer[]{1});
	nullTree = null;
	tree2 = TreeNode.createTreeFromArray(new Integer[]{1,2});
	tree3 = TreeNode.createTreeFromArray(new Integer[]{1,2,3});
	tree4 = TreeNode.createTreeFromArray(new Integer[]{-1,1});
	tree5 = TreeNode.createTreeFromArray(new Integer[]{1,2,3,4,5,6,7});
	tree6 = TreeNode.createTreeFromArray(new Integer[]{1,2,3,3, null, null, 1, null, null, null, null, null, null, null, 1});
    }

    @Test
    public void firstLevelTest(){
	assertTrue(Solution.hasPathSum(tree1, 1));
	assertFalse(Solution.hasPathSum(nullTree, 0));
	assertTrue(Solution.hasPathSum(tree4, 0));

    }

    @Test
    public void secondLevelTest(){
	assertTrue(Solution.hasPathSum(tree2, 3));
	assertTrue(Solution.hasPathSum(tree3, 3));
	assertTrue(Solution.hasPathSum(tree3, 4));
    }

    @Test
    public void thirdLevelTest(){
	assertTrue(Solution.hasPathSum(tree5, 7));
	assertTrue(Solution.hasPathSum(tree5, 8));
	assertTrue(Solution.hasPathSum(tree5, 10));
	assertTrue(Solution.hasPathSum(tree5, 11));
	assertTrue(Solution.hasPathSum(tree6, 6));
	
    }

}
