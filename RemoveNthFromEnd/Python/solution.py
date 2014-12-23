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
        
        while front is not None:
            front = front.next
            behind = behind.next
        
        if should_delete_head:
            to_return = to_return.next
        else:
            behind.next = behind.next.next
        return to_return

class TestRemoveNthFromEnd(unittest.TestCase):
    def setUp(self):
        pass
