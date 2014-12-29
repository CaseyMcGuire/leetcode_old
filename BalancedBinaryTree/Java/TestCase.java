import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Testing.Java.*;

public class TestCase{

    TreeNode tree1, nullTree;

    @Before
    public void setup(){
	tree1 = TreeNode.createTreeFromArray(new Integer[]{1});
	nullTree = TreeNode.createTreeFromArray(null);
    }

    @Test
    public void edgeTest(){
	assertTrue(Solution.isBalanced(tree1));
	assertTrue(Solution.isBalanced(nullTree));
    }
}
