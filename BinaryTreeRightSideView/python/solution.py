from collections import deque
import sys
sys.path.insert(0, '/home/caseymcguire/Documents/Code/leetcode/Testing/Python')
from TreeNode import *
import unittest

class Solution:
    # #param {TreeNode} root
    # @return {integer[]}
    def rightSideView(self, root):
        if root is None:
            return []
        cur_level = deque()
        right_side = []
        cur_node = root
        cur_level.append(root)
        cur_level.append(None)
        while True:
            if cur_level[0] is None:
                right_side.append(cur_node.val)
            cur_node = cur_level.popleft()
            if cur_node is None:
                if not cur_level:
                    break
                else:
                    cur_level.append(None)
                    continue
            
            if cur_node.left is not None:
                cur_level.append(cur_node.left)
            if cur_node.right is not None:
                cur_level.append(cur_node.right)
        return right_side
        
class TestBinaryTreeRightSideView(unittest.TestCase):
    
    def setUp(self):
        #(root, answer)
        self.trees = [
            (BinaryTree([1]).root, [1]),
            (BinaryTree([1,2]).root, [1,2]),
            (BinaryTree([1,2,3]).root, [1,3]),
            (BinaryTree([1,None,3]).root, [1,3]),
            (BinaryTree([1,2,3,4]).root, [1,3,4]),
            (BinaryTree([1,2,3,4,5]).root, [1,3,5])
        ]
        
    def test_trees(self):
        solution = Solution()
        for test_case in self.trees:
            self.assertTrue(solution.rightSideView(test_case[0]) == test_case[1])

if __name__ == '__main__':
    unittest.main()
