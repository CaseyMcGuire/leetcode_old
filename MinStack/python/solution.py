class MinStack:

    def __init__(self):
        self.stack = []
        self.cur_min = None
    
    #param x, an integer
    # @return an integer
    def push(self, x):
        if self.cur_min is None or self.cur_min > x:
            temp = self.cur_min
            self.cur_min = x
            self.stack.append((x, temp))
        else:
            self.stack.append((x, self.cur_min))

    #return nothing
    def pop(self):
        x, old_min = self.stack.pop()
        self.cur_min = old_min
        return x

    def top(self):
        x, y = self.stack[-1]
        return x

    def getMin(self):
        return self.cur_min 



        
