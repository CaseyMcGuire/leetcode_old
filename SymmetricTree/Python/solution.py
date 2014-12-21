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

# @param root, a tree node
# @return a boolean
def isSymmetric(root):
    if root is None:
        return True
    cur_right = []
    cur_left = []
    next_right = []
    next_left = []
    cur_right.append(root.right)
    cur_left.append(root.left)
    should_continue = True
    while should_continue:
        should_continue = False
        for i in range(0, len(cur_right)):
            
            if cur_right[i] is None and cur_left[-i-1] is not None:
                return False
            elif cur_right[i] is not None and cur_left[-i-1] is None:
                return False
            elif cur_right[i] is not None and cur_left[-i-1] is not None:
                if cur_right[i].val != cur_left[-i-1].val:
                    return False
            
            if cur_right[i] is not None:
                next_right.append(cur_right[i].left)
                next_right.append(cur_right[i].right)
                should_continue = True
            else:
                for j in range(0, 2):
                    next_right.append(None)
                       
            if cur_left[i] is not None:
                next_left.append(cur_left[i].left)
                next_left.append(cur_left[i].right)
                should_continue = True
            else:
                for j in range(0, 2):
                    next_left.append(None)

        cur_right = next_right
        cur_left = next_left
        next_right = []
        next_left = []
    
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
            BinaryTree([1,2,2,None,3,None,3]).root,
            BinaryTree([1,2,2,None,3,3,None,None,None,4,None,4]).root
        ]
        

    def test_passing_symmetric_tree(self):
        for tree in self.passing_trees:
            self.assertTrue(isSymmetric(tree))

    def test_failing_symmetric_tree(self):
        for tree in self.failing_trees:
            self.assertFalse(isSymmetric(tree))

if __name__ == '__main__':
    unittest.main()
