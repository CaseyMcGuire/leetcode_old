import sys
sys.path.insert(0, '/home/caseymcguire/Documents/Code/leetcode/Testing/Python')

from ListNode import *
import unittest
import heapq

#Given k lists of size n, my solution runs in O(nlogk + k)
class Solution:
    # @param {ListNode[]} lists
    # @return {ListNode}
    def mergeKLists(self, lists):
        if lists is None:
            return None

        lists = filter(lambda x: x, lists)

        if not lists:
            return []
        
        heap = []
        head = None
        iter = None
        for i in lists:
            heapq.heappush(heap, (i.val, i))

        while len(heap) > 0:
            val, node = heapq.heappop(heap)

            if head is None:
                head = node
                iter = node
            else:
                iter.next = node
                iter = iter.next
            if node.next is not None:
                heapq.heappush(heap, (node.next.val, node.next))
        return head


class TestMergeKLists(unittest.TestCase):
    def setUp(self):
        self.lists = [
            [LinkedList([1]).head],
            [LinkedList([1]).head, LinkedList([0]).head],
            [LinkedList([1,1]).head, LinkedList([1]).head],
            [LinkedList([1,2]).head, LinkedList([1]).head],
            [LinkedList([1,2,3,4]).head, LinkedList([5,6,7,8]).head],
            [LinkedList([1,2,3,4]).head, LinkedList([1,2,3,4]).head],
            [LinkedList([1,2]).head, LinkedList([1,2]).head, LinkedList([1,2]).head],
        ]
        self.merged_lists = [
            LinkedList([1]).head,
            LinkedList([0,1]).head,
            LinkedList([1,1,1]).head,
            LinkedList([1,1,2]).head,
            LinkedList([1,2,3,4,5,6,7,8]).head,
            LinkedList([1,1,2,2,3,3,4,4]).head,
            LinkedList([1,1,1,2,2,2]).head,
        ]

    def test(self):
        solution = Solution()
        for i in range(len(self.lists)):
            output = solution.mergeKLists(self.lists[i])
            expected = self.merged_lists[i]
            while output is not None and expected is not None:
                self.assertTrue(output == expected)
                output = output.next
                expected = expected.next
            self.assertTrue(output is None)
            self.assertTrue(expected is None)

    def test_empty_list(self):
        solution = Solution()
        test = [None]
        expected_output = []
        output = solution.mergeKLists(test)
        self.assertTrue(output == expected_output)

if __name__ == '__main__':
    unittest.main()
