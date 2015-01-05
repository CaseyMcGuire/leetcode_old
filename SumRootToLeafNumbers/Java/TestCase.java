package SumRootToLeafNumbers.Java;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Testing.Java.*;

public class TestCase{

    TreeNode tree1, tree2, tree3, tree4, tree5, tree6, tree7, tree8;


    @Before
    public void setUp(){
	tree1 = TreeNode.createTreeFromArray(new Integer[]{1});
	tree2 = TreeNode.createTreeFromArray(new Integer[]{1,2});
	tree3 = TreeNode.createTreeFromArray(new Integer[]{1,2,3});
	tree4 = TreeNode.createTreeFromArray(new Integer[]{1,2,3,4});
	tree5 = TreeNode.createTreeFromArray(new Integer[]{1,2,3,4,null,null,5});
	tree6 = TreeNode.createTreeFromArray(new Integer[]{1,2,null,4});
	tree7 = TreeNode.createTreeFromArray(new Integer[]{1,2,null,4,3});
	tree8 = TreeNode.createTreeFromArray(new Integer[]{1,null,5});
    }

    @Test
    public void easyTest(){
	assertTrue(Solution.sumNumbers(tree1) == 1);
	assertTrue(Solution.sumNumbers(tree2) == 12);
	assertTrue(Solution.sumNumbers(tree3) == 25);
	assertTrue(Solution.sumNumbers(tree4) == 137);
	assertTrue(Solution.sumNumbers(tree5) == 259);
	assertTrue(Solution.sumNumbers(tree6) == 124);
	assertTrue(Solution.sumNumbers(tree7) == 247);
	System.out.println("----------------");
	System.out.println(Solution.sumNumbers(tree8));
	assertTrue(Solution.sumNumbers(tree8) == 15);
    }
    
}
