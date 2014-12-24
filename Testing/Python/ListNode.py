class LinkedList:
    def __init__(self, list = None):
        self.head = None
        if list is not None:
            self.__create_linked_list_from_list(list)

    def __create_linked_list_from_list(self, list):
        '''
        Creates a linked list from the elements in the list parameter
        '''
        if not list:
            return
            
        self.head = ListNode(list[0])
        
        cur_node = self.head
        
        for i in range(1, len(list)):
            cur_node.next = ListNode(list[i])
            cur_node = cur_node.next

    def __str__(self):
        '''
        Returns a reader-friendly version of this linked list
        @return {String} Entire linked-list as a String with head being the leftmost value and the 
        tail being the right most value. Arrows (->) are between each node.
        '''
        cur_node = self.head
        list_str = []
        
        arrow = "->"
        while cur_node is not None:
            list_str.append("%s%s"%(cur_node, arrow))
            cur_node = cur_node.next

        list_str.append("None")
        print list_str
        return ''.join(list_str)

    def __eq__(self, other_list):
        '''
        Returns whether this list and the passed linked list are equivalent. That is, it returns true
        if they are of the same length and each node is equivalent to the corresponding node in the 
        other list.
        @param {LinkedList} The other linked list
        @param {Boolean} True if the lists are the same, False otherwise
        '''
        if other_list is None:
            return false
        fir_node = self.head
        sec_node = other_list.head

        while fir_node is not None and sec_node is not None:
            if fir_node.val != sec_node.val:
                return False
            fir_node = fir_node.next
            sec_node = sec_node.next
        
        if fir_node is None and sec_node is None:
            return True
        else:
            return False
        


class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None

    def __str__(self):
        return '{self.val}'.format(self=self)

    def __eq__(self, other):
        return self.val == other.val

if __name__ == '__main__':
    print "Here be dragons"
    
