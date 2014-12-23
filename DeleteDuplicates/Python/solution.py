import sys
sys.path.insert(0, '/home/casey/Desktop/CodingProblems/leetcode/Testing/Python')#linux
sys.path.insert(0, '/Users/CaseyMcGuire/Desktop/leetcode/Testing/Python')#mac
from ListNode import *
import unittest

def deleteDuplicates(head):
   
    if head is None:
        return head
        
    cur_node = head
    next_node = head.next

    while True:
        if next_node is None:
            cur_node.next = None
            break
        elif cur_node.val != next_node.val:
            cur_node.next = next_node
            cur_node = next_node
        next_node = next_node.next
    return head



#TESTS
class TestDeleteDuplicates(unittest.TestCase):
    
    def setUp(self):
        
        self.duplicate_lists = [
            LinkedList(),
            LinkedList([1]),
            LinkedList([1,1]),
            LinkedList([1,2]),
            LinkedList([1,2,2]),
            LinkedList([1,2,2,3]),
            LinkedList([1,2,2,3,3]),
            LinkedList([1,1,2,2,3,3])

        ]

        self.deleted_lists = [
            LinkedList(),
            LinkedList([1]),
            LinkedList([1]),
            LinkedList([1,2]),
            LinkedList([1,2]),
            LinkedList([1,2,3]),
            LinkedList([1,2,3]),
            LinkedList([1,2,3])
        ]

        self.fail_duplicate_lists = [
            LinkedList(),
            LinkedList([1]),
            LinkedList([1,2])

        ]

        self.fail_deleted_lists = [
            LinkedList([1]),
            LinkedList([1,None]),
            LinkedList([1,2,2])
        ]


    def test_passing_lists(self):
        for i in range(len(self.duplicate_lists)):
            deleteDuplicates(self.duplicate_lists[i].head)
            self.assertTrue(self.duplicate_lists[i] == self.deleted_lists[i])

            
    def test_failing_lists(self):
        for i in range(len(self.fail_duplicate_lists)):
            deleteDuplicates(self.fail_duplicate_lists[i].head)
            self.assertFalse(self.fail_duplicate_lists[i] == self.fail_deleted_lists[i])


if __name__ == '__main__':
    unittest.main()
