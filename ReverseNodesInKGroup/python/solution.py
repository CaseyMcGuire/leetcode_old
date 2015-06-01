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
        #no need to reverse anything if k is low enough
        if k == 1 or k == 0:
            return head
        new_list_head = None#The head of the whole list
        prev_head = None#The old head of the previous k group
        cur_head = head
        while True:
            cur_vals = self._reverse_group(k, 1, cur_head)
            if cur_vals is None:
                if prev_head is not None:
                    prev_head.next = cur_head
                break
            next_head, next_group_head = cur_vals
            
            #get the new head pointer
            if new_list_head is None:
                new_list_head = next_head

            
            if prev_head is not None:
                prev_head.next = next_head
            prev_head = cur_head
            cur_head = next_group_head

        if new_list_head is None:
            return head
        else:
            return new_list_head
            

    def _reverse_group(self, k, cur_num, node):
        '''
        Recurses down the list until it reaches the kth node and returns the kth node the (k+1)th
        node as a tuple. As the recursion unwinds, it reverses the references of each node to the 
        previous node.
        '''
        if node is None:
            return None
        if k == cur_num:
            return (node, node.next)
        to_return = self._reverse_group(k, cur_num+1, node.next)
        if to_return is None:
            return None
        else:
            node.next.next = node
            return to_return
            

class TestReverseKLists(unittest.TestCase):
    def setUp(self):
        self.lists = [
            [None, 4, None],
            [LinkedList([]).head, 3, LinkedList([]).head],
            [LinkedList([1,2,3]).head, 0, LinkedList([1,2,3]).head],
            [LinkedList([1,2,3]).head, 1, LinkedList([1,2,3]).head],
            [LinkedList([1,2,3,4]).head, 2, LinkedList([2,1,4,3]).head],
            [LinkedList([1,2,3]).head, 2, LinkedList([2,1,3]).head],
            [LinkedList([1,2]).head, 2, LinkedList([2,1]).head],
            [LinkedList([1,2,3,4,5]).head, 2, LinkedList([2,1,4,3,5]).head],
            [LinkedList([1,2,3,4,5]).head, 3, LinkedList([3,2,1,4,5]).head]
        ]

    def test_k_groups(self):
        solution = Solution()
        for i in self.lists:
            iter = solution.reverseKGroup(i[0], i[1])
            answer = i[2]
            print_output(iter, answer)
            while iter is not None and answer is not None:
                self.assertTrue(iter == answer)
                iter = iter.next
                answer = answer.next
            self.assertTrue(iter is None)
            self.assertTrue(answer is None)


def print_output(output_head, answer_head):
    output_list = LinkedList()
    output_list.head = output_head
    answer_list = LinkedList()
    answer_list.head = answer_head
    print "======================="
    print "output: ",
    print output_list
    print "answer: ",
    print answer_list
    
        
if __name__ == '__main__':
    unittest.main()
