
class Queue(object):
    
    def __init__(self):
        self.right = []
        self.left = []
        
    def push(self, x):
        self.right.append(x)
        

    def pop(self):
        if len(self.right) == 0:
            return None
        self.__swish(self.right, self.left)
        result = self.left.pop()
        self.__swish(self.left, self.right)
        return result
         
    def peek(self):
        if len(self.right) == 0:
            return None
        self.__swish(self.right, self.left)
        result = self.left[-1]
        self.__swish(self.left, self.right)
        return result

    def __swish(self, stack1, stack2):
        while len(stack1) > 0:
            stack2.append(stack1.pop())


    def empty(self):
        return len(self.right) == 0
