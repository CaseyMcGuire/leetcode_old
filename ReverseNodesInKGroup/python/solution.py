import sys
sys.path.insert(0, '/home/caseymcguire/Documents/Code/leetcode/Testing/Python')
from ListNode import *
import unittest

class Solution:
    #@param{ListNode} head
    #@param {integer} k
    #@return {ListNode}
    def reverseKGroup(self, head, k):
        if head is None:
            return None
        new_head = None
        

    def _reverse_group(k, cur_num, node):
        if node is None:
            return None
        if k == cur_num:
            return (node, node.next)
        to_return = self._reverse_group(k, cur_num, node.next)
        if to_return is None:
            return None
        else:
            node.next.next = node
            
        


class TestReverseKLists(unittest.TestCase):
    def setUp(self):
        self.lists = [
            
        ]
        
