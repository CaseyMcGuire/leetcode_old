class Solution:
    #O(1) time
    #This doesn't seem to be in spirit of what the question asked but it works there doesn't seem
    #to be a better solution
    def deleteNode(self, node):
        if node is None or node.next is None:
            return
        node.val = node.next.val
        node.next = node.next.next
