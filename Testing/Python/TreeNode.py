
class BinaryTree:
    def __init__(self, list = None):
        self.root = None
        if list is not None:
            self.__create_tree_from_list(list)

    
                        
    def __create_tree_from_list(self, list_of_nodes):
        '''
        Creates a BinaryTree from the list of nodes in level order.
        Note: you must specify *every* node on a given level, even if its nil.
        
        '''
        if len(list_of_nodes) == 0:
            return 

        #if the root is null, you can't reach the rest of the nodes
        if list_of_nodes[0] is not None:
            self.root = TreeNode(list_of_nodes[0])
        if list_of_nodes[0] is None or len(list_of_nodes) == 1:
            return
                
        cur_level = []
        next_level = []
        cur_level.append(self.root)
        i = 1
        while cur_level:
            cur = cur_level.pop(0)
            

            if cur is None:
                for x in range(2):
                    next_level.append(None)
                    i += 1
            else:    
                if list_of_nodes[i] is not None:
                    cur.left = TreeNode(list_of_nodes[i])
                else:
                    cur.left = None
                next_level.append(cur.left)
                i += 1
                if i == len(list_of_nodes):
                    return

                if list_of_nodes[i] is not None:
                    cur.right = TreeNode(list_of_nodes[i])
                else:
                    cur.right = None
                next_level.append(cur.right)
                i += 1
                if i == len(list_of_nodes):
                    return

            if not cur_level:
                cur_level = next_level
                next_level = []
            
    def __str__(self):
        '''
        Returns a level-order representation of the tree
        '''
        string = []
        cur_level = []
        next_level = []
        should_continue = False
        cur_level.append(self.root)
        string.append(str(self.root))
        string.append('\n')
        while True:
            cur = cur_level.pop(0)
            
            if cur is None:
                for i in range(2):
                    next_level.append(None)
                    string.append(str(None))
            else:
                #check left node
                if cur.left is not None:
                    should_continue = True
                
                next_level.append(cur.left)
                string.append(str(cur.left))

                #check right node
                if cur.right is not None:
                    should_continue = True

                next_level.append(cur.right)
                string.append(str(cur.right))
                    
                    
            #No more nodes            
            if not should_continue and not cur_level:
                break

            if not cur_level:
                string.append('\n')
                cur_level = next_level
                next_level = []
                should_continue = False
        return ''.join(string)

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.right = None
        self.left = None
        
    def __str__(self):
        return '{self.val}'.format(self=self)

if __name__ == '__main__':
    test = [0,1,2,3,4,5,6,7,8]
    my_tree = BinaryTree(test)
    print "my Tree"
    print my_tree
    test2 = [0, None, 1, None, None, 2, 3, None, None, None, None, None, 5]
    my_tree2 = BinaryTree(test2)
    print "my tree2"
    print my_tree2
