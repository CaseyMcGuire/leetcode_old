import sys
sys.path.insert(0, '/home/casey/Desktop/CodingProblems/leetcode/Testing/Python')#linux
sys.path.insert(0, '/Users/CaseyMcGuire/Desktop/leetcode/Testing/Python')#mac

from TreeNode import *
import unittest
import collections

def levelOrderBottom(root):
    '''
    Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
    @param{TreeNode} The root.
    @return {list} A list containing each level of the tree as a list.
    '''
    if root is None:
        return []

    master_list = collections.deque()
    cur_level = collections.deque()
    
    cur_level.appendleft(root)
    master_list.appendleft(get_list_of_values(cur_level))
    cur_level.append(None)

    while True:
        cur_node = cur_level.popleft()

        #if the queue is empty, we can break because the last element *has* to be None
        if not cur_level:
            break
        #if we reach None, that means that all the nodes for the current level have been parsed
        elif cur_node is None:
            master_list.appendleft(get_list_of_values(cur_level))
            cur_level.append(None)
        else:
            #if the node is not None, add its children if they're also not none
            if cur_node.left is not None:
                cur_level.append(cur_node.left)
            if cur_node.right is not None:
                cur_level.append(cur_node.right)

    return list(master_list)


def get_list_of_values(deque):
    '''
    Given a deque of TreeNodes, returns a list containing those nodes' values.
    @param {deque} The deque of TreeNodes
    @return {list} A list of integers representing the values of the TreeNodes in the same order as in the deque
    '''
    list_to_return = []
    for node in deque:
        list_to_return.append(node.val)

    return list_to_return
    
    
class TestLevelOrderTraversal(unittest.TestCase):
    
    def setUp(self):
        self.tree_roots = [
            [BinaryTree([1]).root, [[1]]],
            [BinaryTree([1,2]).root, [[2],[1]]],
            [BinaryTree([1,2,3]).root, [[2,3],[1]]],
            [BinaryTree([3,9,20,None, None, 15, 7]).root, [[15,7],[9,20],[3]]]
        ]

    def test_passing_trees(self):

        for test in self.tree_roots:
            level_order = levelOrderBottom(test[0])

            self.assertTrue(len(level_order) == len(test[1]))
            
            for i in range(len(level_order)):
                self.assertTrue(len(level_order[i]) == len(test[1][i]))
                for j in range(len(level_order[i])):
                    self.assertTrue(level_order[i][j] == test[1][i][j])
                
                           
if __name__ == '__main__':
    unittest.main()

            

