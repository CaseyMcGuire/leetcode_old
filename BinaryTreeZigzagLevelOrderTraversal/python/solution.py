import sys
import unittest
sys.path.insert(0, '/home/caseymcguire/Documents/Code/leetcode/Testing/Python')
from TreeNode import *
from collections import deque

class Solution:
    # @param {TreeNode} root
    # @return {integer[][]}
    def zigzagLevelOrder(self, root):
        if root is None:
            return []
        iter = deque()
        iter.append(root)
        iter.append(None)
        answer = []
        cur_level = deque()
        left_to_right = True
        
        while True:
            cur_node = iter.popleft()

            #we've reached the end of level
            if cur_node is None:
                answer.append(list(cur_level))
                if not iter:
                    break
                cur_level = deque()
                left_to_right = not left_to_right
                iter.append(None)
                continue

            #Determine if we're zigging or zagging
            if left_to_right:
                cur_level.appendleft(cur_node.val)
            else:
                cur_level.append(cur_node.val)
            
            #append the current node's children if they exist for the next level
            if cur_node.right is not None:
                iter.append(cur_node.right)
            if cur_node.left is not None:
                iter.append(cur_node.left)
        return answer

class TestZigzagLevelOrderTraversal(unittest.TestCase):
    
    def setUp(self):
        self.trees = [
            (BinaryTree([]).root, []),
            (BinaryTree([1]).root, [[1]]),
            (BinaryTree([1,2]).root, [[1], [2]]),
            (BinaryTree([1,2,3]).root, [[1], [3,2]]),
            (BinaryTree([1,2,3,4]).root, [[1], [3,2], [4]]),
            (BinaryTree([1,2,3,4,5]).root, [[1], [3,2], [4,5]])
            
        ]

        self.solution = Solution()
        
    def test(self):
        for test_case in self.trees:
            answer = self.solution.zigzagLevelOrder(test_case[0])
            self.assertTrue(answer == test_case[1])

if __name__ == '__main__':
    unittest.main()
