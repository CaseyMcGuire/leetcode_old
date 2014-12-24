import sys
sys.path.insert(0, '/home/casey/Desktop/CodingProblems/leetcode/Testing/Python')#linux
sys.path.insert(0, '/Users/CaseyMcGuire/Desktop/leetcode/Testing/Python')#mac

from ListNode import *
import unittest

def removeNthFromEnd(head, n):
    to_return = head
    should_delete_head = False
    behind = head
    front = head
    
    for i in range(n):
        front = front.next
        if front is None:
            should_delete_head = True
            break

    if front is not None:
        front = front.next
    
    #print "Should delete head" + str(should_delete_head)
    while front is not None:
        front = front.next
        behind = behind.next
        
    if should_delete_head:
        to_return = to_return.next
    elif behind.next is not None:
        behind.next = behind.next.next
    else:
        behind.next = None

    return to_return

class TestRemoveNthFromEnd(unittest.TestCase):
    def setUp(self):
       self.lists = [
           #[old_list, remove_index, new_list]
           
           [LinkedList([1,2]), 1, LinkedList([1])],
           [LinkedList([1,2,3]), 1, LinkedList([1,2])],
           [LinkedList([1,2,3]), 2, LinkedList([1,3])],
           [LinkedList([1,2,3,4]), 1, LinkedList([1,2,3])],
           [LinkedList([1,2,3,4]), 2, LinkedList([1,2,4])],
           [LinkedList([1,2,3,4]), 3, LinkedList([1,3,4])],
           [LinkedList([1,2,3,4,5]), 1, LinkedList([1,2,3,4])],
           [LinkedList([1,2,3,4,5]), 2, LinkedList([1,2,3,5])],
           [LinkedList([1,2,3,4,5]), 3, LinkedList([1,2,4,5])],
           [LinkedList([1,2,3,4,5]), 4, LinkedList([1,3,4,5])],


       ]

       self.remove_head_list = [
           [LinkedList([1]), 1, LinkedList([])],
           [LinkedList([1,2]), 2, LinkedList([2])],
           [LinkedList([1]), 1, LinkedList([])],
           [LinkedList([1,2,3]), 3, LinkedList([2,3])],
           [LinkedList([1,2,3,4]), 4, LinkedList([2,3,4])],
           [LinkedList([1,2,3,4,5]), 5, LinkedList([2,3,4,5])],

       ]

    def test_remove_head(self):
        for i in self.remove_head_list:
           
            removeNthFromEnd(i[0].head, i[1])
            i[0].head = i[0].head.next#the head pointer doesn't change so we have to do this to compare the lists
            self.assertTrue(i[0] == i[2])

    def test_other_remove(self):
        for i in self.lists:
            removeNthFromEnd(i[0].head, i[1])
            self.assertTrue(i[0] == i[2])
            

if __name__ == '__main__':
    unittest.main()
