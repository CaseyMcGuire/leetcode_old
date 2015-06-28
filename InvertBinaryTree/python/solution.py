from collections import deque
from TreeNode import *

class Solution:
    # @param {TreeNode} root
    # @return {TreeNode}
    def invertTree(self,root):
        if root is None:
            return
        self._invert_tree(root)
        return root

    def _invert_tree(self, node):
        if node is None:
            return
        temp = node.right
        node.right = node.left
        node.left = temp
        self._invert_tree(node.right)
        self._invert_tree(node.left)
