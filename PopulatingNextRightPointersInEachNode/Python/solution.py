def connect(root):
    '''
    Given the root of perfect binary tree where each node has next pointer that points
    to null, this function makes each node point to the node directly to the right of 
    it on the same level.
    @param {TreeLinkNode} The root of a perfect binary tree.
    @return Nothing
    '''
    if root is None:
        return
    head = root#The leftmost node on any given level
    bottom = None#The pointer to walk along the bottom level thats being connected
    top = None#The pointer to walk along the top level thats already connected
    while head.left is not None:
        top = head
        
        while top is not None:
            if bottom is None:
                bottom = top.left
            else:
                bottom.next = top.left
                bottom = bottom.next
            
            bottom.next = top.right
            bottom = bottom.next
            top = top.next
        
        head = head.left
        bottom = None                            
