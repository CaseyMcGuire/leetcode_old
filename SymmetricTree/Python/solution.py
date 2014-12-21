#Definition for a binary tree node
#class TreeNode:
#    def __init__(self, x):
#        self.val = x
#        self.left = None
#        self.right = None
#
import sys
sys.path.insert(0, '/home/casey/Desktop/CodingProblems/leetcode/Testing/Python')#linux
sys.path.insert(0, '/Users/CaseyMcGuire/Desktop/leetcode/Testing/Python')#mac
#print sys.path
from TreeNode import *
import unittest

#Solution runs in O(n) time (where n is the number of non-null nodes) and uses O(n) space (I think)

# @param root, a tree node
# @return a boolean
def isSymmetric(root):
    if root is None:
        return True

    cur_right = {}
    cur_left = {}
    
    next_right = {}

    if root.right is None and root.left is None: 
        return True
    elif root.right is None and root.left is not None:
        return False
    elif root.right is not None and root.left is None:
        return False
   
    cur_right[0] = root.right
    cur_left[0] = root.left
    should_continue = True

    while should_continue:
        should_continue = False
        for key in cur_left.keys():
            if key not in cur_right:
                return False
            elif cur_right[key].val != cur_left[key].val:
                return False
            
            if cur_left[key].left is not None:
                cur_left[2*key+1] = cur_left[key].left
                should_continue = True
            if cur_left[key].right is not None:
                cur_left[2*key + 2] = cur_left[key].right
                should_continue = True
                
            if cur_right[key].left is not None:
                next_right[2*key+2] = cur_right[key].left
                should_continue = True
            if cur_right[key].right is not None:
                next_right[2*key+1] = cur_right[key].right
                should_continue = True
                
            del cur_right[key]
            del cur_left[key]

        if len(cur_right.keys()) != 0:
            return False
        cur_right = next_right
        next_right = {}
        
       
    return True

class TestSymmetricTree(unittest.TestCase):
    
    def setUp(self):
        self.passing_trees = [
            BinaryTree([]).root,
            BinaryTree([1]).root,
            BinaryTree([1,2,2]).root,
            BinaryTree([1,2,2,None,3,3,None]).root,
            BinaryTree([1,2,2,None,3,3,None,None,None,4,None,None,4]).root
        ]
        self.failing_trees = [
            BinaryTree([1,2]).root,
            BinaryTree([1,None,2]).root,
            BinaryTree([1,2,3]).root,
            BinaryTree([1,2,2,None,3,None,3]).root,
            BinaryTree([1,2,2,None,3,3,None,None,None,4,None,4]).root,
            BinaryTree([2,3,3,4,None,5,4]).root
        ]
        

    def test_passing_symmetric_tree(self):
        self.assertTrue(isSymmetric(self.passing_trees[0]))
        self.assertTrue(isSymmetric(self.passing_trees[1]))
        self.assertTrue(isSymmetric(self.passing_trees[2]))
        self.assertTrue(isSymmetric(self.passing_trees[3]))
        self.assertTrue(isSymmetric(self.passing_trees[4]))


    def test_failing_symmetric_tree(self):
        for tree in self.failing_trees:
            self.assertFalse(isSymmetric(tree))

if __name__ == '__main__':
    #dict = {1:1}
    #print dict[2]
    unittest.main()
